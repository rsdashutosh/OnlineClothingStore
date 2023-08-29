package com.app.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface ImageHandlingService {
	
	// to upload the file to /images and set the path
	public String uploadImage(Integer productId, MultipartFile image) throws IOException;
	
	// to serve / download the images
	public byte[] serveImage(Integer productId) throws IOException;
}
