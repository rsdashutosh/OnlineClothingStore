package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Review;

public interface ReviewRepository extends JpaRepository<Review,Integer>
{
	
}
