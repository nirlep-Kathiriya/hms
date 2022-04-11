package com.hms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.UploadDocumentVO;

@Repository
public class LoadAdminFeatureDAOImpl implements LoadAdminFeatureDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<UploadDocumentVO> searchFresherDetail() {
		List<UploadDocumentVO> list = new ArrayList<UploadDocumentVO>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from UploadDocumentVO where acceptStatus=false and rejectStatus=false");
			list = query.list();
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
		return list;
	}

	@Override
	public List<UploadDocumentVO> searchFresherDocument(int documentListId) {
		List<UploadDocumentVO> list = new ArrayList<UploadDocumentVO>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from UploadDocumentVO where  id="+documentListId);
			list = query.list();
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
		return list;
		
	}

	@Override
	public List<UploadDocumentVO> searchHostelStudentDetail() {
		List<UploadDocumentVO> list = new ArrayList<UploadDocumentVO>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from UploadDocumentVO where acceptStatus=true and rejectStatus=false");
			list = query.list();
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
		return list;
	}

	
}
