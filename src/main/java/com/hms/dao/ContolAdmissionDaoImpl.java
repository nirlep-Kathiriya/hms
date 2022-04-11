package com.hms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.ControlAdmissionVo;

@Repository
public class ContolAdmissionDaoImpl implements ContolAdmissionDao{

	@Autowired
	SessionFactory sf;
	
	@Override
	public void insert(ControlAdmissionVo cAV) {
     
		try{
		Session s=sf.getCurrentSession();
		System.out.println("status dao = " + cAV.isActivateStatus());
        s.saveOrUpdate(cAV);
		}catch (Exception e) {
          e.getMessage();
		}
	}

	@Override
	public List<ControlAdmissionVo> checkActivation() {
		Session s=sf.getCurrentSession();
        Query q=s.createQuery("from ControlAdmissionVo where activateStatus=true");
        List<ControlAdmissionVo> l=q.list();
		return l;
	}

	

}
