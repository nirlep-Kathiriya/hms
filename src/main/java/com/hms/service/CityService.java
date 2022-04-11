package com.hms.service;

import java.util.List;

import com.hms.model.CityVO;

public interface CityService {

	void insertCity(CityVO cityVO);

	List<CityVO> viewCity();

	List<CityVO> findById(int id);
	
	List<CityVO> searchCity(String state);


}
