package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.PaymentStatusDAO;
import com.hms.model.ApplicationFormVO;
import com.hms.model.PaymentStatusVO;
import com.hms.model.UploadDocumentVO;

@Service
@Transactional
public class PaymentStatusServiceImpl implements PaymentStatusService {

	@Autowired
	private PaymentStatusDAO psd;
	
	@Override
	public void insertPaymentStatus(PaymentStatusVO psvo) {
		// TODO Auto-generated method stub
		this.psd.insertPaymentStatus(psvo);
	}

	@Override
	public List<PaymentStatusVO> searchStudent() {
		// TODO Auto-generated method stub
		return this.psd.searchStudent();
	}

	
	@Override
	public List<ApplicationFormVO> checkForEmailAndAppId(String emailId, String appId) {
		// TODO Auto-generated method stub
		return this.psd.checkForEmailAndAppId(emailId,appId);
	}

	@Override
	public List<UploadDocumentVO> checkForDocument(String emailId, String appId) {
		// TODO Auto-generated method stub
		return this.psd.checkForDocument(emailId,appId);
	}

	

	@Override
	public List<PaymentStatusVO> checkForPaymentAccept(int id) {
		// TODO Auto-generated method stub
		return this.psd.checkForPaymentAccept(id);
	}

	@Override
	public List<PaymentStatusVO> checkForPaymentPending(int id) {
		// TODO Auto-generated method stub
		return this.psd.checkForPaymentPending(id);
	}

	@Override
	public List<PaymentStatusVO> changePaymentStatusToSuccess(String appId, String emailId) {
		// TODO Auto-generated method stub
		return this.psd.changePaymentStatusToSuccess(appId,emailId);
	}

	@Override
	public List<PaymentStatusVO> checkForRegular(String email) {
		// TODO Auto-generated method stub
		return this.psd.checkForRegular(email);
	}

}
