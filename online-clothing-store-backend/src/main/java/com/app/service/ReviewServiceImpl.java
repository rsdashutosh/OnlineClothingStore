package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.ReviewDTO;
import com.app.pojos.Product;
import com.app.pojos.Review;
import com.app.pojos.User;
import com.app.repository.ProductRepository;
import com.app.repository.ReviewRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService
{

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ReviewRepository reviewRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	//Post
	@Override
	public String addReview(ReviewDTO reviewDTO)
	{		
		Review review=mapper.map(reviewDTO, Review.class);
		Review persistentReview=reviewRepo.save(review);
		
		// associating the review with the user
		User user=userRepo.findById(reviewDTO.getUserId()).get();
		user.addReviews(persistentReview);
		
		// adding the review in the product
		Product product=productRepo.findById(reviewDTO.getProductId()).get();
		product.addReview(persistentReview);
		
		return persistentReview.getId()+" "+persistentReview.getDescription();
	}
	
	@Override
	public ReviewDTO getReview(Integer reviewId)
	{
		Review review=reviewRepo.findById(reviewId).get();
		ReviewDTO reviewDto=mapper.map(review, ReviewDTO.class);
		return reviewDto;
		
	}
	public List<ReviewDTO> getAllReviews()
	{
		List<Review> review=reviewRepo.findAll();
		return review.stream().map(Review->mapper.map(Review, ReviewDTO.class)).collect(Collectors.toList());
		
	}

	public String deleteReview(Integer reviewId)
	{
		reviewRepo.deleteById(reviewId);
		return "Review deleted Successfully";
	}
	
	public String editReview(Integer reviewId,ReviewDTO reviewdto) 
	{
		Review persistentReview=reviewRepo.findById(reviewId).get();
		mapper.map(reviewdto,persistentReview);
		return "review with id : "+persistentReview.getId()+"updated";
	}
	
	public ReviewServiceImpl() {
		// TODO Auto-generated constructor stub
	}

}
