package com.hms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.GalleryVO;

@Repository
public class GalleryDAOImpl implements GalleryDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insertGallery(GalleryVO galleryvo) {
		// TODO Auto-generated method stub
		try{
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(galleryvo);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<GalleryVO> viewGallery() {
		// TODO Auto-generated method stub
		List<GalleryVO> gallerylist = new ArrayList<GalleryVO>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from GalleryVO where status=true");
			gallerylist = query.list();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return gallerylist;
	}

	@Override
	public List<GalleryVO> findById(int id) {
		// TODO Auto-generated method stub
		List<GalleryVO> gallerylist = new ArrayList<GalleryVO>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from GalleryVO where id="+id);
			gallerylist = query.list();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return gallerylist;
	}

	@Override
	public List<GalleryVO> searchGallery() {
		// TODO Auto-generated method stub
		List<GalleryVO> gallerylist = new ArrayList<GalleryVO>();
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from GalleryVO where status=true");
			gallerylist = query.list();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return gallerylist;
	}

}
