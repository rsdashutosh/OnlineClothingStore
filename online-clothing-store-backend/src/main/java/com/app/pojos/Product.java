package com.app.pojos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.enums.Gender;
import com.app.enums.ColorOptions;
import com.app.enums.SizeOptions;

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
@Table(name = "products")

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	private String Name;
	private String description;
	private Float price;
	private int stock;
	
	@Enumerated(EnumType.STRING)
	private ColorOptions color;
	
	@Enumerated(EnumType.STRING)
	private SizeOptions size;
	
	@Enumerated(EnumType.STRING)
	private Gender category;
	//private byte[] image;
	private Float discount;
	private Float mrp;
	
	@OneToMany(mappedBy = "product")
	private List<Offer> offerList;
	
	@OneToMany(mappedBy = "product")
	private List<Review> reviewList;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	private CartItem cartItem;
	
	@ManyToOne
	@JoinColumn(name="wishlist_id")
	private WishList wishList;
	
	@ManyToMany(mappedBy="products")
	private List<Category> categories;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;
}
