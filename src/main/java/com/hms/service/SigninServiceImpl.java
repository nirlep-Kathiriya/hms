package com.hms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.SigninDao;
import com.hms.model.LoginVO;
import com.hms.model.SigninVO;



@Service
@Transactional
public class SigninServiceImpl implements SigninService {

	@Autowired
	private SigninDao sDao;
	
	@Override
	public void insertSigninDetail(SigninVO sVo) {
		this.sDao.insertSigninDetail(sVo);
	}
	
	@Override
	public void insertLoginDetail(LoginVO lVo) {
		this.sDao.insertLoginDetail(lVo);
	}

	@Override
	public List<LoginVO> searchLoginDetails(String un, String Pass)
	{
		List<LoginVO> l=this.sDao.searchLoginDetails(un,Pass);
		
		return l;
	}

	@Override
	public String varifyEmailAndPhone(String email,String phone)
	{
		List<LoginVO> listEmail=this.sDao.searchEmail(email);
		List<SigninVO> listPhone=this.sDao.searchPhone(phone);
		
		String emailAns="",phoneAns="";
		
		if(listEmail.size()==0) emailAns="No";
		else emailAns="Yes";
		if(listPhone.size()==0) phoneAns="No";
		else phoneAns="Yes";
		
		return emailAns+" "+phoneAns;


	}

	@Override
	public List<LoginVO> findByEmail(String email) {
        return this.sDao.findByEmail(email);
       

	}

	@Override
	public List<SigninVO> searchSigninDetail(String email) {
		return this.sDao.searchSigninDetail(email);
	}
	
	

}
