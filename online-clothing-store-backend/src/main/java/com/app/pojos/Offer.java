package com.app.pojos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.pojos.BaseEntity;
import com.app.enums.CategoryType;

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
@Table(name = "offers")
public class Offer extends BaseEntity {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * @Column(name="offer_id") private Integer offerId;
	 */
	private String offerName;
	private String offerDescription;
	private Double discountAmount;
	private String promoCode;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	@Enumerated(EnumType.STRING)
	private CategoryType category;
	
	private Double minimumPurchaseAmount;
	
	@ManyToMany(mappedBy = "offers",fetch = FetchType.LAZY)
	private List<Product> products=new ArrayList<>();

	// as per Gavin King's IMPORTANT suggestion added helper methods to add/remove child
	public void addProduct(Product product) {
		products.add(product);
		product.getOffers().add(this);
	}
	public void removeProduct(Product product) {
		products.remove(product);
		product.getOffers().remove(this);
	}
	
}
