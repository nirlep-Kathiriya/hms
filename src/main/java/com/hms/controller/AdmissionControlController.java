package com.hms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hms.model.ControlAdmissionVo;
import com.hms.service.ContolAdmissionService;

@Controller
public class AdmissionControlController {

	@Autowired
	private ContolAdmissionService controlService;
	
	@GetMapping(value="admin/loadAdmissionControl")
	public ModelAndView loadAdmissionControl(HttpSession session)
	{  
		List<ControlAdmissionVo> l=this.controlService.checkActivation();
		if(l.size()!=0) session.setAttribute("statusOfButton","ON");
		else session.setAttribute("statusOfButton","OFF");
		return new ModelAndView("admin/admissionCon");
	}
	
	@GetMapping(value="admin/addAdmissionControlDetail")
	public ModelAndView addAdmissionControlDetail(@ModelAttribute ControlAdmissionVo cAV,@RequestParam String activeStatus)
	{
		System.out.println("czsdcszd :- "+"  "+activeStatus);
		
		cAV.setId(188);
		if(activeStatus.equals("true"))
		cAV.setActivateStatus(true);
		else
		{
		cAV.setActivateStatus(false);
		System.out.println("else");
		}
		System.out.println("status dao = " + cAV.isActivateStatus());

		this.controlService.insert(cAV);
		return new ModelAndView("redirect:/admin/loadAdmissionControl");
	}
	
}
