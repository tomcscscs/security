package org.edupoll.app.controller;

import org.edupoll.app.repository.AccountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor

public class RegisterController {
	private final AccountRepository accountRepository;
	


	@GetMapping("/registerform")
	public String showRegisterForm(Model model) {

		return "/register/register-form";

	}
	
	   @PostMapping("/register/{userId}")
	    public String registerUser(@PathVariable String userId, @RequestParam(required = false) String password, @RequestParam(required = false) String nickname, @RequestParam(required = false) String userLevel) {


	        return "redirect:/home"; // 회원가입 후 리다이렉트할 경로
	    }
	}
	
	
	
	
		
		
	}
	







