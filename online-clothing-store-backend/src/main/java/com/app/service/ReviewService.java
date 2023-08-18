package com.app.service;

import java.sql.Blob;
import java.util.List;

import com.app.dtos.ReviewDto;

public interface ReviewService
{
	public String addReview(ReviewDto reviewdto);
	public ReviewDto getReview(Integer reviewId);
	public List<ReviewDto> getAllReviews();
	public String deleteReview(Integer reviewId);
	public String editReview(Integer reviewId,ReviewDto reviewdto);

}
