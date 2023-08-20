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

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer productId;
	private String name;
	private String description;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private int stockQuantity;
	private Float discount;
	
	@Enumerated(EnumType.STRING)
	private ColorOptions color;
	
	@Enumerated(EnumType.STRING)
	private SizeOptions size;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name = "fk_product_id")
	private List<Review> reviews=new ArrayList<>();
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name = "fk_product_id")
	private List<Offer> offers=new ArrayList<>();
	
	
	// Many to many for wish-list, cart ,and orders
	
	@ManyToMany(mappedBy = "products",fetch = FetchType.LAZY) private List<Cart>
	carts=new ArrayList<>();
	  
	@ManyToMany(mappedBy = "products",fetch = FetchType.LAZY) private
	List<Wishlist> wishlists=new ArrayList<>();
	  
	@ManyToMany(mappedBy = "products",fetch = FetchType.LAZY) private List<Order>
	orders=new ArrayList<>();
	
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
	private List<ProductImage> productImages=new ArrayList<ProductImage>();
	
	private Float price;
}
