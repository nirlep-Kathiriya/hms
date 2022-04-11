package com.hms.controller;

import java.util.Calendar;
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

import com.hms.model.ApplicationFormVO;
import com.hms.model.CityVO;
import com.hms.model.OTPVO;
import com.hms.model.PaymentStatusVO;
import com.hms.model.StateVO;
import com.hms.model.UploadDocumentVO;
import com.hms.service.ApplicationFormService;
import com.hms.service.CityService;
import com.hms.service.OTPService;
import com.hms.service.PaymentStatusService;
import com.hms.service.StateService;
import com.hms.service.UploadDocumentService;
import com.hms.utils.Basemethods;

@Controller
public class ApplicationFormController {

	@Autowired
	private StateService stateService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private ApplicationFormService applicationFormService;
	
	@Autowired
	private UploadDocumentService uploadDocumentService;
	
	@Autowired
	private OTPService otpSer;
	
	
    @Autowired
	private PaymentStatusService pss;
	
	
	@GetMapping(value="user/loadApplicationForm")
	public ModelAndView loadApplicationForm()
	{
		List<StateVO> statelist = this.stateService.searchState();
		System.out.println(statelist.size());
		return new ModelAndView("user/ApplicationForm","applicationformvo",new ApplicationFormVO()).addObject("statelist", statelist); 
	}
	
	@GetMapping(value="user/loadApplicationNumberVerify")
	public ModelAndView loadUploadDocument()
	{
		
		return new ModelAndView("user/ApplicationNumberVerify"); 
	}
	
	@PostMapping(value="user/VerifyApplicationNumber")
	public ModelAndView ApplicationNumberVerify(@RequestParam String email,@RequestParam String applicationno)
	{
		List<ApplicationFormVO> list = this.uploadDocumentService.findByAppNo(email, applicationno);
		System.out.println("size :::"+list.size());
		if(list.size()!=0)
			return new ModelAndView("user/UploadDocument").addObject("email", email).addObject("appno", applicationno);
		else
			return new ModelAndView("user/ApplicationNumberVerify").addObject("error", "please enter valid application no or registered email");
	}
	
	@PostMapping(value="user/searchCity")
	public ModelAndView searchCity(@RequestParam String state,HttpSession session)
	{
		List<CityVO> list=this.cityService.searchCity(state);
		session.setAttribute("l_city",list);
		System.out.println(list.size());

		
		return new ModelAndView("user/JSONForCity");
	}
	
	@PostMapping(value="user/insertapplicationform")
	public ModelAndView insertapplicationform(@ModelAttribute ApplicationFormVO afvo)
	{
		String applicationnumber = Basemethods.generateApplicationNumber();
		afvo.setApplicationNo(applicationnumber);
		this.applicationFormService.insertapplicationform(afvo);
		System.out.println("fasdfdasf  :::  "+afvo.getApplicationNo());
		Basemethods.sendMail(afvo.getEmail(), "Hello "+afvo.getFirstName()+", Your application number is "+afvo.getApplicationNo());
		return new ModelAndView("redirect:/user/loadUserPage");
	}
	
	@GetMapping(value="user/loadRegularForm")
	public ModelAndView loadRegularForm()
	{
		return new ModelAndView("user/RegularStudentForm");
	}
	
	@PostMapping(value="user/varifyRegularStudent")
	public ModelAndView varifyRegularStudent(@RequestParam String email,HttpSession session)
	{
	   List<ApplicationFormVO> list=this.applicationFormService.varifyRegularStudent(email);
	   
	   if(list.size()==0)
	   {
		   return new ModelAndView("user/RegularStudentForm","ErrorOfRegularStudent","Your email is not registered");
       }
	   else
	   {
		   ApplicationFormVO formVO=list.get(0);
		   if(formVO.getCurrentYear()==Calendar.getInstance().get(Calendar.YEAR))
		   {
			   return new ModelAndView("user/RegularStudentForm","ErrorOfRegularStudent","You already registered in thhis year.");
		   }
 		   else if(formVO.getCurrentYear()+1>formVO.getCompletionYear())
 		   {
			   return new ModelAndView("user/RegularStudentForm","ErrorOfRegularStudent","You are already in last year.");
		   }
 		   else
 		   {
 			   
 			   formVO.setCurrentYear(formVO.getCurrentYear()+1);
 			   
 			   this.applicationFormService.insertapplicationform(formVO);
 			   session.setAttribute("emailOfRegular",formVO.getEmail());
 			   session.setAttribute("usernameOfRegular",formVO.getFirstName());
               return new ModelAndView("redirect:/user/sendOTPForRegularVarify");
 		   }
		   
	   }
	 }
	
	@GetMapping(value="user/sendOTPForRegularVarify")
	public ModelAndView sendOTP(@ModelAttribute OTPVO otpvo,HttpSession session)
	{
		 
		   String OTP=Basemethods.generateOTP();
		   String Token=Basemethods.generatePassword(); 
		   session.setAttribute("Token",Token);
		   
		   otpvo.setOtp(OTP);
		   otpvo.setToken(Token);
		   
		   otpSer.insertOTPDetail(otpvo);
		   System.out.println("ssdsddsdsgggggggggggggggggggggggggggggggd"+session.getAttribute("emailOfRegular"));
		   Basemethods.sendMail((String)session.getAttribute("emailOfRegular"),OTP,(String)session.getAttribute("usernameOfRegular"));
           /*session.setAttribute("flagForDirectOTPPage","regularStudent");*/
	   
		   return new ModelAndView("user/OTPVarifyForRegular");	
	}
	
	@PostMapping(value="user/VarifyOTPForRegular")
	public ModelAndView varifyOTP(@RequestParam String token,@RequestParam String OTP,HttpSession session)
	{
	    	
        String ans=otpSer.searchOTP(token, OTP);
        session.setAttribute("ans",ans);
        System.out.println(ans);
        return new ModelAndView("user/JSONforOTPRegular","ans",ans);
	}
	
	@RequestMapping(value = "user/changePaymentStatusForRegular")
	public ModelAndView changePaymentStatusForRegular(HttpSession session) {
		String email = (String) session.getAttribute("emailOfRegular");
		List<PaymentStatusVO> paymentstatuslist = this.pss.checkForRegular(email);
		PaymentStatusVO psvo = paymentstatuslist.get(0);
		psvo.setPaymentStatus("pending");
		this.pss.insertPaymentStatus(psvo);
		
		return new ModelAndView("redirect:/user/loadUserPage");
	}
      	
	
	
}
