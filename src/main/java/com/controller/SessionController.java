package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class SessionController {

	// jsp-> secure -> using method we can access jsp

	@Autowired
	UserDao userDao;
	
	@GetMapping("/signup")
	public String signup(Model model) {
		UserBean user = new UserBean(); 
		//controller ==> jsp 
		model.addAttribute("user",user);
		return "Signup";// JSP name
	}

	@GetMapping("/login")
	public String login() {
		return "Login";
	}

	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute("user") @Valid UserBean user, BindingResult result,Model model) {
		System.out.println("SaveuserCalled...");

		// read data
		System.out.println(user.getFirstName());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		// int float -> auto convert
		// age ->int
		// validation
		// if
		model.addAttribute("user",user);
		if (result.hasErrors() == true) {
			System.out.println("Error");
			
			System.out.println(result.getAllErrors());
			return "Signup";
		} else {
			// 
//			dao
			userDao.addUser(user);//insert 
			return "Login";
		}
		// spring - hibernate

		// db save

	}
}
