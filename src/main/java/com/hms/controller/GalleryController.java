package com.hms.controller;


import java.io.BufferedOutputStream;

import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hms.model.GalleryVO;
import com.hms.service.GalleryService;
import com.hms.utils.BasicMethod;



@Controller
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;

	@GetMapping(value="admin/loadAddGallery")
	public ModelAndView  loadAddGallery()
	{
		return new ModelAndView("admin/addGallery","galleryvo",new GalleryVO());
	}
	
	@PostMapping(value="admin/insertGallery")
	public ModelAndView insertGallery(@ModelAttribute GalleryVO galleryvo,@RequestParam MultipartFile pics,HttpSession s)throws Exception
	{
		
					String filename = pics.getOriginalFilename();
					System.out.println(filename);
			
					String filePath = s.getServletContext().getRealPath("");
					System.out.println(filePath);
					filePath = filePath + "docs\\";
					System.out.println(filePath);
					try {
						byte[] b = pics.getBytes();
						System.out.println("before buffeer" + filePath + filename);
			
						FileOutputStream fs = new FileOutputStream(filePath + filename);
						BufferedOutputStream bs = new BufferedOutputStream(fs);
						bs.write(b);
						bs.close();
						fs.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
			
					String link = BasicMethod.uploadFileToS3(filePath + filename);
					System.out.println(link);
			
					galleryvo.setS3Link(link);					
					this.galleryService.insertGallery(galleryvo);
		
		return new ModelAndView("redirect:/admin/loadAddGallery");
	}
	
	@GetMapping(value="admin/viewGallery")
	public ModelAndView viewGallery()
	{
		List<GalleryVO> gallerylist = this.galleryService.viewGallery();
		return new ModelAndView("admin/viewGallery","gallerylist",gallerylist);
	}
	
	@GetMapping(value="admin/deletePhoto")
	public ModelAndView deletePhoto(@ModelAttribute GalleryVO galleryvo,@RequestParam int id)
	{
		List<GalleryVO> gallerylist = this.galleryService.findById(id);
		galleryvo = gallerylist.get(0);
		galleryvo.setStatus(false);
		this.galleryService.insertGallery(galleryvo);
		return new ModelAndView("redirect:/admin/viewGallery");
	}
	
}

