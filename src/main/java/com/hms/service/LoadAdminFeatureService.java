package com.hms.service;

import java.util.List;

import com.hms.model.UploadDocumentVO;



public interface LoadAdminFeatureService {

	List<UploadDocumentVO> searchFresherDetail();

	List<UploadDocumentVO> searchFresherDocument(int documentListId);

	List<UploadDocumentVO> searchHostelStudentDetail();

}
