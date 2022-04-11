package com.hms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.OTPDao;
import com.hms.model.OTPVO;



@Service
@Transactional
public class OTPServiceImpl implements OTPService{
    @Autowired
    private OTPDao otpDao;
	
	@Override
	public void insertOTPDetail(OTPVO oVo) {
       this.otpDao.insertOTPDetail(oVo);		
	}

	@Override
	public String searchOTP(String Token, String OTP) {
	  List<OTPVO> l=otpDao.searchOTP(Token, OTP);
	  if(l.size()==0) return "No";
	  else return "Yes";
	  
	  
	}
}
