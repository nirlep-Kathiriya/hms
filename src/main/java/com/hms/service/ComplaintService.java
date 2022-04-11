package com.hms.service;

import java.util.List;

import com.hms.model.ComplaintVO;

public interface ComplaintService {

	void insertComplaint(ComplaintVO cVO);

	List<ComplaintVO> searchComplaint();

}
