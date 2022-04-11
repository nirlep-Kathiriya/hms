package com.hms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.CityVO;

@Repository
public class CityDAOImpl implements CityDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insertCity(CityVO cityVO) {
		// TODO Auto-generated method stub
		try
		{
			/*System.out.println(cityVO.getCityName());
			System.out.println(cityVO.getStatevo().getId());
			*/
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(cityVO);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<CityVO> viewCity() {
		// TODO Auto-generated method stub
		List<CityVO> list = new ArrayList<CityVO>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CityVO where status=true");
			list = query.list();
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
		return list;
	}

	@Override
	public List<CityVO> findById(int id) {
		// TODO Auto-generated method stub
		List<CityVO> list = new ArrayList<CityVO>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CityVO where id="+id);
			list = query.list();
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
		return list;
	}

	@Override
	public List<CityVO> searchCity(String state) {
		List<CityVO> list = new ArrayList<CityVO>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			System.out.println("fsdfgs  "+state);
			Query query = session.createQuery("from CityVO where statevo.stateName='"+state+"'");
			System.out.println("fsdfgs");
			list = query.list();
			System.out.println("fsdfgs===="+list.size());

		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
		return list;
	}

	
}
