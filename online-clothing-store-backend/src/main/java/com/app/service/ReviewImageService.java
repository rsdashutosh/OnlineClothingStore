package com.app.service;

import java.util.List;
import com.app.dtos.ReviewImageDTO;

public interface ReviewImageService {
	
	public String addReviewImage(ReviewImageDTO ReviewImageDto);
	public ReviewImageDTO getReviewImage(Integer ReviewImageId);
	public List<ReviewImageDTO> getAllReviewImages();
	public String updateReviewImageDetails(Integer ReviewImageId, ReviewImageDTO ReviewImageDto);
	public String deleteReviewImage(Integer ReviewImageId);
}
