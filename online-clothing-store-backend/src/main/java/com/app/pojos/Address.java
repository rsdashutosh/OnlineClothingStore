package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.pojos.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Entity
@Table(name="addresses")
public class Address extends BaseEntity {
	
	// Line 1 containing the Flat no, building,
	@Column(length = 100)
	private String line1;
	// Line 2 containing the Society name ,and landmark details
	@Column(length = 100)
	private String line2;
	private String street;
	private String town;
	private String city;
	private String country;
	// 6 digit pincode of the address
	private Integer pinCode;
	
	
	// User who the address is associated with
	//@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id",referencedColumnName = "id")
	private User user;
	
	public void setUser(Integer userId)
	{
		
	}
	
	public User getUser()
	{
		return this.getUser();
	}
	
	// Shipping Info that the given address is associated with
	@OneToOne(mappedBy="shippingAddress")
	private Shipping shipping;
}

