package com.hms.service;

import java.util.List;


import com.hms.model.StateVO;

public interface StateService {

	/*void insertState(StateVO stateVO);*/

	List<StateVO> searchState();

	List<StateVO> findById(int id);
	
}
