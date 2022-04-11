package com.hms.dao;

import java.util.List;

import com.hms.model.ApplicationFormVO;
import com.hms.model.PaymentStatusVO;
import com.hms.model.UploadDocumentVO;

public interface PaymentStatusDAO {

	void insertPaymentStatus(PaymentStatusVO psvo);

	List<PaymentStatusVO> searchStudent();

	List<PaymentStatusVO> changePaymentStatusToSuccess(String appId, String emailId);

	List<ApplicationFormVO> checkForEmailAndAppId(String emailId, String appId);

	List<UploadDocumentVO> checkForDocument(String emailId, String appId);

	List<PaymentStatusVO> checkForPaymentAccept(int id);

	List<PaymentStatusVO> checkForPaymentPending(int id);

	List<PaymentStatusVO> checkForRegular(String email);

	

}
