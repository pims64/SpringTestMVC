package fr.formation.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.formation.dao.ICredentialsJpaRepository;
import fr.formation.entities.*;

@Controller
@RequestMapping("/hellocontroller")
public class HelloController {

    @Autowired
    private ICredentialsJpaRepository credentialsJpaRepository;

    @RequestMapping("/hello")
    public String hello(Model model) {
	model.addAttribute("message", "Hello Spring MVC World!");
	return "hello";
    }

    @RequestMapping("/bye")
    public String bye(
	    @RequestParam(value = "username", required = true) String username,
	    Model model) {
	model.addAttribute("message", "Bye " + username + "!");
	return "bye";
    }

    @RequestMapping(value = "/seeYou", method = RequestMethod.GET)
    public String seeYou(
	    @RequestParam(value = "username", required = false) String username,
	    Model model) {
	model.addAttribute("message", "See you " + username + "!");
	return "seeYou";
    }

    @GetMapping("/mySession")
    public String mySession(HttpSession session, Model model) {
	model.addAttribute("message",
		"Ma session est " + session.getId() + "!");
	return "seeYou";
    }

    @GetMapping(value = { "/nickname", "/nickname/{name}" })
    public String nickname(
	    @PathVariable(value = "name", required = false) String name,
	    Model model) {
	model.addAttribute("message", "Mon surnom est " + name + "!");
	return "hello";
    }

    @PostMapping("/auth")
    public String auth(
	    @RequestParam(value = "usr", required = true) String username,
	    @RequestParam(value = "pwd", required = true) String password,
	    Model model) {
	model.addAttribute("message", "Mon username est " + username
		+ " et mon password est " + password + "!");
	return "hello";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute(value = "usr") Credentials credentials,
	    Model model, RedirectAttributes redirectAttributes) {
	if ("123".equals(credentials.getPassword())) {
	    credentialsJpaRepository.save(credentials);
	    model.addAttribute("pageTitle", "Welcome!");
	    model.addAttribute("message",
		    "Welcome " + credentials.getUsername() + "!");
	    return "welcome";
	}
	String username = credentials.getUsername();
	redirectAttributes.addFlashAttribute("credentials", credentials);
	return "redirect:/hellocontroller/loginAgain/" + username;
    }

    @GetMapping("/loginAgain/{username}")
    public String loginAgain(
	    @PathVariable(value = "username", required = false) String username,
	    @ModelAttribute("credentials") final Credentials credentials,
	    Model model) {
	model.addAttribute("pageTitle", "Login again!");
	model.addAttribute("message", "Login again " + username
		+ "! Bad password " + credentials.getPassword());
	return "loginAgain";
    }

    @SuppressWarnings("unused")
    @GetMapping("/goToBet")
    public String goToBet(@ModelAttribute(value = "bet") Bet bet, Model model) {
	model.addAttribute("pageTitle", "Bet!");
	model.addAttribute("message", "Need to bet!");
	return "form";
    }

    @PostMapping("/bet")
    public String bet(@ModelAttribute(value = "bet") Bet bet, Model model) {
	model.addAttribute("bet", new Bet()); // Re-init
	model.addAttribute("pageTitle", "Bet once more!");
	model.addAttribute("message", "Thank you for your bet! France="
		+ bet.getScoreFrance() + " : P�rou=" + bet.getScorePerou());
	return "form";
    }
}