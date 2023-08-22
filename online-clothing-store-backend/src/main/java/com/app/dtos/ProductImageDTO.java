 package com.app.dtos;

import javax.persistence.Lob;

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
	
	// product id?
	private Product product;
	
	@Lob // large object :col : longblob
	private byte[] image;
}
