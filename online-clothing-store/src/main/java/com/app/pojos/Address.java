package com.app.pojos;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


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
@Table(name="addresses")

public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer customerId;
	private String line1;
	private String street;
	private String town;
	private String city;
	private String country;
	private int pinCode;
}

