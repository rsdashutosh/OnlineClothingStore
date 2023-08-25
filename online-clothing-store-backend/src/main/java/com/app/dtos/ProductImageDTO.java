 package com.app.dtos;

import java.util.Set;

import javax.persistence.Lob;

import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductImageDTO {

	private String name;
	
	private String imagePath;
	
	private MultipartFile image;
	
	// product id
	private Integer productId;
}
