package com.livingoncodes.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.livingoncodes.spring.web.dao.Notice;
import com.livingoncodes.spring.web.dao.NoticesDao;

@Service("noticesService")
public class NoticesService {
	
	private NoticesDao noticesDAO;

	@Autowired
	public void setNoticesDAO(NoticesDao noticesDAO) {
		this.noticesDAO = noticesDAO;
	}
	
	public List<Notice> getCurrent() {
		return noticesDAO.getNotices();
	}

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public void create(Notice notice) {
		noticesDAO.create(notice);
		
	}



}
