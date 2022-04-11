package com.hms.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.UploadDocumentDAO;
import com.hms.model.ApplicationFormVO;
import com.hms.model.UploadDocumentVO;

@Service
@Transactional
public class UploadDocumentServiceImpl implements UploadDocumentService{

	@Autowired
	private UploadDocumentDAO uploadDocumentDAO;
	
	@Override
	public void uploadDocument(UploadDocumentVO uploadDocumentVO) {
		// TODO Auto-generated method stub
		this.uploadDocumentDAO.uploadDocument(uploadDocumentVO);
	}

	@Override
	public List<ApplicationFormVO> findByAppNo(String email, String appno) {
		// TODO Auto-generated method stub
		return this.uploadDocumentDAO.findByAppNo(email,appno);
	}

	
	
}
