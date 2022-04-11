package com.hms.dao;

import java.util.List;

import com.hms.model.UploadDocumentVO;

public interface LoadAdminFeatureDAO {

	List<UploadDocumentVO> searchFresherDetail();

	List<UploadDocumentVO> searchFresherDocument(int documentListId);

	List<UploadDocumentVO> searchHostelStudentDetail();

}
