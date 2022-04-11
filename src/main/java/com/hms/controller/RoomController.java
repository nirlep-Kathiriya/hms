package com.hms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hms.model.RoomVO;
import com.hms.service.*;

@Controller
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping(value="admin/loadAddRoom")
	public ModelAndView loadAddRoom()
	{
		return new ModelAndView("admin/addRoom","roomvo",new RoomVO());
	}
	
	@PostMapping(value="admin/insertRoom")
	public ModelAndView insertRoom(@ModelAttribute RoomVO roomvo,HttpSession session, HttpServletRequest request)
	{
		roomvo.setRemainBed(roomvo.getNumOfBed());
		
		
		List<RoomVO> list=this.roomService.checkRoomExistence(roomvo.getRoomNO(),roomvo.getBlockNo(),roomvo.getHostelType());
		System.out.println("Size Of exist room :"+list.size());
		if(list.size()==0)
		{
		this.roomService.insertRoom(roomvo);
		return new ModelAndView("redirect:/admin/loadAddRoom");
		}
		else
		{
			request.setAttribute("ErrorOfRoomExist","Room already exist");
			return new ModelAndView("redirect:/admin/loadAddRoom");
					//.addObject("ErrorOfRoomExist","Room already exist");
		}
	}
	
	@GetMapping(value="admin/viewRoom")
	public ModelAndView viewRoom()
	{
		List<RoomVO> roomlist = this.roomService.viewRoom();
		return new ModelAndView("admin/viewRoom","roomlist",roomlist);
	}
	
	@GetMapping(value="admin/editRoom")
	public ModelAndView editRoom(@RequestParam int id){
		List<RoomVO> roomList = roomService.findById(id);
		RoomVO roomVO = roomList.get(0);
		return new ModelAndView("admin/addRoom","roomvo",roomVO);
	}
	
	@GetMapping(value="admin/deleteRoom")
	public ModelAndView deleteRoom(@RequestParam int id, HttpSession session){
		List<RoomVO> roomList = roomService.findById(id);
		if(!roomList.isEmpty())
		{	
			RoomVO roomVO = roomList.get(0);
			if(roomVO.getNumOfBed()==roomVO.getRemainBed())
			{
				roomVO.setStatus(false);
				roomVO.setRoomStatus(false);
				roomService.insertRoom(roomVO);
			}
			else
			{
				session.setAttribute("CannotDelete","Cannot delete this room because it's already assigned");
				return new ModelAndView("redirect:/admin/viewRoom").addObject("CannotDelete","Cannot delete this room because it's already assigned");
			}
		}
		return new ModelAndView("redirect:/admin/viewRoom");
	}
}
