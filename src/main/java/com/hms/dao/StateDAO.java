package com.hms.dao;

import java.util.List;

import com.hms.model.StateVO;

public interface StateDAO {

	/*void insertState(StateVO stateVO);*/

	List<StateVO> searchState();

	List<StateVO>findById(int id);

}
