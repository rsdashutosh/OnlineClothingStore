package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.ReviewDto;
import com.app.pojos.Review;
import com.app.repository.ReviewRepository;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService
{

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ReviewRepository reviewrepo;
	
	//Post
	@Override
	public String addReview(ReviewDto reviewdto)
	{
		Review review=mapper.map(reviewdto, Review.class);
		Review persistentReview=reviewrepo.save(review);
		return persistentReview.getReviewId()+" "+persistentReview.getText();
	}
	
	@Override
	public ReviewDto getReview(Integer reviewId)
	{
		Optional<Review> review=reviewrepo.findById(reviewId);
		ReviewDto reviewDto=mapper.map(review.get(), ReviewDto.class);
		return reviewDto;
		
	}
	public List<ReviewDto> getAllReviews()
	{
		List<Review> review=reviewrepo.findAll();
		return review.stream().map(Review->mapper.map(Review, ReviewDto.class)).collect(Collectors.toList());
		
	}

	public String deleteReview(Integer reviewId)
	{
		reviewrepo.deleteById(reviewId);
		return "Review deleted Successfully";
	}
	
	public String editReview(Integer reviewId,ReviewDto reviewdto) 
	{
		Optional<Review> review=reviewrepo.findById(reviewId);
		Review persistentReview=review.get();
		mapper.map(reviewdto,persistentReview);
		return "review with id : "+persistentReview.getReviewId()+"updated";
	}
	
	public ReviewServiceImpl() {
		// TODO Auto-generated constructor stub
	}

}
