package com.hms.service;

import com.hms.model.UploadDocumentVO;

import java.util.List;

import com.hms.model.*;

public interface UploadDocumentService {

	void uploadDocument(UploadDocumentVO uVO);
	
	List<ApplicationFormVO> findByAppNo(String email,String appno);

}
