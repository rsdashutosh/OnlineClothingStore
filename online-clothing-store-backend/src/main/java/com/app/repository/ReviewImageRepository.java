package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Product;
import com.app.pojos.ProductImage;
import com.app.pojos.ReviewImage;
import com.app.pojos.Review;


	public interface ReviewImageRepository extends JpaRepository<ReviewImage, Integer>{
		List<ReviewImage> findByReview(Review review);
	
}
