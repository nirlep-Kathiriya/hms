package com.hms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.ApplicationFormVO;

@Repository
public class ApplicationFormDAOImpl implements ApplicationFormDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertapplicationform(ApplicationFormVO afvo) {
		// TODO Auto-generated method stub
		try
		{
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(afvo);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<ApplicationFormVO> varifyRegularStudent(String email) {
		// TODO Auto-generated method stub
        List<ApplicationFormVO> list=new ArrayList<ApplicationFormVO>();
        try{
        	Session session=sessionFactory.getCurrentSession();
        	Query q=session.createQuery("from ApplicationFormVO where email='"+email+"'");
        	list=q.list();
        }catch(Exception e){
        	System.out.print(e.getMessage());
        }
        return list;
	
	}

	@Override
	public List<ApplicationFormVO> search() {
		// TODO Auto-generated method stub
		List<ApplicationFormVO> list = new ArrayList<ApplicationFormVO>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			String q = "select email from ApplicationFormVO";
			Query query = session.createQuery(q);
			list= query.list();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	
	
}
