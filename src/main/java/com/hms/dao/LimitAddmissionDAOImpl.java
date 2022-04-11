package com.hms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.ControlAdmissionVo;

@Repository
public class LimitAddmissionDAOImpl implements LimitAddmissionDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	/*@SuppressWarnings(unchecked)*/
	@Override
	public List<ControlAdmissionVo> findStatusAddmission() {
		// TODO Auto-generated method stub
		List<ControlAdmissionVo> list = new ArrayList<ControlAdmissionVo>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ControlAdmissionVo where status=true");
			list = query.list();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	
}
