package com.hms.service;

import com.hms.model.OTPVO;

public interface OTPService {

	void insertOTPDetail(OTPVO oVo);
	
	String searchOTP(String Token, String OTP);


}
