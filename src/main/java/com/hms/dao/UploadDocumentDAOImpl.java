package com.hms.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.ApplicationFormVO;
import com.hms.model.UploadDocumentVO;


@Repository
public class UploadDocumentDAOImpl implements UploadDocumentDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void uploadDocument(UploadDocumentVO uploadDocumentVO) {
		// TODO Auto-generated method stub
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(uploadDocumentVO);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}


	@Override
	public List<ApplicationFormVO> findByAppNo(String email, String appno) {
		// TODO Auto-generated method stub
		List<ApplicationFormVO> list = new ArrayList<ApplicationFormVO>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ApplicationFormVO where email='"+email+"' and applicationNo='"+appno+"'");
			list = query.list();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return list;
	}

}
