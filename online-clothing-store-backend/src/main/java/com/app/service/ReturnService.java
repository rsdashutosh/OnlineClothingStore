package com.app.service;

import java.util.List;

import com.app.dtos.ReturnAndExchangeDTO;



public interface ReturnService {
	
	public String addReturnAndExchange(ReturnAndExchangeDTO returnAndExchangeDto);
	public ReturnAndExchangeDTO getReturnAndExchange(Integer returnAndExchangeId);
	public List<ReturnAndExchangeDTO> getAllReturnAndExchanges();
	public String updateReturnAndExchangeDetails(Integer returnAndExchangeId, ReturnAndExchangeDTO returnAndExchangeDto);
	public String deleteReturnAndExchange(Integer returnAndExchangeId);
}
