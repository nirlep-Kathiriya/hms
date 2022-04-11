package com.hms.controller;

import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hms.model.ApplicationFormVO;
import com.hms.service.ApplicationFormService;
import com.hms.utils.Basemethods;

@Controller
public class BroadcastMessageController {

	
	
	@Autowired 
	private ApplicationFormService applicationFormService;
	
	@RequestMapping(value="admin/loadBroadCastMessage")
	public ModelAndView loadBroadCastMessage()
	{
		return new ModelAndView("admin/addBroadcastMessage");
	}
	
    @PostMapping(value="admin/insertBroadcastMessage")
    public ModelAndView insertBroadcastMessage(@RequestParam String message)
    {
    	List<ApplicationFormVO> list = this.applicationFormService.search();
    	System.out.println(list.size());
    	
    	 Iterator iterator = list.iterator();
    	 while (iterator.hasNext()) 
    	 {
             Basemethods.sendMail((String)iterator.next(),message);
    	 }
    	
    	return new ModelAndView("redirect:/admin/loadBroadCastMessage");
    }
    
    }
