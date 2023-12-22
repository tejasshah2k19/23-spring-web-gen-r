package com.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;

@Controller
public class SessionController {

	// jsp-> secure -> using method we can access jsp

	@GetMapping("/signup")
	public String signup() {
		return "Signup";// JSP name
	}

	@GetMapping("/login")
	public String login() {
		return "Login";
	}

	@PostMapping("/saveuser")
	public String saveUser(@Valid UserBean user, BindingResult result) {
		System.out.println("SaveuserCalled...");

		// read data
		System.out.println(user.getFirstName());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		// int float -> auto convert
		// age ->int
		// validation
		// if
		if (result.hasErrors() == true) {
			System.out.println("Error");
			return "Signup";
		} else {
			// 
			return "Login";
		}
		// spring - hibernate

		// db save

	}
}
