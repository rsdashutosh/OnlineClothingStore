package com.app.controller;

import static org.springframework.http.MediaType.IMAGE_GIF_VALUE;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dtos.ReviewImageDTO;
import com.app.service.ReviewImageService;

import io.swagger.v3.oas.models.responses.ApiResponse;

@RestController
@RequestMapping("/review_images")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewImageController {
	
	@Autowired
	ReviewImageService reviewImageService;
	
	// Adding an image
	@PostMapping(value="/",consumes = "multipart/form-data")
	public  ResponseEntity<?> addReviewImage(@ModelAttribute ReviewImageDTO reviewImageDTO) throws IOException {
		return ResponseEntity.status(HttpStatus.OK).body(reviewImageService.addReviewImage(reviewImageDTO));
	}
	
	// Fetches all the images of a review
	@GetMapping(value = "/review_id/{reviewId}")
	public ResponseEntity<?> getReviewImages(@PathVariable Integer reviewId){
		return ResponseEntity.status(HttpStatus.OK).body(reviewImageService.getAllReviewImages(reviewId));
	}
	
	// Fetches one review image by review image id
	@GetMapping(value = "/review_id/{reviewId}/image_id/{imageId}", produces = { IMAGE_GIF_VALUE, IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE })
	public ResponseEntity<?> getReviewImageById(@PathVariable Integer reviewId,@PathVariable Integer imageId){
		return ResponseEntity.status(HttpStatus.OK).body(reviewImageService.getReviewImage(reviewId, imageId));
	}
	
	// Updating of image
	@PutMapping(value="/review_image_id/{reviewImageId}" ,consumes = "multipart/form-data")
	public ResponseEntity<?> updateReviewImageDetails(@Valid @PathVariable Integer reviewImageId, @ModelAttribute ReviewImageDTO reviewImageDto) throws IOException{
		return ResponseEntity.status(HttpStatus.OK).body(reviewImageService.updateReviewImageDetails(reviewImageId, reviewImageDto));
	}   
	
	// Delete 
	@DeleteMapping("/review_image_id/{reviewImageId}")
	public ResponseEntity<?> deleteReviewImage(@PathVariable Integer reviewImageId){
		return ResponseEntity.status(HttpStatus.OK).body(reviewImageService.deleteReviewImage(reviewImageId));
	}

}
