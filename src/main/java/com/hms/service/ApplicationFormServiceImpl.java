package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.ApplicationFormDAO;
import com.hms.model.ApplicationFormVO;

@Service
@Transactional
public class ApplicationFormServiceImpl implements ApplicationFormService {

	@Autowired
	private ApplicationFormDAO applicationFormDAO;

	@Override
	public void insertapplicationform(ApplicationFormVO afvo) {
		// TODO Auto-generated method stub
		this.applicationFormDAO.insertapplicationform(afvo);
	}

	@Override
	public List<ApplicationFormVO> varifyRegularStudent(String email) {
       return this.applicationFormDAO.varifyRegularStudent(email);  
	}

	@Override
	public List<ApplicationFormVO> search() {
		// TODO Auto-generated method stub
		return this.applicationFormDAO.search();
	}
	
	
}
