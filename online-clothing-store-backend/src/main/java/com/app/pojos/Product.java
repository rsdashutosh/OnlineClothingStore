 package com.app.pojos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.app.enums.Gender;
import com.app.enums.Material;
import com.app.enums.Occasion;
import com.app.enums.CategoryType;
import com.app.enums.ColorOptions;
import com.app.enums.SizeOptions;
import com.app.enums.Style;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString	// (exclude = {"dept","projects"})
@Entity
@Table(name = "products")

public class Product extends BaseEntity {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * @Column(name = "product_id") private Integer productId;
	 */
	private String name;
	private String description;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private Integer stock;
	private Double discount;
	private Double price;
	
	@Enumerated(EnumType.STRING)
	private ColorOptions color;
	
	@Enumerated(EnumType.STRING)
	private SizeOptions size;
	
	@Enumerated(EnumType.STRING)
	private CategoryType category;
	
	@Enumerated(EnumType.STRING)
	private Material material;
	
	@Enumerated(EnumType.STRING)
	private Style style;
	
	@Enumerated(EnumType.STRING)
	private Occasion occasion;
	
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name = "fk_product_id")
	private List<Review> reviews=new ArrayList<>();
	
	// as per Gavin King's IMPORTANT suggestion added helper methods to add/remove child
	public void addReview(Review review) {
		reviews.add(review);
		review.setProduct(this);
	}
	public void removeReview(Review review) {
		reviews.remove(review);
		review.setProduct(null);
	}
	
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="product_offer",
	joinColumns = { @JoinColumn(name="product_id", referencedColumnName = "id")},
	inverseJoinColumns = { @JoinColumn(name="offer_id", referencedColumnName = "id") })
	private List<Offer> offers=new ArrayList<>();
	
	// as per Gavin King's IMPORTANT suggestion added helper methods to add/remove child
	public void addOffer(Offer offer) {
		offers.add(offer);
		offer.getProducts().add(this);
	}
	public void removeOffer(Offer offer) {
		offers.remove(offer);
		offer.getProducts().remove(this);
	}
	
	
	// Many to many for wish-list, cart ,and orders
	@ManyToMany(mappedBy = "products",fetch = FetchType.LAZY) 
	private List<Cart> carts=new ArrayList<>();
	
	// as per Gavin King's IMPORTANT suggestion added helper methods to add/remove child
	public void addCart(Cart cart) {
		carts.add(cart);
		cart.addProduct(this);
	}
	public void removeCart(Cart cart) {
		carts.remove(cart);
		cart.removeProduct(this);
	}
	
	  
	@ManyToMany(mappedBy = "products",fetch = FetchType.LAZY)
	private List<Wishlist> wishlists=new ArrayList<>();
	
	// as per Gavin King's IMPORTANT suggestion added helper methods to add/remove child
	public void addWishlist(Wishlist wishlist) {
		wishlists.add(wishlist);
		wishlist.getProducts().add(this);
	}
	public void removeWishlist(Wishlist wishlist) {
		wishlists.remove(wishlist);
		wishlist.getProducts().remove(this);
	}
	
	  
	@ManyToMany(mappedBy = "products",fetch = FetchType.LAZY) 
	private List<Order>	orders=new ArrayList<>();
	
	// as per Gavin King's IMPORTANT suggestion added helper methods to add/remove child
	public void addOrders(Order order) {
		orders.add(order);
		order.addProduct(this);
	}
	public void removeOrder(Order order) {
		orders.remove(order);
		order.getProducts().remove(this);
	}
	
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name = "fk_product_id")
	private List<ProductImage> productImages=new ArrayList<ProductImage>();
	
	// as per Gavin King's IMPORTANT suggestion added helper methods to add/remove child
	public void addProductImage(ProductImage productImage) {
		productImages.add(productImage);
		productImage.setProduct(this);
	}
	public void removeProductImage(ProductImage productImage) {
		productImages.remove(productImage);
		productImage.setProduct(null);
	}
	
	
}
