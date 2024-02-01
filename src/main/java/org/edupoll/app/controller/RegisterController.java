package org.edupoll.app.controller;

import org.edupoll.app.command.Registration;
import org.edupoll.app.entity.Account;
import org.edupoll.app.repository.AccountRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

	@PostMapping("/register/")
	public String registerUser(Registration cmd) {
		if (accountRepository.findById(cmd.getId()).isPresent()) {
			return "redirect:/register?error";
		}

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = bCryptPasswordEncoder.encode(cmd.getPassword());

		Account one = Account.builder().id(cmd.getId()).password("{bcrypt}" + encodedPassword)
				.nickname(cmd.getNickname()).build();
		accountRepository.save(one);

		return "redirect:/login";

	}
}
