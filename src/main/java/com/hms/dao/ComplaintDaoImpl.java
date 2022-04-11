package com.hms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.ComplaintVO;

@Repository
public class ComplaintDaoImpl implements ComplaintDao{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public void insertComplaint(ComplaintVO cVO) {
      try {
		 Session session = sf.getCurrentSession();
		 session.save(cVO);
	  } catch (Exception e) {
         System.out.println(e);
	  }		
	}

	@Override
	public List<ComplaintVO> searchComplaint() {
		 List<ComplaintVO> complaintlist = new ArrayList<ComplaintVO>();
		try {
			Session session=sf.getCurrentSession();
		    String hql = "from ComplaintVO order by id desc";
		    Query query= session.createQuery(hql);
		    complaintlist = query.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
		return complaintlist;
	}
	


	
	
}
