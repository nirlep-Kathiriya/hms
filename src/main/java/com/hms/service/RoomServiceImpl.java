package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.RoomDAO;
import com.hms.model.RoomVO;

@Service
@Transactional
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomDAO roomdao;
	
	@Override
	public void insertRoom(RoomVO roomvo) {
		// TODO Auto-generated method stub
		this.roomdao.insertRoom(roomvo);
	}

	@Override
	public List<RoomVO> viewRoom() {
		// TODO Auto-generated method stub
		return this.roomdao.viewRoom();
	}

	@Override
	public List<RoomVO> getRoomDetail(String gender) {
		
       
       
	   return this.roomdao.getRoomDetail(gender);   
	}

	@Override
	public Long getRemainingBedOfBoys() {
		// TODO Auto-generated method stub
		return this.roomdao.getRemainingBedOfBoys();
	}

	@Override
	public Long getRemainingBedOfGirls() {
		// TODO Auto-generated method stub
		return this.roomdao.getRemainingBedOfGirls();
	}

	@Override
	public List<RoomVO> checkRoomExistence(int roomNO, String blockNO, String HostelType) {
		return this.roomdao.checkRoomExistence(roomNO,blockNO,HostelType);
	}

	@Override
	public List<RoomVO> findById(int id) {
		return this.roomdao.findById(id);
	}

}
