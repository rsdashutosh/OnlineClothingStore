package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dtos.ReviewImageDTO;
import com.app.pojos.ReviewImage;

public interface ReviewImageService {
	
	public String addReviewImage(ReviewImageDTO reviewImageDTO) throws IOException;
	public byte[] getReviewImage(Integer review,Integer ImageId);
	public List<byte[]> getAllReviewImages(Integer reviewId);
	public String updateReviewImageDetails(Integer reviewImageId, ReviewImageDTO reviewImageDto) throws IOException;
	public String deleteReviewImage(Integer reviewImageId);
	//public String uploadImage(Integer reviewImageId, MultipartFile image);
}
