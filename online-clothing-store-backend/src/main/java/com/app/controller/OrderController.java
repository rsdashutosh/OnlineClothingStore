package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.OrderDTO;
import com.app.dtos.OrderFromCartDTO;
import com.app.dtos.OrderResponseDTO;
import com.app.service.OrderService;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
	 @Autowired
	    OrderService orderService;

	    @PostMapping("/")
	    public ResponseEntity<?> placeOrder(@Valid @RequestBody OrderDTO orderDto) {
	        return ResponseEntity.status(HttpStatus.OK).body(orderService.placeOrder(orderDto));
	    }
	    
	    // create a new endpoint which accepts user id and products ids of products in the cart and then creates a new order for each product
	    @PostMapping("/cart")
	    public ResponseEntity<?> placeOrdersFromCart(@Valid @RequestBody OrderFromCartDTO orderFromCartDTO) {
	        return ResponseEntity.status(HttpStatus.OK).body(orderService.placeOrderFromCart(orderFromCartDTO));
	    }

	    @GetMapping
	    public ResponseEntity<?> getAllOrders() {
	        return new ResponseEntity<List<OrderResponseDTO>>(orderService.getAllOrders(), HttpStatus.OK);
	    }
	    
	    // get all orders of a user
	    @GetMapping("/user_id/{userId}")
	    public ResponseEntity<?> getAllOrdersOfAUser(@Valid @PathVariable String userId) {
	        return new ResponseEntity<List<?>>(orderService.getAllOrdersOfAUser(Integer.valueOf(userId)), HttpStatus.OK);
	    }
	    
	    @GetMapping("/{orderId}")
	    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Integer orderId) {
	        return new ResponseEntity<OrderDTO>(orderService.getOrder(orderId), HttpStatus.OK);
	    }

	    @PutMapping("/{orderId}")
	    public ResponseEntity<?> updateOrderDetails(@Valid @PathVariable Integer orderId, @RequestBody OrderDTO orderDto) {
	        return ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrderDetails(orderId, orderDto));
	    }

	    @DeleteMapping("/{orderId}")
	    public ResponseEntity<?> cancelOrder(@PathVariable Integer orderId) {
	        return ResponseEntity.status(HttpStatus.OK).body(orderService.cancelOrder(orderId));
	    }
	
	
	
	

}
