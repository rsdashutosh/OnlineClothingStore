package com.app.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
public class CustomerDto {

	private String firstName;
	private String lastName;
	private String email;
	private Long phoneNumber;
	private String shippingAddress;
	private String paymentInformation;
	private Integer coins;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
}
