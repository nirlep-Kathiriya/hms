package com.hms.service;

import java.util.List;

import com.hms.model.LoginVO;
import com.hms.model.SigninVO;



public interface SigninService {

	void insertSigninDetail(SigninVO sVo);

	void insertLoginDetail(LoginVO lVo);

	List<LoginVO> searchLoginDetails(String un, String Pass);

	String varifyEmailAndPhone(String email,String phone);

	List<LoginVO> findByEmail(String email);
	
	List<SigninVO> searchSigninDetail(String email);

  	

	
}
