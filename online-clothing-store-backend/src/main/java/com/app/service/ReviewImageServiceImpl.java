package com.app.service;

import javax.transaction.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.ReviewImageDTO;
import com.app.pojos.Review;
import com.app.pojos.ReviewImage;
import com.app.repository.ReviewImageRepository;
import com.app.repository.ReviewRepository;

@Service
@Transactional
public class ReviewImageServiceImpl implements ReviewImageService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ReviewImageRepository reviewImageRepo;
	
	@Autowired
	private ReviewRepository reviewRepo;

	// POST
	@Override
	public String addReviewImage(ReviewImageDTO reviewImageDTO) throws IOException {
		// fetching the review
		Review review=reviewRepo.findById(reviewImageDTO.getReviewId()).get();
		
		// Mapping the DTO to object of ReviewImage class 
		ReviewImage reviewImage=mapper.map(reviewImageDTO, ReviewImage.class);	
		ReviewImage persistentReviewImage=reviewImageRepo.save(reviewImage);
		
		// linking 
		persistentReviewImage.setImage(reviewImageDTO.getImage().getBytes());
		persistentReviewImage.setReview(review);
		review.addReviewImage(persistentReviewImage);
		
		return persistentReviewImage.getName()+" image added!";
	}

	// Get reviewImage by Id
	@Override
	public byte[] getReviewImage(Integer reviewId,Integer ImageId) {
		ReviewImage reviewImage = reviewImageRepo.findById(ImageId).get();
		//ReviewImageDTO reviewImageDto = mapper.map(reviewImage, ReviewImageDTO.class);
		return reviewImage.getImage();
	}

	// Get all reviewImages
	@Override
	public List<byte[]> getAllReviewImages(Integer reviewId) {
		//finding the review by review id
		Review review=reviewRepo.findById(reviewId).get();
		// fetching all the images of a review
		List<ReviewImage> reviewImages=reviewImageRepo.findByReview(review);
		//returning all the images of a review in a List<byte[]>
		return reviewImages.stream().map(reviewImage->reviewImage.getImage()).collect(Collectors.toList());
	}

	// Update review image
	@Override
	public String updateReviewImageDetails(Integer reviewImageId, ReviewImageDTO reviewImageDTO) throws IOException {
		ReviewImage persistentReviewImage = reviewImageRepo.findById(reviewImageId).get();
		mapper.map(reviewImageDTO, persistentReviewImage);
		
		persistentReviewImage.setImage(reviewImageDTO.getImage().getBytes());
		return persistentReviewImage.getName()+" Updated!";
	}
	

	//Delete a review image
	@Override
	public String deleteReviewImage(Integer reviewImageId) {
		// fetching the image
		ReviewImage reviewImage=reviewImageRepo.findById(reviewImageId).get();
		// fetching the review
		Review review=reviewRepo.findById(reviewImage.getReview().getId()).get();
		review.getReviewImages().remove(reviewImage);
		reviewImage.setReview(null);
		
		reviewImageRepo.deleteById(reviewImageId);
		return "ReviewImage : "+reviewImageId+" deleted Successfully!";
	}

}
