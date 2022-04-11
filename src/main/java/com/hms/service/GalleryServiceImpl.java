package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.GalleryDAO;
import com.hms.model.GalleryVO;

@Service
@Transactional
public class GalleryServiceImpl implements GalleryService{

	@Autowired
	private GalleryDAO gallerydao;
	
	@Override
	public void insertGallery(GalleryVO galleryvo) {
		// TODO Auto-generated method stub
		this.gallerydao.insertGallery(galleryvo);
	}

	@Override
	public List<GalleryVO> viewGallery() {
		// TODO Auto-generated method stub
		return this.gallerydao.viewGallery();
	}

	@Override
	public List<GalleryVO> findById(int id) {
		// TODO Auto-generated method stub
		return this.gallerydao.findById(id);
	}

	@Override
	public List<GalleryVO> searchGallery() {
		// TODO Auto-generated method stub
		return this.gallerydao.searchGallery();
	}

}
