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

import com.hms.model.LoginVO;
import com.hms.model.OTPVO;
import com.hms.model.SigninVO;
import com.hms.service.OTPService;
import com.hms.service.SigninService;
import com.hms.utils.Basemethods;



@Controller
public class SigninLoginController {
	@Autowired
	private SigninService signinSer;
	
	@Autowired
	private OTPService  otpSer;
	
	@GetMapping(value="loadSignUpPage")
	public ModelAndView loadSignUp()
	{
		return new ModelAndView("SigninLogin/Signin","SigninVOKey",new SigninVO());
	}

	@GetMapping(value="loadLogInPage")
	public ModelAndView loadLogIn()
	{
		return new ModelAndView("redirect:/login");
	}
	
	@PostMapping(value="insertSignInDetail")
	public ModelAndView insertSignDetail(@ModelAttribute SigninVO signInVo,HttpSession session)
	{
	   String flag="";	
	   String ans[];
       ans=signinSer.varifyEmailAndPhone(signInVo.getLoginVO().getUsername(),signInVo.getPhone()).split(" ");
       if(ans[0].equals("No")&&ans[1].equals("No"))
       {
    	   LoginVO loginVO =signInVo.getLoginVO();	   
    	   loginVO.setRole("ROLE_USER");
    	   loginVO.setEnabled("1");
    	   loginVO.setStatus(true);
    	   this.signinSer.insertLoginDetail(loginVO); 	
    	   this.signinSer.insertSigninDetail(signInVo);
    	   session.setAttribute("emailOfSignIn",signInVo.getLoginVO().getUsername());
    	   return new ModelAndView("redirect:/sendOTPForSignInVarify");  
       }
       else
       {
           if(ans[0].equals("Yes")&&ans[1].equals("No")) flag="Email is already registered";
           else if(ans[0].equals("No")&&ans[1].equals("Yes")) flag="Phone number is already registered";
           else if(ans[0].equals("Yes")&&ans[1].equals("Yes")) flag="Email and Phone number is already registered";
           session.setAttribute("flag",flag);
           return new ModelAndView("SigninLogin/Signin","SigninVOKey",new SigninVO());  
       }
	}
		
	@PostMapping(value="verifyLoginDetail")
	public ModelAndView verifyLoginDetail(@RequestParam String username,@RequestParam String password,HttpSession session)
	{
		List<LoginVO> l=this.signinSer.searchLoginDetails(username, password);
        String ans="";
		if(l.size()==0) ans="No";
		else
		{ 
			LoginVO loginVO=l.get(0);

			ans="Yes";
			if(loginVO.getUsername().equals("admin@gmail.com")&&loginVO.getPassword().equals("admin"))
				ans="admin";
			
		}
		
        session.setAttribute("ans",ans);
        System.out.println(ans);
        

		return  new ModelAndView("SigninLogin/JSONforLOGIN","ans",ans);
    }

	
	@GetMapping(value="sendOTPForSignInVarify")
	public ModelAndView sendOTP(@ModelAttribute OTPVO otpvo,HttpSession session)
	{
		 
		   String OTP=Basemethods.generateOTP();
		   String Token=Basemethods.generatePassword(); 
		   session.setAttribute("Token",Token);
		   
		   otpvo.setOtp(OTP);
		   otpvo.setToken(Token);
		   
		   otpSer.insertOTPDetail(otpvo);
		   
		   Basemethods.sendMail((String)session.getAttribute("emailOfSignIn"),OTP,"Hostel");
			   session.setAttribute("flagForDirectOTPPage","SignUp");

		   return new ModelAndView("SigninLogin/OTPvarify");	
	}
	@PostMapping(value="VarifyOTPForSignin")
	public ModelAndView varifyOTP(@RequestParam String token,@RequestParam String OTP,HttpSession session)
	{
	    	
        String ans=otpSer.searchOTP(token, OTP);
        session.setAttribute("ans",ans);
        System.out.println(ans);
        return new ModelAndView("SigninLogin/JSONforOTP","ans",ans);
	}
	
	@PostMapping(value="checkEmailAlreadyRegistered")
	public ModelAndView checkEmailAlreadyRegistered(HttpSession session,@RequestParam String email)
	{
		System.out.println("Email  njhkhn"+email);
	    List<LoginVO> l=signinSer.findByEmail(email);
	    String ans="";
	    if(l.size()==0)
	    ans="No";
	    else
	    ans="Yes";	
	    session.setAttribute("ans",ans);
		return new ModelAndView("SigninLogin/JSONforOTP");
		
	}
	
	@GetMapping(value="sendOTPForForgotPassVarify")
	public ModelAndView sendOTPForForgotPassVarify(@ModelAttribute OTPVO otpvo,HttpSession session,@RequestParam String email)
	{
		 
		   String OTP=Basemethods.generateOTP();
		   String Token=Basemethods.generatePassword(); 
		   session.setAttribute("Token",Token);
		   otpvo.setOtp(OTP);
		   otpvo.setToken(Token);
		   otpSer.insertOTPDetail(otpvo);
		   Basemethods.sendMail(email,OTP,"Hostel");
		   
		   session.setAttribute("email",email);
		   return new ModelAndView("SigninLogin/NewPassword");	
	}
	
	@PostMapping(value="varifyOTPandUpdatePassword")
	public ModelAndView varifyOTPandUpdatePassword(@RequestParam String password1,@RequestParam String password2
			,@RequestParam String OTPForForgotPassword,HttpSession session,@RequestParam String token)
	{
		String ansForOTP=otpSer.searchOTP(token,OTPForForgotPassword);
		String errorOfPass="",errorOfOTP="";
		String email=(String)session.getAttribute("email");
		LoginVO l=signinSer.findByEmail(email).get(0);
		
	    System.out.println(password1+"  "+password2+"  "+OTPForForgotPassword+"  "+token);
        
	    if(password1.equals(password2) && ! password1.equals(l.getPassword())&& ansForOTP.equals("Yes"))
		{
		    l.setPassword(password1);
		    signinSer.insertLoginDetail(l);
            return new ModelAndView("redirect:/loadLogInPage");
		}
		else
		{
			if(ansForOTP.equals("No")) errorOfOTP="Wrong OTP !!"; 
            if(!password1.equals(password2)) errorOfPass="Two Password not match !!";
			if(password1.equals(password2)&&password1.equals(l.getPassword()) )errorOfPass="Please don't use old password.";
			session.setAttribute("errorOfOTP",errorOfOTP);
			session.setAttribute("errorOfPass",errorOfPass);

			return new ModelAndView("SigninLogin/NewPassword");
		}	
		 
		
	
	}
	
}
