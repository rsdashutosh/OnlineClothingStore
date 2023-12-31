 package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

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
@Entity
@Table(name = "product_images")
public class ProductImage extends BaseEntity {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) //@Column(name =
	 * "image_id") private Integer imageId;
	 */
	private String name;
	
	private String imagePath;
	
	@Lob // large object :col : longblob - binary large object
	private byte[] image;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	
}
