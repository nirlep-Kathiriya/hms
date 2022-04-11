package com.hms.service;

import java.util.List;

import com.hms.model.ControlAdmissionVo;

public interface ContolAdmissionService {

	void insert(ControlAdmissionVo cAV);
	
	List<ControlAdmissionVo> checkActivation();

	
}
