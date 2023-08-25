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

import com.app.dtos.ProductImageDTO;
import com.app.service.ProductImageService;

import io.swagger.v3.oas.models.responses.ApiResponse;

@RestController
@RequestMapping("/product_images")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductImageController {
	
	@Autowired
	ProductImageService productImageService;
	
	// Adding an image
	@PostMapping(value="/",consumes = "multipart/form-data")
	public  ResponseEntity<?> addProductImage(@ModelAttribute ProductImageDTO productImageDTO) throws IOException {
		return ResponseEntity.status(HttpStatus.OK).body(productImageService.addProductImage(productImageDTO));
	}
	
	// Fetches all the images of a product
	@GetMapping(value = "/product_id/{productId}")
	public ResponseEntity<?> getProductImages(@PathVariable Integer productId){
		return ResponseEntity.status(HttpStatus.OK).body(productImageService.getAllProductImages(productId));
	}
	
	// Fetches one product image by product image id
	@GetMapping(value = "/product_id/{productId}/image_id/{imageId}", produces = { IMAGE_GIF_VALUE, IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE })
	public ResponseEntity<?> getProductImageById(@PathVariable Integer productId,@PathVariable Integer imageId){
		return ResponseEntity.status(HttpStatus.OK).body(productImageService.getProductImage(productId, imageId));
	}
	
	// Updating of image
	@PutMapping(value="/product_image_id/{productImageId}" ,consumes = "multipart/form-data")
	public ResponseEntity<?> updateProductImageDetails(@Valid @PathVariable Integer productImageId, @RequestBody ProductImageDTO productImageDto) throws IOException{
		return ResponseEntity.status(HttpStatus.OK).body(productImageService.updateProductImageDetails(productImageId, productImageDto));
	}   
	
	// Delete 
	@DeleteMapping("/product_image_id/{productImageId}")
	public ResponseEntity<?> deleteProductImage(@PathVariable Integer productImageId){
		return ResponseEntity.status(HttpStatus.OK).body(productImageService.deleteProductImage(productImageId));
	}

}
