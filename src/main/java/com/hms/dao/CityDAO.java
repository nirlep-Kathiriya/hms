package com.hms.dao;

import java.util.List;

import com.hms.model.CityVO;

public interface CityDAO {

	void insertCity(CityVO cityVO);

	List<CityVO> viewCity();

	List<CityVO> findById(int id);

	List<CityVO> searchCity(String state);
	

}
