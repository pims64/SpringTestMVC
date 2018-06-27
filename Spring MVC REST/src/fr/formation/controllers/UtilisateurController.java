package fr.formation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import fr.formation.dao.*;
import fr.formation.entities.*;

@Controller
@RequestMapping("/utilisateurcontroller")
public class UtilisateurController {

    @Autowired
    private ICiviliteJpaRepository civiliteRepo;

    @Autowired
    private IUtilisateurJpaRepository utilisateurRepo;

    @GetMapping("/goToMenu")
    public String goToMenu() {
	return "menuUtilisateur";
    }

    @GetMapping("/goToCreer")
    public String goToCreer(Model model) {
	List<Civilite> civilites = civiliteRepo.findAll();
	model.addAttribute("usr", new Utilisateur());
	model.addAttribute("civilites", civilites);
	model.addAttribute("roles", RoleUtilisateur.values());
	return "creerUtilisateur";
    }

    @PostMapping("/creer")
    public String creer(
	    @Valid @ModelAttribute(value = "usr") Utilisateur utilisateur,
	    BindingResult result, Model model) {
	if (!result.hasErrors()) {
	    encodePassword(utilisateur);
	    utilisateurRepo.save(utilisateur);
	    model.addAttribute("usr", new Utilisateur());
	}
	List<Civilite> civilites = civiliteRepo.findAll();
	model.addAttribute("civilites", civilites);
	return "creerUtilisateur";
    }

    @GetMapping("/goToModifier/{id}")
    public String goToModifier(@PathVariable("id") Long id, Model model) {
	Utilisateur utilisateur = utilisateurRepo.getOne(id);
	model.addAttribute("usr", utilisateur);
	List<Civilite> civilites = civiliteRepo.findAll();
	model.addAttribute("civilites", civilites);
	model.addAttribute("roles", RoleUtilisateur.values());
	return "modifierUtilisateur";
    }

    @PostMapping("/modifier")
    public String modifier(
	    @Valid @ModelAttribute(value = "usr") Utilisateur utilisateur,
	    BindingResult result, Model model) {
	if (!result.hasErrors()) {
	    encodePassword(utilisateur);
	    utilisateurRepo.save(utilisateur);
	}
	List<Civilite> civilites = civiliteRepo.findAll();
	model.addAttribute("civilites", civilites);
	return "modifierUtilisateur";
    }

    @GetMapping("/afficherListe")
    public String afficherListe(Model model) {
	List<Utilisateur> utilisateurs = utilisateurRepo.findAll();
	model.addAttribute("utilisateurs", utilisateurs);
	return "listeUtilisateur";
    }

    @Secured("ROLE_ADMIN")
    @SuppressWarnings("unused")
    @GetMapping("/supprimer/{id}")
    public String supprimer(@PathVariable("id") Long id, Model model) {
	utilisateurRepo.deleteById(id);
	return "redirect:/utilisateurcontroller/afficherListe";
    }

    private static void encodePassword(Utilisateur utilisateur) {
	String rawPassword = utilisateur.getMotDePasse();
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	String encodedPassword = encoder.encode(rawPassword);
	utilisateur.setMotDePasse(encodedPassword);
    }
}
