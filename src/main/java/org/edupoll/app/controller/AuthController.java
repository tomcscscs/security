package org.edupoll.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthController {

	
	@GetMapping("/login")
	public String showLoginForm() {
		
		return "auth/login-form";
	}
}
