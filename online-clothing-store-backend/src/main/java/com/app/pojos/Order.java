package com.app.pojos;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.enums.OrderStatus;

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
@Table(name = "orders")
public class Order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
    private Long orderId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;
    
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_payment_id")
    private Payment payment;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_shipping_id")
    private Shipping shippingDetails;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_return_and_exchange_id")
    private ReturnAndExchange returnAndExchange;
    
    private Double tax;
    private Double orderAmount;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(joinColumns = {@JoinColumn(name = "order_id",referencedColumnName= "order_id")}, 
	inverseJoinColumns = {@JoinColumn(name ="product_id",referencedColumnName = "product_id")}) 
	private List<Product> products=new ArrayList<>();
	
	
	// as per Gavin King's IMPORTANT suggestion added helper methods to add/remove child
	public void addProduct(Product product) {
		products.add(product);
		product.getOrders().add(this);
	}
	public void removeProduct(Product product) {
		products.remove(product);
		product.getOrders().remove(this);
	}
	 
    
	

}
