package com.hms.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.RoomVO;

@Repository
public class RoomDAOImpl implements RoomDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insertRoom(RoomVO roomvo) {
		// TODO Auto-generated method stub
		try{
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(roomvo);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<RoomVO> viewRoom() {
		// TODO Auto-generated method stub
		List<RoomVO> roomlist = new ArrayList<RoomVO>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query  = session.createQuery("from RoomVO where status=true");
			roomlist = query.list();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return roomlist;
	}

	@Override
	public List<RoomVO> getRoomDetail(String gender) {
		List<RoomVO> roomlist = new ArrayList<RoomVO>();
		
		String hostelType="";
		if(gender.equals("male"))
			hostelType="Boys Hostel";
		else if(gender.equals("female"))
			hostelType="Girls Hostel";
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query  = session.createQuery("from RoomVO where status=true and roomStatus=true and hostelType='"+hostelType+"'");
			roomlist = query.list();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return roomlist;
	}

	@Override
	public Long getRemainingBedOfBoys() {
		// TODO Auto-generated method stub
		List<RoomVO> roomlist = new ArrayList<RoomVO>();
		Long sum=null;
		try
		{
			String type="Boys Hostel";
			Session session = sessionFactory.getCurrentSession();
			String sumHql = "SELECT SUM(remainBed) as total FROM RoomVO WHERE hostelType='"+type+"' and status=true and roomStatus=true";
			Query query = session.createQuery(sumHql);
			for(Iterator it=query.iterate();it.hasNext();)
			  {
			   sum =  (Long)it.next();
			  }
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return sum;
	}

	@Override
	public Long getRemainingBedOfGirls() {
		// TODO Auto-generated method stub
		Long sum=null;
		try
		{
			
			 
			String type="Girls Hostel";
			Session session = sessionFactory.getCurrentSession();
			String sumHql = "SELECT SUM(remainBed) as total FROM RoomVO WHERE hostelType='"+type+"' and status=true and roomStatus=true";
			Query query = session.createQuery(sumHql);
			for(Iterator it=query.iterate();it.hasNext();)
			  {
			    sum =  (Long)it.next();
			  }
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return sum;


	}

	@Override
	public List<RoomVO> checkRoomExistence(int roomNO,String blockNO,String HostelType) {
		List<RoomVO> roomlist = new ArrayList<RoomVO>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query  = session.createQuery("from RoomVO where roomNO="+roomNO+"and blockNo='"+blockNO+"' and hostelType='"+HostelType+"' and status=true and roomstatus=true" );
			roomlist = query.list();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return roomlist;
		
		
	}

	@Override
	public List<RoomVO> findById(int id) {
		List<RoomVO> listRoom = new ArrayList<RoomVO>();
		try{
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from RoomVO where id="+id+"and status=true");
			listRoom = q.list();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listRoom;
	}

}
