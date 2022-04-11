package com.hms.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.LimitAddmissionDAO;
import com.hms.model.ControlAdmissionVo;

@Service
@Transactional
public class LimitAddmissionServiceImpl  implements LimitAddmissionService{

	
	@Autowired
	private LimitAddmissionDAO limitAddmissionDAO;
	
	@Override
	public boolean findStatusAddmission() {
		// TODO Auto-generated method stub
		List<ControlAdmissionVo> list= this.limitAddmissionDAO.findStatusAddmission();
		ControlAdmissionVo  cav = list.get(0);
		return cav.isActivateStatus();
	}
}
