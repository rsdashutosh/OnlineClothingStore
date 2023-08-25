package com.app.pojos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Review extends BaseEntity {
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * @Column(name="review_id") private Integer reviewId;
	 */
	
	// title of the review 
	private String title;
    
    // Textual review of the associated product
	private String description;
	
	// Rating given to the product by the customer 
	private Integer rating;
	
	// List of images associated with the Review
	@OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
	private List<ReviewImage> reviewImages=new ArrayList<>();
	
	// helper methods to add and remove Review Images from a review
	public void addReviewImage(ReviewImage reviewImage) {
		reviewImages.add(reviewImage);
		reviewImage.setReview(this);
	}
	
	public void removeReviewImage(ReviewImage reviewImage) {
		reviewImages.remove(reviewImage);
		reviewImage.setReview(null);
	}
	
	
	// User who wrote this review
	@ManyToOne
	@JoinColumn(name="user_id")
	//@JsonProperty(access = Access.WRITE_ONLY)
	private User user;
	
	// Product that the review is associated with
	@ManyToOne
	@JoinColumn(name="product_id")
	//@JsonProperty(access = Access.WRITE_ONLY)
	private Product product;

	
	

}
