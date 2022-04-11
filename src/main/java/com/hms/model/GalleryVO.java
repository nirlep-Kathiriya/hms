package com.hms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hostel_photo")
public class GalleryVO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="Gallery_Type")
	private String galleryType;
	
	@Column(name="S3link")
	private String s3Link;
	
	@Column(name="status")
	private boolean status = true;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGalleryType() {
		return galleryType;
	}

	public void setGalleryType(String galleryType) {
		this.galleryType = galleryType;
	}

	public String getS3Link() {
		return s3Link;
	}

	public void setS3Link(String s3Link) {
		this.s3Link = s3Link;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
