package com.app.service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dtos.ReviewImageDTO;
import com.app.pojos.ReviewImage;
import com.app.repository.ReviewImageRepository;

@Service
@Transactional
public class ReviewImageServiceImpl implements ReviewImageService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ReviewImageRepository reviewImageRepo;

	// POST
	@Override
	public String addReviewImage(ReviewImageDTO ReviewImageDto) {
		ReviewImage ReviewImage = mapper.map(ReviewImageDto, ReviewImage.class);
		ReviewImage persistantReviewImage = reviewImageRepo.save(ReviewImage);
		return persistantReviewImage.getName();
	}

	// GET ReviewImage by Id
	@Override
	public ReviewImageDTO getReviewImage(Integer ReviewImageId) {
		ReviewImage ReviewImage = reviewImageRepo.findById(ReviewImageId).get();
		ReviewImageDTO ReviewImageDTO = mapper.map(ReviewImage, ReviewImageDTO.class);
		return ReviewImageDTO;
	}

	// Update all ReviewImages
	@Override
	public List<ReviewImageDTO> getAllReviewImages() {
		List<ReviewImage> ReviewImageList = reviewImageRepo.findAll();
		return ReviewImageList.stream().map(ReviewImage -> mapper.map(ReviewImage, ReviewImageDTO.class)).collect(Collectors.toList());
	}

	//PUT
	@Override
	public String updateReviewImageDetails(Integer ReviewImageId, ReviewImageDTO ReviewImageDTO) {
		ReviewImage persistentReviewImage = reviewImageRepo.findById(ReviewImageId).get();
		mapper.map(ReviewImageDTO, persistentReviewImage);
		return persistentReviewImage.getName()+"Updated";
	}
	

	//Delete
	@Override
	public String deleteReviewImage(Integer ReviewImageId) {
		reviewImageRepo.deleteById(ReviewImageId);
		return "ReviewImage deleted Successfully";
	}

}
