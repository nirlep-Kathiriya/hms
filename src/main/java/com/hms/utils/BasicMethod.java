package com.hms.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class BasicMethod {

	private static final String BUCKETNAME = "hostel-management-system-project";
	private static final String ACCESSKEY = "AKIASPNIVWWYSYIZRYEI";
	private static final String SECRETKEY = "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";
	
	
	public static String getS3Link(MultipartFile pics,HttpSession s)
	{
		;
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
		return link;
	}

	public static String uploadFileToS3(String filePath) {

		File file = new File(filePath);
		String key = file.getName();
		String link = "";

		try {

			AmazonS3Client s3Client = new AmazonS3Client(new BasicAWSCredentials(ACCESSKEY, SECRETKEY));

			PutObjectRequest request = new PutObjectRequest(BUCKETNAME, key, file);
			request.setCannedAcl(CannedAccessControlList.PublicRead);
			s3Client.putObject(request);

			link = s3Client.getUrl(BUCKETNAME, key).toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return link;
	}
	
}
