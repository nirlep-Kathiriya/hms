package com.hms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.ApplicationFormVO;
import com.hms.model.PaymentStatusVO;
import com.hms.model.UploadDocumentVO;

@Repository
public class PaymentStatusDAOImpl implements PaymentStatusDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	public void insertPaymentStatus(PaymentStatusVO psvo) {
		// TODO Auto-generated method stub
		try {
			Session session = sf.getCurrentSession();
			session.saveOrUpdate(psvo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<PaymentStatusVO> searchStudent() {
		// TODO Auto-generated method stub
		List<PaymentStatusVO> paymentstatuslist = new ArrayList<PaymentStatusVO>();
		try {
			Session session = sf.getCurrentSession();
			Query query = session.createQuery("from PaymentStatusVO");
			paymentstatuslist = query.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return paymentstatuslist;
	}

	@Override
	public List<ApplicationFormVO> checkForEmailAndAppId(String emailId, String appId) {
		// TODO Auto-generated method stub
		List<ApplicationFormVO> applist = new ArrayList<ApplicationFormVO>();
		try
		{
			Session session = sf.getCurrentSession();
			Query query = session.createQuery("from ApplicationFormVO where applicationNo='"+appId+"' and email='"+emailId+"'");
			applist = query.list();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return applist;
	}

	@Override
	public List<UploadDocumentVO> checkForDocument(String emailId, String appId) {
		// TODO Auto-generated method stub
		List<UploadDocumentVO> uploadlist = new ArrayList<UploadDocumentVO>();
		try
		{
			Session session = sf.getCurrentSession();
			Query query = session.createQuery("from UploadDocumentVO where applicationFormVO.email='"+emailId+"' and applicationFormVO.applicationNo='"+appId+"'");
			uploadlist = query.list();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return uploadlist;
	}

	@Override
	public List<PaymentStatusVO> checkForPaymentAccept(int id) {
		// TODO Auto-generated method stub
		List<PaymentStatusVO> paymentlist = new ArrayList<PaymentStatusVO>();
		try
		{
			Session session = sf.getCurrentSession();
			Query query = session.createQuery("from PaymentStatusVO where udvo="+id);
			paymentlist = query.list();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return paymentlist;
	}

	@Override
	public List<PaymentStatusVO> checkForPaymentPending(int id) {
		// TODO Auto-generated method stub
		List<PaymentStatusVO> paymentlist = new ArrayList<PaymentStatusVO>();
		try
		{
			Session session = sf.getCurrentSession();
			Query query = session.createQuery("from PaymentStatusVO where paymentStatus='pending' and id="+id);
			paymentlist = query.list();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return paymentlist;
	}

	@Override
	public List<PaymentStatusVO> changePaymentStatusToSuccess(String appId, String emailId) {

		List<PaymentStatusVO> paymentstatuslist = new ArrayList<PaymentStatusVO>();

		try {
			Session session = sf.getCurrentSession();
			Query q = session.createQuery("from PaymentStatusVO where udvo.applicationFormVO.applicationNo='" + appId
					+ "' and udvo.applicationFormVO.email='"+emailId+"' and paymentStatus='pending'");
			
			paymentstatuslist=q.list();
			
		} catch (Exception e) {
          System.out.print(e.getMessage());
		}
		return paymentstatuslist;
	}

	@Override
	public List<PaymentStatusVO> checkForRegular(String email) {
		// TODO Auto-generated method stub
		List<PaymentStatusVO> paymentstatuslist = new ArrayList<PaymentStatusVO>();

		try {
			Session session = sf.getCurrentSession();
			Query q = session.createQuery("from PaymentStatusVO where udvo.applicationFormVO.email='"+email+"'");
			
			paymentstatuslist=q.list();
			
		} catch (Exception e) {
          System.out.print(e.getMessage());
		}
		return paymentstatuslist;
	}

}
