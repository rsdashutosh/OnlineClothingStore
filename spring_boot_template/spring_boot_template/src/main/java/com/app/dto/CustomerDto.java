package com.app.dto;

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
public class CustomerDto {
	private Long customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Long phoneNumber;
	private String shippingAddress;
	private String paymentInformation;
	private Integer coins;
	
}
