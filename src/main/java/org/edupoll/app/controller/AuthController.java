package org.edupoll.app.controller;

import org.edupoll.app.command.Registration;
import org.edupoll.app.entity.Account;
import org.edupoll.app.repository.AccountRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthController {

	private final AccountRepository accountRepository;

	@GetMapping("/login")
	public String showLogin() {

		return "auth/login-form";
	}

	@GetMapping("/register")
	public String showRegister() {

		return "auth/register-form";
	}

	@PostMapping("/register")
	public String proceedRegister(Registration cmd) {
		if (accountRepository.findById(cmd.getId()).isPresent()) {
			return "redirect:/register?error";
		}

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = bCryptPasswordEncoder.encode(cmd.getPassword());
		Account newEntity = Account.builder().id(cmd.getId())//
				.password("{bcrypt}" + encodedPassword).nickname(cmd.getNickname()).build();

		accountRepository.save(newEntity);

		return "redirect:/login";
	}

}
