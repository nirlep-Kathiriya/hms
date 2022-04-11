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
@Table(name="payment_status")
public class PaymentStatusVO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="uploadDocumentForignkey")
	private UploadDocumentVO udvo;
	
	@Column(name="payment_status")
	private String paymentStatus = "pending";
	
	@ManyToOne
	@JoinColumn(name="roomId")
	private RoomVO roomVO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	


	
	public UploadDocumentVO getUdvo() {
		return udvo;
	}

	public void setUdvo(UploadDocumentVO udvo) {
		this.udvo = udvo;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public RoomVO getRoomVO() {
		return roomVO;
	}

	public void setRoomVO(RoomVO roomVO) {
		this.roomVO = roomVO;
	}

	
	
	
	
	
	
	
}
