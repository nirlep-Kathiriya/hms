package com.hms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.apt.dispatch.BaseMessagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hms.model.ApplicationFormVO;
import com.hms.model.ComplaintVO;
import com.hms.model.PaymentStatusVO;
import com.hms.model.RoomVO;
import com.hms.model.UploadDocumentVO;
import com.hms.service.ApplicationFormService;
import com.hms.service.ComplaintService;
import com.hms.service.LimitAddmissionService;
import com.hms.service.LoadAdminFeatureService;
import com.hms.service.PaymentStatusService;
import com.hms.service.RoomService;
import com.hms.service.UploadDocumentService;
import com.hms.utils.Basemethods;
import com.hms.utils.BasicMethod;

@Controller

public class LoadAdminFeatureController {

	@Autowired
	private LoadAdminFeatureService loadAdminFeatureService;

	@Autowired
	private LimitAddmissionService limitAddmissionService;

	@Autowired
	private ApplicationFormService applicationFormService;

	@Autowired
	private UploadDocumentService uploadDocumentService;

	@Autowired
	private RoomService roomService;

	@Autowired
	private PaymentStatusService paymentStatusService;

	@Autowired
	private ComplaintService complaintService;

	@GetMapping(value = "admin/paymentStatusOfStudent")
	public ModelAndView paymentStatusOfStudent() {
		List<PaymentStatusVO> paymentstatuslist = this.paymentStatusService.searchStudent();
		System.out.println(paymentstatuslist.size());

		/*
		 * PaymentStatusVO psvo = paymentstatuslist.get(0);
		 * System.out.println(psvo.getPaymentStatus()+" "+psvo.getUdvo().
		 * getApplicationFormVO().getEmail());
		 */

		return new ModelAndView("admin/ViewPaymentStatus", "list", paymentstatuslist);
	}

	@GetMapping(value = "admin/loadFresherPendingRequest")
	public ModelAndView loadFresherPendingRequest() {
		
		long remainBoyBed,remainGirlBed;
		if(this.roomService.getRemainingBedOfBoys()==null)
			remainBoyBed=0;
		else
			remainBoyBed = this.roomService.getRemainingBedOfBoys().longValue();
		 
		if(this.roomService.getRemainingBedOfGirls()==null)
			remainGirlBed=0;
		else
			remainGirlBed = this.roomService.getRemainingBedOfGirls().longValue();

		System.out.println("remainBoyBed    " + remainBoyBed);
		System.out.println("remainGirlBed    " + remainGirlBed);

		boolean status = this.limitAddmissionService.findStatusAddmission();
		List<UploadDocumentVO> list = this.loadAdminFeatureService.searchFresherDetail();
		return new ModelAndView("admin/ViewFresherPendingRequest", "fresherlist", list)
				.addObject("remainBoyBed", remainBoyBed).addObject("remainGirlBed", remainGirlBed)
				.addObject("StatusOfAddmission", status);
	}

	@GetMapping(value = "admin/loadFresherDocument")
	public ModelAndView loadFresherDocument(HttpSession session, @RequestParam int documentListId) {
		System.out.println("vsdfasdfsadfsfd" + "   " + documentListId);

		List<UploadDocumentVO> fresherDocumentList = this.loadAdminFeatureService.searchFresherDocument(documentListId);
		return new ModelAndView("admin/ViewFresherDocument", "fresherDocumentList", fresherDocumentList);
	}

	@GetMapping(value = "admin/acceptFresherRequest")
	public ModelAndView acceptFresherRequest(@RequestParam int documentListId) {
		List<UploadDocumentVO> fresherDocumentList = this.loadAdminFeatureService.searchFresherDocument(documentListId);
		UploadDocumentVO udvo = (UploadDocumentVO) fresherDocumentList.get(0);

		List<RoomVO> list = this.roomService.getRoomDetail(udvo.getApplicationFormVO().getGender());
		System.out.println(list.size());
		if (list.size() == 0) {
			return new ModelAndView("redirect:/admin/loadFresherPendingRequest");
		} else {
			
			//set status of acceptance to true in application form and fresher doc table
			udvo.setAcceptStatus(true);
			udvo.getApplicationFormVO().setAcceptStatus(true);
			this.applicationFormService.insertapplicationform(udvo.getApplicationFormVO());
			this.uploadDocumentService.uploadDocument(udvo);

			
			//find room number and set remaining beds on that room.
			RoomVO roomVO = (RoomVO) list.get(0);
			int remainingBAD = roomVO.getRemainBed() - 1;
			if (remainingBAD == 0) {
				roomVO.setRoomStatus(false);
			}
			System.out.println("BED :- " + remainingBAD + "room" + roomVO.getRoomNO());
			roomVO.setRemainBed(remainingBAD);
			this.roomService.insertRoom(roomVO);

			// insert into payment status table
			PaymentStatusVO psvo = new PaymentStatusVO();
			psvo.setRoomVO(roomVO);
			psvo.setUdvo(udvo);
			this.paymentStatusService.insertPaymentStatus(psvo);

			Basemethods.sendAcceptFresherRequestMail(udvo.getApplicationFormVO().getEmail(),
					"Your Application for hostel accepted and you are ready for payment",
					udvo.getApplicationFormVO().getFirstName());

			return new ModelAndView("redirect:/admin/loadFresherPendingRequest");
		}
	}

	@GetMapping(value = "admin/rejectFresherRequest")
	public ModelAndView rejectFresherRequest(@RequestParam int documentListId) {
		List<UploadDocumentVO> fresherDocumentList = this.loadAdminFeatureService.searchFresherDocument(documentListId);
		UploadDocumentVO udvo = (UploadDocumentVO) fresherDocumentList.get(0);
		udvo.setRejectStatus(true);
		udvo.getApplicationFormVO().setRejectStatus(true);

		this.applicationFormService.insertapplicationform(udvo.getApplicationFormVO());
		this.uploadDocumentService.uploadDocument(udvo);

		Basemethods.sendAcceptFresherRequestMail(udvo.getApplicationFormVO().getEmail(),
				"Your Application for hostel rejected.", udvo.getApplicationFormVO().getFirstName());

		return new ModelAndView("redirect:/admin/loadFresherPendingRequest");
	}

	@GetMapping(value = "admin/loadHostelStudentDetail")
	public ModelAndView loadHostelStudentDetail() {
		List<UploadDocumentVO> list = this.loadAdminFeatureService.searchHostelStudentDetail();
		return new ModelAndView("admin/ViewHostelStudentDetail", "HostelStudentList", list);

	}

	@GetMapping(value = "admin/viewComplaint")
	public ModelAndView viewComplaint() {
		List<ComplaintVO> list = this.complaintService.searchComplaint();
		return new ModelAndView("admin/viewComplaint", "listOfComplaint", list);
	}
	
	@GetMapping(value = "admin/sendPendingPaymentMail")
	public ModelAndView sendPendingPaymentMail(@RequestParam String email, HttpSession session) {
		Basemethods.sendMail(email,
				"Your payment is Pending");
		return new ModelAndView("redirect:/admin/paymentStatusOfStudent");	
	}

}
