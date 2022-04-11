package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.hms.model.*;
import com.hms.service.SigninService;
import com.hms.utils.Basemethods;

@Controller
public class EditProfileController {

	@Autowired
	private SigninService signinservice;

	@GetMapping(value = "user/loadEditProfile")
	public ModelAndView loadEditProfile() {
		String email = Basemethods.getUser();

		List<SigninVO> l = this.signinservice.searchSigninDetail(email);
		SigninVO signinVO = l.get(0);
		return new ModelAndView("user/editProfile", "signinVO", signinVO);
	}

	@PostMapping(value = "user/updateProfile")
	public ModelAndView updateProfile(@ModelAttribute SigninVO signinVO) {
		System.out.println("edcdcsd");

		System.out.println("cdzczxcz" + signinVO.getLoginVO().getLoginId());

		LoginVO loginVO =signinVO.getLoginVO();
 	   
 	   loginVO.setRole("ROLE_USER");
 	   loginVO.setEnabled("1");
 	   loginVO.setStatus(true);
		this.signinservice.insertLoginDetail(loginVO);
		this.signinservice.insertSigninDetail(signinVO);

		return new ModelAndView("user/editProfile", "signinVO", signinVO);
	}
	
	@GetMapping(value = "admin/loadAdminEditProfile")
	public ModelAndView loadAdminEditProfile() {
		String email = Basemethods.getUser();

		List<SigninVO> l = this.signinservice.searchSigninDetail(email);
		SigninVO signinVO = l.get(0);
		return new ModelAndView("admin/editProfile","signinVO", signinVO);
	}

	@PostMapping(value = "admin/updateAdminProfile")
	public ModelAndView updateAdminProfile(@ModelAttribute SigninVO signinVO) {
		System.out.println("edcdcsd");

		System.out.println("cdzczxcz" + signinVO.getLoginVO().getLoginId());

		LoginVO loginVO =signinVO.getLoginVO();
 	   
 	   loginVO.setRole("ROLE_ADMIN");
 	   loginVO.setEnabled("1");
 	   loginVO.setStatus(true);
		this.signinservice.insertLoginDetail(loginVO);
		this.signinservice.insertSigninDetail(signinVO);

		return new ModelAndView("admin/editProfile", "signinVO", signinVO);
	}

}
