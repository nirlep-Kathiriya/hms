package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.CityDAO;
import com.hms.model.CityVO;

@Service
@Transactional
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDAO cityDAO;
	
	
	@Override
	public void insertCity(CityVO cityVO) {
		// TODO Auto-generated method stub
		/*System.out.println(cityVO.getCityName());
		System.out.println(cityVO.getStatevo().getId());
		*/
		this.cityDAO.insertCity(cityVO);
	}


	@Override
	public List<CityVO> viewCity() {
		// TODO Auto-generated method stub
		return this.cityDAO.viewCity();
	}


	@Override
	public List<CityVO> findById(int id) {
		// TODO Auto-generated method stub
		return this.cityDAO.findById(id);
	}


	@Override
	public List<CityVO> searchCity(String state) {
	  return this.cityDAO.searchCity(state);
	}

}
