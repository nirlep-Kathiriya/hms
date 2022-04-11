package com.hms.service;

import java.util.List;

import com.hms.model.ApplicationFormVO;

public interface ApplicationFormService {

	void insertapplicationform(ApplicationFormVO afvo);

	List<ApplicationFormVO> varifyRegularStudent(String email);

	List<ApplicationFormVO> search();

}
