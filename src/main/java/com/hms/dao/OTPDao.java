package com.hms.dao;

import java.util.List;

import com.hms.model.OTPVO;


public interface OTPDao {
	void insertOTPDetail(OTPVO oVo);

	List<OTPVO> searchOTP(String Token, String OTP);

}
