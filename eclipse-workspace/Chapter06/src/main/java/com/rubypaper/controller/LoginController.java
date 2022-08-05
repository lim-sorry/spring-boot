package com.rubypaper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rubypaper.domain.Member;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String loginView() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Member member) {
		return "login";
	}
}
