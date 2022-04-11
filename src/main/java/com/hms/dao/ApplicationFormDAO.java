package com.hms.dao;

import java.util.List;

import com.hms.model.ApplicationFormVO;

public interface ApplicationFormDAO {

	void insertapplicationform(ApplicationFormVO afvo);

	List<ApplicationFormVO> varifyRegularStudent(String email);

	List<ApplicationFormVO> search();

}
