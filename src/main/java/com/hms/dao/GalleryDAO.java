package com.hms.dao;

import java.util.List;

import com.hms.model.GalleryVO;

public interface GalleryDAO {

	void insertGallery(GalleryVO galleryvo);

	List<GalleryVO> viewGallery();

	List<GalleryVO> findById(int id);

	List<GalleryVO> searchGallery();

}
