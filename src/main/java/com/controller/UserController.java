package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		
		List<UserBean> users =  userDao.getAllUsers(); 
		model.addAttribute("users",users);
		
		return "ListUsers";//jsp 
	}
	
	@GetMapping("/deleteuser")
	public String deleteUser(@RequestParam("userId") Integer userId) {
		userDao.deleteUser(userId);
		 return "redirect:/users"; //url 
	}
}
