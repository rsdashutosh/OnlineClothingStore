package com.app.controller;

import static org.springframework.http.MediaType.IMAGE_GIF_VALUE;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.app.dtos.ProductDTO;
import com.app.dtos.ProductResponseDTO;
import com.app.service.ImageHandlingService;
import com.app.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ImageHandlingService imageHandlingService;
	
	@PostMapping(value="/",consumes = "multipart/form-data")
	public  ResponseEntity<?> addProducts(@Valid @ModelAttribute ProductDTO productDto) throws IOException {
		return ResponseEntity.status(HttpStatus.OK).body(productService.addProduct(productDto));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllProducts(){
		return new ResponseEntity<List<ProductResponseDTO>>(productService.getAllProducts(), HttpStatus.OK);
	}
	
	@GetMapping(value="/category")
	public ResponseEntity<?> getProductsByCategory(@RequestParam String category){
		return new ResponseEntity<List<ProductResponseDTO>>(productService.getProductsByCategory(category), HttpStatus.OK);
	}
	
	@GetMapping(value="/{productId}")
	public ResponseEntity<?> getProductById(@PathVariable Integer productId){
		return new ResponseEntity<ProductResponseDTO>(productService.getProduct(productId), HttpStatus.OK);
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<?> updateProductDetails(@Valid @PathVariable Integer productId, @RequestBody ProductDTO productDto){
		return ResponseEntity.status(HttpStatus.OK).body(productService.updateProductDetails(productId, productDto));
	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
		return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(productId));
	}
	
	
	// get image by product id
	@GetMapping(value="/images/{productId}",
			produces = { IMAGE_GIF_VALUE, IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE })
	public ResponseEntity<?> getImageByProductId(@PathVariable Integer productId) throws IOException{
		return new ResponseEntity<byte[]>(imageHandlingService.serveImage(productId), HttpStatus.OK);
	}
	
	// upload image by product id
	@PostMapping(value = "/images", consumes = "multipart/form-data")
	public ResponseEntity<?> uploadImage(@RequestParam Integer productId, @RequestParam MultipartFile image) throws IOException {
		return new ResponseEntity<String>(imageHandlingService.uploadImage(productId, image), HttpStatus.OK);
	}

}
