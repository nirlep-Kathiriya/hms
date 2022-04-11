package com.hms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.LoginVO;
import com.hms.model.SigninVO;

@Repository
public class SigninDaoImpl implements SigninDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public void insertSigninDetail(SigninVO sVo) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(sVo);
	}

	@Override
	public void insertLoginDetail(LoginVO lVo) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(lVo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoginVO> searchLoginDetails(String un, String Pass) {
		Session s = sf.getCurrentSession();
		Query q = s.createQuery("from LoginVO where username='" + un + "' and password='" + Pass + "' ");
		List<LoginVO> l = q.list();
		return l;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoginVO> searchEmail(String email) {
		Session s = sf.getCurrentSession();
		Query q = s.createQuery("from LoginVO where username='" + email + "' ");
		List<LoginVO> l = q.list();
		return l;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SigninVO> searchPhone(String phone) {
		Session s = sf.getCurrentSession();
		Query q = s.createQuery("from SigninVO where phone='" + phone + "' ");
		List<SigninVO> l = q.list();
		return l;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoginVO> findByEmail(String email) {
		Session s = sf.getCurrentSession();
		Query q = s.createQuery("from LoginVO where username='" + email + "' ");
		List<LoginVO> l = q.list();
		return l;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SigninVO> searchSigninDetail(String email) {
		Session s = sf.getCurrentSession();
		Query q = s.createQuery("from SigninVO where loginVO.username='" + email + "' ");
		List<SigninVO> l = q.list();
		return l;
	}

}
