package com.hms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hms.model.ComplaintVO;
import com.hms.model.FeedbackVO;
import com.hms.model.GalleryVO;
import com.hms.model.LoginVO;
import com.hms.service.ComplaintService;
import com.hms.service.FeedbackService;
import com.hms.service.GalleryService;
import com.hms.service.LimitAddmissionService;
import com.hms.service.LoginService;


@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	private ComplaintService complaintService;
	
	@Autowired
	private LimitAddmissionService limitAddmissionService;
	
	@Autowired
	private FeedbackService feedbackService;
	
	@Autowired
	private GalleryService galleryService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loadLogin() {
		boolean status = this.limitAddmissionService.findStatusAddmission();
		List<FeedbackVO> list=this.feedbackService.viewFeedback();
		List<GalleryVO> gallerylist = this.galleryService.searchGallery();
		return new ModelAndView("main").addObject("addmissionStatus",status).addObject("listOfFeedback",list).addObject("gallerylist", gallerylist);
	}
	
	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public ModelAndView adminIndex(LoginVO loginVO ) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUsername();	 
		List<FeedbackVO> list=this.feedbackService.viewFeedback();
        List<ComplaintVO> listOfComplaint=this.complaintService.searchComplaint();
		System.out.println("size    "+listOfComplaint.size());
		return new ModelAndView("admin/index").addObject("listOfFeedback",list).addObject("listOfComplaint", listOfComplaint);
	}
	
	@RequestMapping(value = "/user/index", method = RequestMethod.GET)
	public ModelAndView userIndex(HttpSession session) {
		boolean status = this.limitAddmissionService.findStatusAddmission();
		System.out.println(" status :- "+status);
		session.setAttribute("addmissionStatus",status);
		return new ModelAndView("user/index").addObject("addmissionStatus",status);
	}
	
	@RequestMapping(value = "/logout", method = {RequestMethod.POST, RequestMethod.GET})	
	public String viewUserDetails(ModelMap model,HttpServletResponse response,HttpServletRequest request) {
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) {
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	            request.getSession().invalidate();
	            request.getSession().setAttribute("tempStatus", "success");
	            request.getSession().setAttribute("statusText", "Logout Successfully!");
	        }
	        return "redirect:/";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView load(@RequestParam(value="error", defaultValue="false") boolean error) {
		
		System.out.println(error);
		return new ModelAndView("login","error",error);
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView load403() {
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView error() {
		return new ModelAndView("redirect:/");
	}
}