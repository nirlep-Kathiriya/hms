package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hms.service.CityService;
import com.hms.service.StateService;
import com.hms.model.CityVO;
import com.hms.model.StateVO;

@Controller
public class CityController {

	@Autowired 
	private CityService cityService;
	
	@Autowired
	private StateService stateService;
	
	@GetMapping(value="admin/loadInsertCity")
	public ModelAndView loadInsertState()
	{
		List<StateVO> statelist = this.stateService.searchState();
		return new ModelAndView("admin/addCity","cityvo",new CityVO()).addObject("statelist", statelist);
	}
	
	@PostMapping(value="admin/insertCity")
	public ModelAndView insertCity(@ModelAttribute CityVO cityVO)
	{
		this.cityService.insertCity(cityVO);
		return new ModelAndView("redirect:/admin/loadInsertCity");
	}
	
	@GetMapping(value="admin/viewCity")
	public ModelAndView viewCity()
	{
		List<CityVO> list =  this.cityService.viewCity();
		return new ModelAndView("admin/viewCity","citylist",list);
	}
	
	@GetMapping(value="admin/editCity")
	public ModelAndView editCity(@RequestParam int id,@ModelAttribute CityVO cityvo)
	{
		List<CityVO> list = this.cityService.findById(id);
		cityvo = list.get(0);
		List<StateVO> statelist = this.stateService.searchState();
		return new ModelAndView("admin/addCity","cityvo",cityvo).addObject("statelist", statelist);
	}
	
	@GetMapping(value="admin/deleteCity")
	public ModelAndView deleteCity(@RequestParam int id,@ModelAttribute CityVO cityvo)
	{
		List<CityVO> list = this.cityService.findById(id);
		cityvo = list.get(0);
		cityvo.setStatus(false);
		this.cityService.insertCity(cityvo);
		return new ModelAndView("redirect:/admin/viewCity");
	}
}
