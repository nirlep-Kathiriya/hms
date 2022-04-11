package com.hms.dao;

import java.util.List;

import com.hms.model.LoginVO;
import com.hms.model.SigninVO;



public interface SigninDao {

	void insertSigninDetail(SigninVO sVo);

	void insertLoginDetail(LoginVO lVo);

	List<LoginVO> searchLoginDetails(String un, String Pass);

	List<LoginVO> searchEmail(String email);

	List<SigninVO> searchPhone(String phone);

	List<LoginVO> findByEmail(String email);

	List<SigninVO> searchSigninDetail(String email);

    	
}
