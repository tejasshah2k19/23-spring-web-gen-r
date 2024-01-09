package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.PlayerBean;

@Controller
public class PlayerController {

	@GetMapping("/newplayer")
	public String newPlayer() {
		return "NewPlayer";
	}

	@PostMapping("/saveplayer")
	public String savePlayer(PlayerBean playerBean) {
		
		return "Login";
	}
}

