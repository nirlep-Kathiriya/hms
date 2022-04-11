package com.hms.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.StateVO;

@Repository
public class StateDAOImpl implements StateDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	/*@Override
	public void insertState(StateVO stateVO) {
		   try
		   {
    		Session session=sessionFactory.getCurrentSession();
    		session.saveOrUpdate(stateVO);
		   }catch(Exception e){}
	}*/

	@Override
	public List<StateVO> searchState() {
		// TODO Auto-generated method stub
		List<StateVO> list = new ArrayList<StateVO>();
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from StateVO where status=true");
			list = query.list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
		
	}


	@Override
	public List<StateVO> findById(int id) {
		// TODO Auto-generated method stub
		List<StateVO> list = new ArrayList<StateVO>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from StateVO where id="+id);
			list = query.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

}
