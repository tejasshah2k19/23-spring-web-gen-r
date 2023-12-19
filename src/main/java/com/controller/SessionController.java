package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {

	
	//jsp-> secure -> using method we can access jsp 
	
	@GetMapping("/signup")
	public String signup() {
		return "Signup";// JSP name  
	}
}
