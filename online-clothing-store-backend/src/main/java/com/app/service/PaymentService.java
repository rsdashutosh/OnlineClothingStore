package com.app.service;

import java.util.List;

import com.app.dtos.PaymentDTO;



public interface PaymentService {
	
	public String addPayment(PaymentDTO paymentDto);
	public PaymentDTO getPayment(Integer paymentId);
	public List<PaymentDTO> getAllPayments();
	public String updatePaymentDetails(Integer paymentId, PaymentDTO paymentDto);
	public String deletePayment(Integer paymentId);
}
