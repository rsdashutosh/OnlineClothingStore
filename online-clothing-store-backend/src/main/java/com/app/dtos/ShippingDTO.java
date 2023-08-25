package com.app.dtos;
import java.time.LocalDate;
import com.app.enums.ShippingStatus;
import com.app.enums.ShippingType;
import com.app.pojos.Address;
import com.app.pojos.Order;
import com.app.pojos.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShippingDTO {
	
    private ShippingType shippingMethod;
	private Double shippingCost;
	private String shippingCarrier;
	private Long trackingNumber;
	private LocalDate shippingDate;
	private ShippingStatus shippingStatus;
	
	// Foreign Keys from here
	private Integer addressId;
	
	//@JsonProperty(access = Access.WRITE_ONLY)
	private Integer userId;
	
	private Integer orderId;
	

}
