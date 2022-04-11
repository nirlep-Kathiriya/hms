package com.hms.dao;

import java.util.List;

import com.hms.model.ComplaintVO;

public interface ComplaintDao {

	void insertComplaint(ComplaintVO cVO);

	List<ComplaintVO> searchComplaint();

}
