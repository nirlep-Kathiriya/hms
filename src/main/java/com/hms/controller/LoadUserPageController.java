package com.hms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hms.dao.ComplaintDao;
import com.hms.model.ComplaintVO;
import com.hms.model.PaymentStatusVO;
import com.hms.model.SigninVO;
import com.hms.service.ComplaintService;
import com.hms.service.ContolAdmissionService;
import com.hms.service.LimitAddmissionService;
import com.hms.service.PaymentStatusService;
import com.hms.service.SigninService;
import com.hms.utils.Basemethods;

@Controller
public class LoadUserPageController {

	@Autowired
	private ComplaintService complaintService;
	
	@Autowired
	private SigninService signInService;
	
	@Autowired
	private PaymentStatusService pss;
	
	
	
	@Autowired
	private LimitAddmissionService limitAddmissionService;
	
	@RequestMapping(value = "user/loadUserPage")
	public ModelAndView loadUserPage(HttpSession session) {
	
		boolean status = this.limitAddmissionService.findStatusAddmission();
		System.out.println(" status :- "+status);
		session.setAttribute("addmissionStatus",status);
		return new ModelAndView("user/index").addObject("addmissionStatus",status);
	}
	
	
	/*
	@GetMapping(value="user/savedata")
	public ModelAndView savedata(@RequestParam String username, @RequestParam String password,HttpSession session)
	{
		session.setAttribute("email", username);
		session.setAttribute("password", password);
		return new ModelAndView("redirect:/user/loadUserPage");
	}*/

	@PostMapping(value = "user/insertComplaint")
	public ModelAndView insertComplaint(@ModelAttribute ComplaintVO cVO, @RequestParam String complaint,
			HttpSession session) {
		cVO.setEmail(Basemethods.getUser());
		cVO.setComplaint(complaint);
		
		List<SigninVO> list = this.signInService.searchSigninDetail(Basemethods.getUser());
		SigninVO svo = list.get(0);
		cVO.setName(svo.getFirstName());
		
		
		complaintService.insertComplaint(cVO);

		return new ModelAndView("redirect:/user/loadUserPage");
	}
	
	@GetMapping(value="user/loadMessPage")
	public ModelAndView loadMessPage()
	{
		return new ModelAndView("user/mess");
	}
	
}
