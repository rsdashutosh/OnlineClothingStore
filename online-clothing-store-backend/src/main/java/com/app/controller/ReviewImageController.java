package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.ReviewImageDTO;
import com.app.service.ReviewImageService;

@RestController
@RequestMapping("/ReviewImages")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewImageController {
	
	@Autowired
	ReviewImageService ReviewImageService;
	
	@PostMapping("/")
	public  ResponseEntity<?> addReviewImages(@Valid @RequestBody ReviewImageDTO ReviewImageDto) {
		return ResponseEntity.status(HttpStatus.OK).body(ReviewImageService.addReviewImage(ReviewImageDto));
	}
	
	@GetMapping("/{ReviewImageId}")
	public ResponseEntity<?> getReviewImageById(@PathVariable Integer ReviewImageId){
		return new ResponseEntity<ReviewImageDTO>(ReviewImageService.getReviewImage(ReviewImageId), HttpStatus.FOUND);
	}
	
	@PutMapping("/{ReviewImageId}")
	public ResponseEntity<?> updateReviewImageDetails(@Valid @PathVariable Integer ReviewImageId, @RequestBody ReviewImageDTO ReviewImageDto){
		return ResponseEntity.status(HttpStatus.OK).body(ReviewImageService.updateReviewImageDetails(ReviewImageId, ReviewImageDto));
	}
	
	@DeleteMapping("/ReviewImageId")
	public ResponseEntity<?> deleteReviewImage(@PathVariable Integer ReviewImageId){
		return ResponseEntity.status(HttpStatus.OK).body(ReviewImageService.deleteReviewImage(ReviewImageId));
	}

}
