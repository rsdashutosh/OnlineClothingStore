package com.app.service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dtos.PaymentDTO;
import com.app.pojos.Payment;
import com.app.repository.PaymentRepository;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PaymentRepository paymentRepo;

	// POST
	@Override
	public String addPayment(PaymentDTO paymentDto) {
		Payment payment = mapper.map(paymentDto, Payment.class);
		Payment persistantPayment = paymentRepo.save(payment);
		return "payment with payment id: "+persistantPayment.getPaymentId()+"received";
	}

	// GET payment by Id
	@Override
	public PaymentDTO getPayment(Integer paymentId) {
		Payment payment = paymentRepo.findById(paymentId).get();
		PaymentDTO paymentDto = mapper.map(payment, PaymentDTO.class);
		return paymentDto;
	}

	// Upadte all payments
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
		return "Payment : "+persistentPayment.getPaymentId()+"Updated";
	}
	

	//Delete
	@Override
	public String deletePayment(Integer paymentId) {
		paymentRepo.deleteById(paymentId);
		return "Payment deleted Successfully";
	}

}
