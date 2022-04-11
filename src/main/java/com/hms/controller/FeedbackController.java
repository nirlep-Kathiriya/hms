package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hms.model.FeedbackVO;
import com.hms.service.FeedbackService;

@Controller
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping(value="insertFeedback")
	public ModelAndView insertFeedback(@RequestParam String name,@RequestParam String email,@RequestParam String message)
	{   
		FeedbackVO feedbackVO=new FeedbackVO();
		feedbackVO.setEmail(email);
		feedbackVO.setFeedbackMsg(message);
		feedbackVO.setName(name);
		
		this.feedbackService.insertFeedback(feedbackVO);
		return  new ModelAndView("redirect:/");
	}
}
