package com.hms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hms.model.ApplicationFormVO;
import com.hms.model.PaymentStatusVO;
import com.hms.model.UploadDocumentVO;
import com.hms.service.PaymentStatusService;
import com.hms.utils.Basemethods;

@Controller
public class PaymentController {

	@Autowired
	private PaymentStatusService paymentService;

	@GetMapping(value = "user/loadPayFees")
	public ModelAndView loadPayFees() {
		return new ModelAndView("user/PaymentGateway");
	}

	@PostMapping(value = "user/payFees")
	public ModelAndView payFees(@RequestParam String appId, @RequestParam String emailId, @RequestParam String fullName,
			@RequestParam String studentType, @RequestParam String AcademicYear, HttpSession session) {
		List<ApplicationFormVO> applist = this.paymentService.checkForEmailAndAppId(emailId, appId);
		if (applist.size() != 0) {
			List<UploadDocumentVO> uploadlist = this.paymentService.checkForDocument(emailId, appId);
			if (uploadlist.size() != 0) {
				System.out.println("document found");
				List<PaymentStatusVO> paymentlist = this.paymentService
						.checkForPaymentAccept(uploadlist.get(0).getId());
				if (paymentlist.size() != 0) {
					System.out.println("accepted by admin");
					List<PaymentStatusVO> paymentlist2 = this.paymentService
							.checkForPaymentPending(paymentlist.get(0).getId());
					if (paymentlist2.size() != 0) {
						/* System.out.println("ready payment"); */
						session.setAttribute("appId", appId);
						session.setAttribute("emailId", emailId);
						session.setAttribute("studentType", studentType);
						session.setAttribute("AcademicYear", AcademicYear);
						List<PaymentStatusVO> list = this.paymentService.changePaymentStatusToSuccess(appId, emailId);
						PaymentStatusVO paymentVO = list.get(0);
						session.setAttribute("paymentVO",paymentVO);
						return new ModelAndView("user/RazorPay");
					} else {
						return new ModelAndView("user/PaymentGateway").addObject("paymenterror",
								"Your Payment is already done");
					}
				} else {
					/* System.out.println("not accepted by admin"); */
					return new ModelAndView("user/PaymentGateway").addObject("paymenterror",
							"Your Request is till not accepted");
				}
			} else {
				/* System.out.println("document not found"); */
				return new ModelAndView("user/PaymentGateway").addObject("paymenterror", "First upload your document");
			}
		} else {
			/* System.out.println("not found"); */
			return new ModelAndView("user/PaymentGateway").addObject("paymenterror",
					"Please enter valid application Id or Registered email Id");
		}

	}

	@PostMapping(value = "user/generatePaymentReceipt")
	public ModelAndView generatePaymentReceipt(HttpSession session) {
	
		String appId = (String) session.getAttribute("appId");
		String emailId = (String) session.getAttribute("emailId");
		List<PaymentStatusVO> list = this.paymentService.changePaymentStatusToSuccess(appId, emailId);
		PaymentStatusVO paymentVO = list.get(0);
		paymentVO.setPaymentStatus("Success");
		
		Basemethods.sendMail(paymentVO.getUdvo().getApplicationFormVO().getEmail(),
				"Your payment is done for the hostel. Your room number is "+paymentVO.getRoomVO().getRoomNO());
		
		this.paymentService.insertPaymentStatus(paymentVO);
		
		session.setAttribute("paymentVO",paymentVO);
		return new ModelAndView("user/PaymentReceipt");
	}
	
	
}
