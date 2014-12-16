package com.livingoncodes.spring.web.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.livingoncodes.spring.web.dao.Notice;
import com.livingoncodes.spring.web.service.NoticesService;

@Controller
public class NoticesController {
	
	private NoticesService noticesService;
	
	@Autowired
	public void setNoticesService(NoticesService noticesService) {
		this.noticesService = noticesService;
	}


	@RequestMapping("/test")
	public String  showTest(Model model, @RequestParam("id") String id) {
		
		System.out.println("Id is: " + id);

		return "home";
	}
	
	
	
	@RequestMapping("/notices")
	public String  showNotices(Model model) {
		
		
		List<Notice> notices = noticesService.getCurrent();
		
		model.addAttribute("notices", notices);

		return "notices";
	}
	
	@RequestMapping("/createnotice")
	public String  createNotice(Model model, Principal principal) {
		
		Notice notice = null;
		
		if( principal != null ) {
			String username = principal.getName();
			
			notice = noticesService.getNotice(username);
		}
		
		if( notice == null ) {
			notice = new Notice();
		}
		
		model.addAttribute(notice);
		
		return "createnotice";
	}
	
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Notice notice, BindingResult result, Principal principal,
			@RequestParam(value="delete", required=false) String delete) {
		
		if( result.hasErrors() ) {
			return "createnotice";
		}
		
		if(delete == null) {
			String username = principal.getName();	
			notice.getUser().setUsername(username);
			noticesService.saveOrUpdate(notice);
			return "noticecreated";
		} else {
			noticesService.delete(notice.getId());
			return "noticedeleted";
		}
		
		
	}
}
