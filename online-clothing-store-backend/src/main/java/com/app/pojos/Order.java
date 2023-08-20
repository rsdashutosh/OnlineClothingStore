package com.app.pojos;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.app.enums.OrderStatus;
import com.app.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Long orderId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate orderDate;

    @ManyToOne
    //@JoinColumn(name = "fk_user_id")
    private User user;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name = "fk_order_id")
    private List<Product> products=new ArrayList<>();
    
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
    
	

}
