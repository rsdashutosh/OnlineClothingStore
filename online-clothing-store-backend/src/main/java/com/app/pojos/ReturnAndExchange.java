package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.app.enums.ReturnStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class ReturnAndExchange {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer orderId;
	private Integer productId;
	private String reasonForReturn;
	@Enumerated(EnumType.STRING)
	private ReturnStatus returnStatus;
	
	@ManyToOne
	//@JoinColumn(name = "fk_customer_id")
	private User user;
	
	@OneToOne(mappedBy = "returnAndExchange")
	private Order order;

}
