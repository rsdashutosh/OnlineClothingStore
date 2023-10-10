package com.app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.OrderDTO;
import com.app.dtos.OrderFromCartDTO;
import com.app.dtos.OrderResponseDTO;
import com.app.dtos.PaymentResponseDTO;
import com.app.enums.OrderStatus;
import com.app.pojos.Order;
import com.app.pojos.Payment;
import com.app.pojos.Product;
import com.app.pojos.User;
import com.app.repository.OrderRepository;
import com.app.repository.ProductRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	 @Autowired
	    private ModelMapper mapper;

	    @Autowired
	    private OrderRepository orderRepo;

	    @Autowired
	    private UserRepository userRepo;
	    
	    @Autowired
	    private ProductRepository productRepo;
	    
	    // POST
	    @Override
	    public String placeOrder(OrderDTO orderDTO) {
	    	// fetching the user details using user's id
	    	User user=userRepo.findById(orderDTO.getUserId()).get();
	    	
	    	// mapping the order DTO into object of order entity class
	        Order order = mapper.map(orderDTO, Order.class);
	     // persisting the received data into the database
	        Order persistedOrder = orderRepo.save(order);
	        
	        // adding the links to both the sides 
	        user.addOrder(persistedOrder);
	        
	        // link product with order
	        Product product=productRepo.findById(orderDTO.getProductId()).get();
	        product.addOrders(persistedOrder);
	        
	        // decrementing the stock of a product
	        product.setStock(product.getStock()-1);
	        
	        // persisting the received data into the database
	        return "Order placed with ID: " + persistedOrder.getId();
	    }
	    
	    
	    // to create orders for each item in the cart 
		@Override
		public String placeOrderFromCart(@Valid OrderFromCartDTO orderFromCartDTO) {
			// extract the user id from the DTO and find the user from repo
			User user=userRepo.findById(orderFromCartDTO.getUserId()).get();
			
			// now create a new order for each product from the array of product ids received inside the DTO
			Integer[] products=orderFromCartDTO.getProductIds();
			
			for (Integer productId : products) {
				// fetch the product details 
				Product product=productRepo.findById(productId).get();
				
				// find the values for all the remaining fields of order entity
			    LocalDate orderDate=LocalDate.now();
			    OrderStatus orderStatus=OrderStatus.PLACED;
			    Double tax=product.getPrice()*0.18;
			    Double orderAmount=(product.getPrice()+tax)-(product.getPrice()*(product.getDiscount()/100));
			    
			    Order order=new Order();
			    order.setOrderDate(orderDate);
			    order.setOrderStatus(orderStatus);
			    order.setTax(tax);
			    order.setOrderAmount(orderAmount);
			    order.addProduct(product);
			    order.setUser(user);
			    
			    orderRepo.save(order);
			}
			
			return "Order placed successfully!";
		}
	    

	    // GET order by ID
	    @Override
	    public OrderDTO getOrder(Integer orderId) {
	        Order order = orderRepo.findById(orderId).get();
	        OrderDTO orderDto=mapper.map(order, OrderDTO.class);
	        return orderDto;
	       
	    }

	    // PUT
	    @Override
	    public String updateOrderDetails(Integer orderId, OrderDTO orderDto) {
	        Order persistentOrder = orderRepo.findById(orderId).get();
	        mapper.map(orderDto, persistentOrder);
	        return "Order updated with ID: \" + orderId";
	        		      
	    }

	    // DELETE
	    @Override
	    public String cancelOrder(Integer orderId) {
	    	Order order=orderRepo.findById(orderId).get();
	    	// fetching the user details using user's id
	    	User user=userRepo.findById(order.getUser().getId()).get();
	   	
	    	// for user
	    	// remove associated user from order
	    	order.setUser(null);
	    	// remove link from user to this order
	    	user.getOrders().remove(order);
	    	
	    	/// for products
	    	// remove link from products to this order
	    	order.getProducts().stream().map(product->product.getOrders().remove(order));
	    	// remove all products from order
	    	order.setProducts(null);
	   
	        orderRepo.deleteById(orderId);
	        return "Order cancelled with ID: " + orderId;
	    }

		@Override
		public List<OrderResponseDTO> getAllOrders() {
			List<Order> orders = orderRepo.findAll();
			
			List<OrderResponseDTO> orderResponseDTOs=new ArrayList<OrderResponseDTO>();
			for (Order order : orders) {
				OrderResponseDTO orderResponseDTO=mapper.map(order, OrderResponseDTO.class);
				orderResponseDTO.setUserId(order.getUser().getId());
				orderResponseDTOs.add(orderResponseDTO);
			}
			return orderResponseDTOs;
			
		
		}
	
	

}
