package fr.formation.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import fr.formation.dao.*;
import fr.formation.entities.*;

@ControllerAdvice
@RestController
@RequestMapping("/api")
public class TestRestController extends ResponseEntityExceptionHandler {

    @Autowired
    private ICiviliteJpaRepository civiliteRepo;

    @Autowired
    private IUtilisateurJpaRepository utilisateurRepo;

    @GetMapping("/civilites/all")
    public List<Civilite> getCivilites() {
	return civiliteRepo.findAll();
    }

    @GetMapping("/utilisateur/{id}")
    public Utilisateur getUtilisateur(@PathVariable("id") Long id) {
	return utilisateurRepo.getOne(id);
    }

    @PutMapping("/utilisateur/creer")
    public Utilisateur creer(@Valid @RequestBody Utilisateur utilisateur,
	    BindingResult result) {
	if (result.hasErrors()) {
	    throw new ApiValidationException();
	}
	return utilisateurRepo.save(utilisateur);
    }

    @PostMapping("/utilisateur/modifier")
    public Utilisateur modifier(@Valid @RequestBody Utilisateur utilisateur) {
	return utilisateurRepo.save(utilisateur);
    }

    @DeleteMapping("/utilisateur/supprimer/{id}")
    public void supprimer(@PathVariable("id") Long id) {
	utilisateurRepo.deleteById(id);
    }

    @SuppressWarnings("unused")
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
	    MethodArgumentNotValidException ex, HttpHeaders headers,
	    HttpStatus status, WebRequest request) {
	ErrorDetails errorDetails = new ErrorDetails(
		ex.getBindingResult().getAllErrors());
	return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
