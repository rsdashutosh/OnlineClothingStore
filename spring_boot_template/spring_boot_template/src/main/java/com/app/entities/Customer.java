package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;
	//@Column(name = "first_name",nullable = false)
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Long phoneNumber;
	private String shippingAddress;
	private String paymentInformation;
	private Integer coins;
	
}
