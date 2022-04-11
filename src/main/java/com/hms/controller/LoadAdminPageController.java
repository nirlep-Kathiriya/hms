package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hms.model.ComplaintVO;
import com.hms.model.FeedbackVO;
import com.hms.service.ComplaintService;
import com.hms.service.FeedbackService;

@Controller
public class LoadAdminPageController {

	@Autowired
	private FeedbackService feedbackService;
	
	@Autowired
	private ComplaintService complaintService;
	
	/*@GetMapping(value="admin/loadAdmin")
	public ModelAndView loadIndexPage()
	{   
		List<FeedbackVO> list=this.feedbackService.viewFeedback();
        List<ComplaintVO> listOfComplaint=this.complaintService.searchComplaint();
		System.out.println("size    "+listOfComplaint.size());
		return new ModelAndView("admin/index").addObject("listOfFeedback",list).addObject("listOfComplaint", listOfComplaint);
	}*/
}
