package com.controller;

import java.io.File;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
		// controller ==> jsp
		model.addAttribute("user", user);
		return "Signup";// JSP name
	}

	@GetMapping("/login")
	public String login() {
		return "Login";
	}

	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute("user") @Valid UserBean user, BindingResult result, Model model,
			@RequestParam("profilePic") MultipartFile profilePic) {
		System.out.println("SaveuserCalled...");

		System.out.println(profilePic.getOriginalFilename());
		System.out.println(profilePic.getSize());

		try {
			String masterPath = "C:\\Krishna\\oxygen workspace\\23-spring-web-gen-r2\\src\\main\\webapp\\images";

			File f = new File(masterPath, profilePic.getOriginalFilename());

			FileUtils.writeByteArrayToFile(f, profilePic.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// read data
		System.out.println(user.getFirstName());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		// int float -> auto convert
		// age ->int
		// validation
		// if
		model.addAttribute("user", user);
		if (result.hasErrors() == true) {
			System.out.println("Error");

			System.out.println(result.getAllErrors());
			return "Signup";
		} else {
			//
//			dao
			userDao.addUser(user);// insert
			return "Login";
		}
		// spring - hibernate

		// db save

	}
}
