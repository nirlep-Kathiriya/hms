package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.StateDAO;
import com.hms.model.StateVO;

@Service
@Transactional
public class StateServiceImpl implements StateService {

	@Autowired
	private StateDAO stateDAO;
	
	/*@Override
	public void insertState(StateVO stateVO) {
        this.stateDAO.insertState(stateVO); 		
	}*/

	@Override
	public List<StateVO> searchState() {
		// TODO Auto-generated method stub
		 return this.stateDAO.searchState();
	}

	@Override
	public List<StateVO> findById(int id) {
		// TODO Auto-generated method stub
		return this.stateDAO.findById(id);
	}

}
