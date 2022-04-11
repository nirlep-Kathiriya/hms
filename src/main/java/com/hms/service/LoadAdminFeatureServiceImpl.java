package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.LoadAdminFeatureDAO;
import com.hms.model.UploadDocumentVO;

@Service
@Transactional
public class LoadAdminFeatureServiceImpl implements  LoadAdminFeatureService {

	@Autowired
	private LoadAdminFeatureDAO loadAdminFeatureDAO;
	
	@Override
	public List<UploadDocumentVO> searchFresherDetail() {
		// TODO Auto-generated method stub
		return this.loadAdminFeatureDAO.searchFresherDetail();
	}

	@Override
	public List<UploadDocumentVO> searchFresherDocument(int documentListId) {
       	return this.loadAdminFeatureDAO.searchFresherDocument(documentListId);	
	}

	@Override
	public List<UploadDocumentVO> searchHostelStudentDetail() {
		return this.loadAdminFeatureDAO.searchHostelStudentDetail();
	}

	
	
}
