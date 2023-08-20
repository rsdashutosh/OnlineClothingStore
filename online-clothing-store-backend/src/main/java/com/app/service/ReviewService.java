package com.app.service;

import java.util.List;
import com.app.dtos.ReviewDTO;

public interface ReviewService
{
	public String addReview(ReviewDTO reviewdto);
	public ReviewDTO getReview(Integer reviewId);
	public List<ReviewDTO> getAllReviews();
	public String deleteReview(Integer reviewId);
	public String editReview(Integer reviewId,ReviewDTO reviewdto);

}
