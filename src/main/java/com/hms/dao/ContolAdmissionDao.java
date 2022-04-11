package com.hms.dao;

import java.util.List;

import com.hms.model.ControlAdmissionVo;

public interface ContolAdmissionDao {

	void insert(ControlAdmissionVo cAV);
	
	List<ControlAdmissionVo> checkActivation();
}
