package com.hms.dao;

import java.util.List;

import com.hms.model.ControlAdmissionVo;

public interface LimitAddmissionDAO {

	List<ControlAdmissionVo> findStatusAddmission();

}
