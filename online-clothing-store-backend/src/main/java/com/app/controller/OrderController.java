package com.app.controller;

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
