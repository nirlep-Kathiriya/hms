package com.hms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.ContolAdmissionDao;
import com.hms.model.ControlAdmissionVo;

@Service
@Transactional
public class ContolAdmissionServiceImpl implements ContolAdmissionService{

	@Autowired
	private ContolAdmissionDao controlDao;
	
	@Override
	public void insert(ControlAdmissionVo cAV) {
		this.controlDao.insert(cAV);
	}

	@Override
	public List<ControlAdmissionVo> checkActivation() {
		return this.controlDao.checkActivation();
	}

}
