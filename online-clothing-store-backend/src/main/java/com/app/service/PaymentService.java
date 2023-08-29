package com.app.service;

import java.util.List;

import com.app.dtos.PaymentDTO;
import com.app.dtos.PaymentResponseDTO;



public interface PaymentService {
	
	public String addPayment(PaymentDTO paymentDto);
	public PaymentDTO getPayment(Integer paymentId);
	public List<PaymentResponseDTO> getAllPayments();
	public String updatePaymentDetails(Integer paymentId, PaymentDTO paymentDto);
	public String deletePayment(Integer paymentId);
}
