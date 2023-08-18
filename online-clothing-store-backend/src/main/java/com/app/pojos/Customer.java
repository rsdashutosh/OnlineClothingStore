package com.app.pojos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Long phoneNumber;
	private String shippingAddress;
	private String paymentInformation;
	private Integer coins;
	
	@OneToMany(mappedBy = "customer")
	private List<Order> orderList;
	
	@OneToMany(mappedBy = "customer")
	private List<WishList> wishlist;
	
	@OneToMany(mappedBy = "customer")
	private List<Review> reviewList;
	
	@OneToMany(mappedBy = "customer")
	private List<Address> addressList;
	
	@OneToOne(mappedBy="customer")
	private CartItem cartItem;
	
	
}
