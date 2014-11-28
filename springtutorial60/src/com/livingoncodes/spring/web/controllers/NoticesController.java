package com.livingoncodes.spring.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.livingoncodes.spring.web.dao.Notice;
import com.livingoncodes.spring.web.service.NoticesService;

@Controller
public class NoticesController {
	
	private NoticesService noticesService;
	
	@Autowired
	public void setNoticesService(NoticesService noticesService) {
		this.noticesService = noticesService;
	}


	@RequestMapping("/")
	public String  showHome(Model model) {
		
		List<Notice> notices = noticesService.getCurrent();
		
		model.addAttribute("notices", notices);

		return "home";
	}
}
