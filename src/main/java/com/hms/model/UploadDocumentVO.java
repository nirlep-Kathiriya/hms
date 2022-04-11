package com.hms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="fresher_document")
public class UploadDocumentVO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	
	
	@Column(name="profilePhoto")
	private String profilePhoto;
	
	@Column(name="identityProof")
	private String identitiyProof;
	
	@Column(name="graduationTranscript")
	private String graduationTranscript;
	
	@Column(name="graduationMarksheet")
	private String graduationMarksheet;
	
	@Column(name="addressProof")
	private String addressProof;
	
	@Column(name="addmissionSlip")
	private String addmissionSlip;
	
	@Column(name="identitiyProofType")
	private String identitiyProofType;
	
	@Column(name="acceptStatus")
	private boolean acceptStatus=false;
	
	@Column(name="rejectStatus")
	private boolean rejectStatus=false;
	
	public boolean isRejectStatus() {
		return rejectStatus;
	}

	public void setRejectStatus(boolean rejectStatus) {
		this.rejectStatus = rejectStatus;
	}

	@ManyToOne
	@JoinColumn(name="applicationform_id")
	private ApplicationFormVO applicationFormVO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	
	public String getIdentitiyProof() {
		return identitiyProof;
	}

	public void setIdentitiyProof(String identitiyProof) {
		this.identitiyProof = identitiyProof;
	}

	
	public String getGraduationTranscript() {
		return graduationTranscript;
	}

	public void setGraduationTranscript(String graduationTranscript) {
		this.graduationTranscript = graduationTranscript;
	}

	public String getGraduationMarksheet() {
		return graduationMarksheet;
	}

	public void setGraduationMarksheet(String graduationMarksheet) {
		this.graduationMarksheet = graduationMarksheet;
	}

	public String getAddressProof() {
		return addressProof;
	}

	public void setAddressProof(String addressProof) {
		this.addressProof = addressProof;
	}

	public String getAddmissionSlip() {
		return addmissionSlip;
	}

	public void setAddmissionSlip(String addmissionSlip) {
		this.addmissionSlip = addmissionSlip;
	}

	public String getIdentitiyProofType() {
		return identitiyProofType;
	}

	public void setIdentitiyProofType(String identitiyProofType) {
		this.identitiyProofType = identitiyProofType;
	}


	public boolean isAcceptStatus() {
		return acceptStatus;
	}

	public void setAcceptStatus(boolean acceptStatus) {
		this.acceptStatus = acceptStatus;
	}

	public ApplicationFormVO getApplicationFormVO() {
		return applicationFormVO;
	}

	public void setApplicationFormVO(ApplicationFormVO applicationFormVO) {
		this.applicationFormVO = applicationFormVO;
	}
	
	
	
	
}
