package com.hms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.FeedbackVO;

@Repository
public class FeedbackDAOImpl implements FeedbackDAO{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public void insertFeedback(FeedbackVO feedbackVO) {
		// TODO Auto-generated method stub
		try{
			Session session = sf.getCurrentSession();
			session.save(feedbackVO);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<FeedbackVO> viewFeedback() {
		
		List<FeedbackVO> list =new ArrayList<FeedbackVO>();
		try{
			Session session = sf.getCurrentSession();
			Query q=session.createQuery("from FeedbackVO");
			list=q.list();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return list;
	}

	
}
