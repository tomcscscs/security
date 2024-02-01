package org.edupoll.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {
	// private final SimpleDateFormat dateFormat;

	@GetMapping({ "/", "/index" })
	public String showIndex() {
		// System.out.println(dateFormat);
		return "index/main";
	}
	
	@GetMapping("/test")
	public String showTestPage() {
		
		return "index/testHtml";
		
		
	}
}
