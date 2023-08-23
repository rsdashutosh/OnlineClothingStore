 package com.app.pojos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.pojos.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "shopping_cart")
public class Cart extends BaseEntity {
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * @Column(name = "cart_id") private Integer CartId;
	 */
	
	// User who owns the cart
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	// List of products that the cart contains
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(joinColumns = {@JoinColumn(name = "cart_id",referencedColumnName ="id")}, 
	inverseJoinColumns = {@JoinColumn(name ="product_id",referencedColumnName = "id")}) 
	private List<Product> products=new ArrayList<>();
	
	// Helper methods to add/remove child i.e. Products
	public void addProduct(Product product) {
		products.add(product);
		product.getCarts().add(this);
	}
	public void removeProduct(Product product) {
		products.remove(product);
		product.getCarts().remove(this);
	}
	 
	
}
