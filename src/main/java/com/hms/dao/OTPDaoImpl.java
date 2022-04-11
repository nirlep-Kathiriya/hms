package com.hms.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.OTPVO;


@Repository
public class OTPDaoImpl implements OTPDao{

	@Autowired
	private  SessionFactory sf;
	
	@Override
	public void insertOTPDetail(OTPVO oVo) {
		Session s=sf.getCurrentSession();
      	s.save(oVo);		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OTPVO> searchOTP(String Token,String OTP)
	{
		Session s=sf.getCurrentSession();
        Query q=s.createQuery("from OTPVO where token='"+Token+"' and otp='"+OTP+"' ");
        List<OTPVO> l=q.list();
        return l;
	}
}
