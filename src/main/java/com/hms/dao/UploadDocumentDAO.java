package com.hms.dao;

import java.util.List;


import com.hms.model.ApplicationFormVO;
import com.hms.model.UploadDocumentVO;

public interface UploadDocumentDAO {

	void uploadDocument(UploadDocumentVO uploadDocumentVO);

	List<ApplicationFormVO> findByAppNo(String email, String appno);

}
