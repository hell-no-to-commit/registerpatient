package com.registerpatient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.registerpatient.entities.User;
import com.registerpatient.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/signup")
	public String showSignupForm(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/signup")
	public String processSignupForm(@ModelAttribute("user") User user) {
		userRepository.save(user);
		return "redirect:/login";
	}
//
//	@GetMapping("/login")
//	public String login() {
//		return "login";
//	}
//
//	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
//	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
//		if (username.equals("user") && password.equals("password")) {
//			return "redirect:/registerPatient"; // Redirect to home page on successful login
//		} else {
//			return "redirect:/login?error"; // Redirect back to login page with error parameter
//		}
//		//return "redirect:/registerPatient";
//	}
}