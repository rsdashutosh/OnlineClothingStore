package com.app.service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dtos.PaymentDTO;
import com.app.pojos.Order;
import com.app.pojos.Payment;
import com.app.pojos.User;
import com.app.repository.OrderRepository;
import com.app.repository.PaymentRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PaymentRepository paymentRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private OrderRepository orderRepo;

	// Method to store the payment details in the DB and link it to a order and a user
	@Override
	public String addPayment(PaymentDTO paymentDTO) {
		// mapping the payment dto to object to payment entity
		Payment payment = mapper.map(paymentDTO, Payment.class);
		
		// persisting the received data in the DB
		Payment persistantPayment = paymentRepo.save(payment);
		
		// fetching the user by user id
		User user=userRepo.findById(paymentDTO.getUserId()).get();
		// fetching the order by order id
		Order order=orderRepo.findById(paymentDTO.getOrderId()).get();
		
		// associate the payment with a user
		persistantPayment.setUser(user);
		user.addPayment(persistantPayment);
		
		// associate the payment with an order
		persistantPayment.setOrder(order);
		order.setPayment(persistantPayment);

		return "payment with payment id: "+persistantPayment.getId()+"received!";
	}

	// Fetching the details of a payment by payment id
	@Override
	public PaymentDTO getPayment(Integer paymentId) {
		Payment payment = paymentRepo.findById(paymentId).get();
		PaymentDTO paymentDTO = mapper.map(payment, PaymentDTO.class);
		return paymentDTO;
	}

	// Get all payments 
	@Override
	public List<PaymentDTO> getAllPayments() {
		List<Payment> paymentList = paymentRepo.findAll();
		return paymentList.stream().map(payment -> mapper.map(payment, PaymentDTO.class)).collect(Collectors.toList());
	}

	//PUT
	@Override
	public String updatePaymentDetails(Integer paymentId, PaymentDTO paymentDto) {
		Payment persistentPayment = paymentRepo.findById(paymentId).get();
		mapper.map(paymentDto, persistentPayment);
		return "Payment : "+persistentPayment.getId()+"Updated";
	}
	

	//Delete
	@Override
	public String deletePayment(Integer paymentId) {
		Payment payment=paymentRepo.findById(paymentId).get();
		
		// fetching the user by user id
		User user=userRepo.findById(payment.getUser().getId()).get();
		// fetching the order by order id
		Order order=orderRepo.findById(payment.getOrder().getId()).get();
		
		// removing all links of payment with user and order
		user.removePayment(payment);
		order.setPayment(null);
		payment.setUser(null);
		payment.setOrder(null);
		
		paymentRepo.deleteById(paymentId);
		return "Payment deleted Successfully";
	}

}
