package com.hms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="room_detail")
public class RoomVO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="block_no")
	private String blockNo;
	
	@Column(name="floor_no")
	private int floorNo=0;
	
	@Column(name="hostel_type")
	private String hostelType;
	
	public String getBlockNo() {
		return blockNo;
	}

	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}

	public int getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}

	public String getHostelType() {
		return hostelType;
	}

	public void setHostelType(String hostelType) {
		this.hostelType = hostelType;
	}

	@Column(name="room_no")
	private int roomNO=0;
	
	@Column(name="num_of_bed")
	private int numOfBed=0;
	
	@Column(name="remain_bed")
	private int remainBed=0;
	
	@Column(name="status")
	private boolean status=true;

	@Column(name="roomstatus")
	private boolean roomStatus=true;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomNO() {
		return roomNO;
	}

	public void setRoomNO(int roomNO) {
		this.roomNO = roomNO;
	}

	public int getNumOfBed() {
		return numOfBed;
	}

	public void setNumOfBed(int numOfBed) {
		this.numOfBed = numOfBed;
	}

	public int getRemainBed() {
		return remainBed;
	}

	public void setRemainBed(int remainBed) {
		this.remainBed = remainBed;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(boolean roomStatus) {
		this.roomStatus = roomStatus;
	}
	
	
}
