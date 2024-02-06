package com.controller;

import java.io.File;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

	@Autowired
	BCryptPasswordEncoder encoder;

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
			String masterPath = "C:\\jee\\23-spring-web-gen-r\\src\\main\\webapp\\images";

			File userFolder = new File(masterPath, user.getEmail());
			userFolder.mkdir(); // will create folder if does not exists

			File f = new File(userFolder, profilePic.getOriginalFilename());

			FileUtils.writeByteArrayToFile(f, profilePic.getBytes());

			user.setProfile("images/" + user.getEmail() + "/" + profilePic.getOriginalFilename());

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

			// password encrypt ->
			// Bcrypt
			String encPwd = encoder.encode(user.getPassword());

			user.setPassword(encPwd);

			userDao.addUser(user);// insert
			return "Login";
		}
		// spring - hibernate

		// db save

	}

	@PostMapping("/authenticate")
	public String authenticate(UserBean user) {
		// jack@gmail.com
		UserBean userDb = userDao.getUserByEmail(user.getEmail());

		if (userDb == null) {
			return "Login";
		} else {
			if (encoder.matches(user.getPassword(), userDb.getPassword()) == true) {
				return "Home";
			} else {
				return "Login";
			}

		}

	}

}
