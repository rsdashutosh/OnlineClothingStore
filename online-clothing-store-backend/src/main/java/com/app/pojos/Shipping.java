package com.app.pojos;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.enums.ShippingStatus;
import com.app.enums.ShippingType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Shipping_info")
public class Shipping extends BaseEntity {
	/*
	 * @Id
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) 
	 * private Integer shippingId;
	 */
    @Enumerated(EnumType.STRING)
    private ShippingType shippingMethod;
	private Double shippingCost;
	private String shippingCarrier;
	@Column(length = 8)
	private Long trackingNumber;
	private LocalDate shippingDate;
	@Enumerated(EnumType.STRING)
	private ShippingStatus shippingStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "add_id")
	private Address shippingAddress;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	//@JsonProperty(access = Access.WRITE_ONLY)
	private User shippingRecipient;
	
	public void addUser(User user) {
		this.shippingRecipient=user;
		user.getShippings().add(this);
	}
	
	public void removeUser(User user) {
		this.shippingRecipient=null;
		user.getShippings().remove(this);
	}
	
	
	@OneToOne
	//@JoinColumn(name="order_id")
	private Order order;
	

}
