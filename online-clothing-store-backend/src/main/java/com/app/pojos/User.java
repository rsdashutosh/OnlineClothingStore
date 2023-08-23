 package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.app.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.app.enums.Gender;

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
@Table(name = "users")
public class User extends BaseEntity {
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * @Column(name = "user_id")
	 */
	//private Integer userId;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private Long phoneNumber;
	private Integer coins;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Address> addresses=new ArrayList<>();
	
    // as per Gavin King's IMPORTANT suggestion added helper methods to add/remove child
 	public void addAddress(Address address) {
 		addresses.add(address);
 		//address.setUser(this);
 	}
 	public void removeAddress(Address address) {
 		addresses.remove(address);
 		address.setUser(null);
 	}
 	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name = "fk_user_id")
	private List<Order> orders=new ArrayList<>();
	
    // as per Gavin King's IMPORTANT suggestion added helper methods to add/remove child
 	public void addOrder(Order order) {
 		orders.add(order);
 		order.setUser(this);
 	}
 	public void removeOrder(Order order) {
 		orders.remove(order);
 		order.setUser(null);
 	}
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name = "fk_user_id")
	private List<Review> reviews=new ArrayList<>();
	
    // as per Gavin King's IMPORTANT suggestion added helper methods to add/remove child
 	public void addReviews(Review review) {
 		reviews.add(review);
 		review.setUser(this);
 	}
 	public void removeReview(Review review) {
 		reviews.remove(review);
 		review.setUser(null);
 	}
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	//@JoinColumn(name="fk_cart_id")
	private Cart cart;
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	//@JoinColumn(name="fk_wishlist_id")
	private Wishlist wishlist;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private LocalDate dateOfBirth;
    
    private LocalDate dateOfJoining;
    
    // payment mapping 
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name="fk_user_id")
	private List<Payment> payments=new ArrayList<>();
    
    // as per Gavin King's IMPORTANT suggestion added helper methods to add/remove child
 	public void addPayment(Payment payment) {
 		payments.add(payment);
 		payment.setUser(this);;
 	}
 	public void removePayment(Payment payment) {
 		payments.remove(payment);
 		payment.setUser(null);
 	}
    
    // returns mapping
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ReturnAndExchange> returnAndExchanges=new ArrayList<>();
    
    // as per Gavin King's IMPORTANT suggestion added helper methods to add/remove child
 	public void addReturnAndExchange(ReturnAndExchange returnAndExchange) {
 		returnAndExchanges.add(returnAndExchange);
 		returnAndExchange.setUser(this);
 	}
 	public void removeReturnAndExchange(ReturnAndExchange returnAndExchange) {
 		returnAndExchanges.remove(returnAndExchange);
 		returnAndExchange.setUser(null);;
 	}
	
	//@Column(length = 20)
	//@Enumerated(EnumType.STRING)
	private Role role;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
}
