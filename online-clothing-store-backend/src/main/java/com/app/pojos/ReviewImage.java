 package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "review_images") 
public class ReviewImage extends BaseEntity {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * @Column(name = "review_image_id") private Integer reviewImageId;
	 */
	
	// Name given to the review image
	private String name;
	
	// Review image stored in Byte array
	@Lob // large object :col : longblob
	private byte[] image;
	
	// Review that the review image is associated with
	@ManyToOne
	@JoinColumn(name = "review_id",referencedColumnName = "id")
	private Review review;
	
	
}
