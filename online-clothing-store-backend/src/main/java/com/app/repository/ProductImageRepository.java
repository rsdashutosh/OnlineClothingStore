package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.ProductImage;


	public interface ProductImageRepository extends JpaRepository<ProductImage, Integer>{
		
	
}
