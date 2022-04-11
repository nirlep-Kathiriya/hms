package com.hms.controller;

import java.io.BufferedOutputStream;

import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hms.model.ApplicationFormVO;
import com.hms.model.GalleryVO;
import com.hms.model.UploadDocumentVO;

import com.hms.service.UploadDocumentService;
import com.hms.utils.BasicMethod;

@Controller
public class UploadDocumentController {

	@Autowired
	private UploadDocumentService uploadDocumentService ;
	
	

	@PostMapping(value = "user/uploadDocument")
	public ModelAndView uploadDocument(@RequestParam MultipartFile profilePhoto,
			@RequestParam MultipartFile graduationTranscript, @RequestParam MultipartFile graduationMarksheet,
			@RequestParam MultipartFile identityProofImage, @RequestParam MultipartFile addressProof,
			@RequestParam MultipartFile addmissionSlip, @RequestParam String identityProof,
			@RequestParam String email,@RequestParam String appno,HttpSession s
			)throws Exception {
		
		
		UploadDocumentVO uploadDocumentVO = new UploadDocumentVO();
		
		uploadDocumentVO.setProfilePhoto(BasicMethod.getS3Link(profilePhoto,s));
		uploadDocumentVO.setIdentitiyProofType(identityProof);
		uploadDocumentVO.setGraduationTranscript(BasicMethod.getS3Link(graduationTranscript,s));
		uploadDocumentVO.setGraduationMarksheet(BasicMethod.getS3Link(graduationMarksheet,s));
		uploadDocumentVO.setIdentitiyProof(BasicMethod.getS3Link(identityProofImage,s));
		uploadDocumentVO.setAddressProof(BasicMethod.getS3Link(addressProof,s));
		uploadDocumentVO.setAddmissionSlip(BasicMethod.getS3Link(addmissionSlip,s));
		uploadDocumentVO.setApplicationFormVO((ApplicationFormVO)this.uploadDocumentService.findByAppNo(email,appno).get(0));
		this.uploadDocumentService.uploadDocument(uploadDocumentVO);
		return new ModelAndView("redirect:/user/loadUserPage");
	}
	
	}
