package com.app.pojos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CartItemId;
	// specify mapping to product table
	private Integer productId;
	private Integer Quantity;
	private LocalDate dateAdded;
	// specify mapping to customer table
	private Integer customerId;

	@OneToMany(mappedBy="cartItem")
	private List<Product> productList;
	
	@OneToOne
	@JoinColumn(name="customer_id_whose_cart_this_is")
	private Customer customer;
}
