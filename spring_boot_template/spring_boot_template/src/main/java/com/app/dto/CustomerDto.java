package com.app.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
public class CustomerDto {
	private Integer coins;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String paymentInformation;
	private Long phoneNumber;
	private String shippingAddress;
	
	
	
}
