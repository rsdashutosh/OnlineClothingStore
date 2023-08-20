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

import com.app.dtos.ReviewDTO;
import com.app.service.ReviewService;

@RestController
@RequestMapping("/Review")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {

	@Autowired
	ReviewService reviewService;
	@PostMapping("/")
	public ResponseEntity<?> addReview(@Valid @PathVariable ReviewDTO reviewdto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(reviewService.addReview(reviewdto));
	}
	@GetMapping("/{reviewId}")	
	public ResponseEntity<?> getReview(@PathVariable Integer reviewId)
	{
		return new ResponseEntity<ReviewDTO> (reviewService.getReview(reviewId),HttpStatus.FOUND);
		
	}
	@DeleteMapping("/{reviewId}")
	public ResponseEntity<?> deleteReview(@PathVariable Integer reviewId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(reviewService.deleteReview(reviewId));
	}
    @PutMapping("/reviewId")
    public ResponseEntity<?> editReview(@Valid @PathVariable Integer reviewId,@RequestBody ReviewDTO reviewdto)
    {
    	return ResponseEntity.status(HttpStatus.OK).body(reviewService.editReview(reviewId, reviewdto));
    }
	
	
}
