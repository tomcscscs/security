package org.edupoll.app.controller;

import org.edupoll.app.entity.Account;
import org.edupoll.app.repository.AccountRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {
	// private final SimpleDateFormat dateFormat;
	private final AccountRepository accountRepository;
	private final ObjectMapper objectMapper;

	@GetMapping({ "/", "/index" })
	public String showIndex(@AuthenticationPrincipal(expression = "account") Account account, 
					Model model)
			throws JsonProcessingException {

		if (account != null) {
//			String json = objectMapper.writeValueAsString(account);
//			System.out.println(json);
		}

		return "index";
	}

//	@GetMapping({ "/", "/index" })
//	public String showIndex(@AuthenticationPrincipal CustomUserDetails user, Model model) throws JsonProcessingException {
//		
//		if(user != null) {
//			String json = objectMapper.writeValueAsString(user.getAccount());
//			System.out.println(json);
//		}
//
//
//		return "index";
//	}

//	@GetMapping({ "/", "/index" })
//	public String showIndex(Principal principal, Model model) {
//		if (principal != null) {
//			String name = principal.getName();
//			Account account = accountRepository.findById(name).get();
//			
//			model.addAttribute("account", account);
//		}
//
//		return "index";
//	}

//	@GetMapping({ "/", "/index" })
//	public String showIndex(Authentication authentication, Model model) {
//		if (authentication != null) {
//			Account account = accountRepository.findById(authentication.getName()).get();
//			
//			model.addAttribute("account", account);
//		}
//
//		return "index";
//	}

//	@GetMapping({ "/", "/index" })
//	public String showIndex(Model model) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication != null) {
// 			authenticantion.getName();
//			User user = (User)authenticantion.getPrincipal();
//			Account account = accountRepository.findById(authenticantion.getName()).get();
//			
//			model.addAttribute("account", account);
//		}
//
//		return "index";
//	}
}
