package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.OrderDto;
import com.app.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	 @Autowired
	    OrderService orderService;

	    @PostMapping("/")
	    public ResponseEntity<?> placeOrder(@RequestBody OrderDto orderDto) {
	        return ResponseEntity.status(HttpStatus.OK).body(orderService.placeOrder(orderDto));
	    }

	    @GetMapping("/{orderId}")
	    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId) {
	        return new ResponseEntity<OrderDto>(orderService.getOrder(orderId), HttpStatus.OK);
	    }

	    @PutMapping("/{orderId}")
	    public ResponseEntity<?> updateOrderDetails(@PathVariable Long orderId, @RequestBody OrderDto orderDto) {
	        return ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrderDetails(orderId, orderDto));
	    }

	    @DeleteMapping("/{orderId}")
	    public ResponseEntity<?> cancelOrder(@PathVariable Long orderId) {
	        return ResponseEntity.status(HttpStatus.OK).body(orderService.cancelOrder(orderId));
	    }
	
	
	
	

}
