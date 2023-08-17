package com.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="customers")
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@Column(name = "first_name",nullable = false)
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Long phoneNumber;
	private String shippingAddress;
	private String paymentInformation;
	private Integer coins;
	
	
	public Customer(String firstName, String lastName, String email, String password, Long phoneNumber,
			String shippingAddress, String paymentInformation, Integer coins) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.shippingAddress = shippingAddress;
		this.paymentInformation = paymentInformation;
		this.coins = coins;
	}
}
