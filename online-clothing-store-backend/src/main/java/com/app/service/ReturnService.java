package com.app.service;

import java.util.List;

import com.app.dtos.ReturnAndExchangeDTO;

public interface ReturnService {

	public String addReturn(ReturnAndExchangeDTO returnAndExchangeDto);
	
	public ReturnAndExchangeDTO getReturn(Integer returnId);
	public List<ReturnAndExchangeDTO> getAllCategories();
	
	public String updateReturnDetails(Integer ReturnId, ReturnAndExchangeDTO returnAndExchangeDto);
	public String deleteReturn(Integer returnId);
}
