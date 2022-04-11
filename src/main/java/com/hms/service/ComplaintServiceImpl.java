package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.ComplaintDao;
import com.hms.model.ComplaintVO;

@Service
@Transactional
public class ComplaintServiceImpl implements ComplaintService{

    @Autowired
    private ComplaintDao complaintDAO;
	
	@Override
	public void insertComplaint(ComplaintVO cVO) {
		
		this.complaintDAO.insertComplaint(cVO);
	}

	@Override
	public List<ComplaintVO> searchComplaint() {
		return this.complaintDAO.searchComplaint();
	}

}
