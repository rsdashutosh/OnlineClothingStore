package com.app.pojos;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="review_id")
	private Integer reviewId;
    
    // Textual review of the associated product
	private String reviewText;
	
	// Rating given to the product by the customer 
	private Integer rating;
	
	// List of images associated with the Review
	@OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
	private List<ReviewImage> reviewImages=new ArrayList<>();
	
	// User who wrote this review
	@ManyToOne
	@JoinColumn(name="fk_user_id")
	//@JsonProperty(access = Access.WRITE_ONLY)
	private User user;
	
	// Product that the review is associated with
	@ManyToOne
	@JoinColumn(name="fk_product_id")
	//@JsonProperty(access = Access.WRITE_ONLY)
	private Product product;
	

}
