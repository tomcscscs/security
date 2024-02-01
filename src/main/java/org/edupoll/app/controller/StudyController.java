package org.edupoll.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/study")
public class StudyController {

	
	@GetMapping
	public String showStudyView() {
		return "study/study-index";
	}
	
	
	@GetMapping("/manage/member")
	public String showStudyManageMember() {
		return "study/manage/manage-member";
	}
}
