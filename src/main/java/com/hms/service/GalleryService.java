package com.hms.service;

import java.util.List;

import com.hms.model.GalleryVO;

public interface GalleryService {

	void insertGallery(GalleryVO galleryvo);

	List<GalleryVO> viewGallery();

	List<GalleryVO> findById(int id);

	List<GalleryVO> searchGallery();

}
