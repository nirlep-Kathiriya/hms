package com.hms.service;

import java.util.List;

import com.hms.model.RoomVO;

public interface RoomService {

	void insertRoom(RoomVO roomvo);

	List<RoomVO> viewRoom();

	List<RoomVO> getRoomDetail(String gender);

	Long getRemainingBedOfBoys();

	Long getRemainingBedOfGirls();

	List<RoomVO> checkRoomExistence(int roomNO, String blockNO, String HostelType);
	
	List<RoomVO> findById(int id);

	
}
