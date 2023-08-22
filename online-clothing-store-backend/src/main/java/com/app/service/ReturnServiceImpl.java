package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.ReturnAndExchangeDTO;
import com.app.pojos.ReturnAndExchange;
import com.app.repository.ReturnRepository;

@Service
@Transactional
public class ReturnServiceImpl implements ReturnService {


	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ReturnRepository returnRepo;

	// POST EndPoint to Add a Return
	@Override
	public String addReturn(ReturnAndExchangeDTO returnAndExchangeDto) {
		ReturnAndExchange returnObject = mapper.map(returnAndExchangeDto, ReturnAndExchange.class);
		ReturnAndExchange persistantReturn = returnRepo.save(returnObject);
		return persistantReturn.getOrderId()+" return added";
	}

	// GET return by ID
	@Override
	public ReturnAndExchangeDTO getReturn(Integer returnId) {
		ReturnAndExchange returnObject = returnRepo.findById(returnId).get();
		ReturnAndExchangeDTO returnAndExchangeDto = mapper.map(returnObject, ReturnAndExchangeDTO.class);
		return returnAndExchangeDto;
	}
	
	// GET End-point to fetch all categories 
	@Override
	public List<ReturnAndExchangeDTO> getAllCategories() {
		List<ReturnAndExchange> returnAndExchanges = returnRepo.findAll();
		return returnAndExchanges.stream().map(returnObj->mapper.map(returnObj, ReturnAndExchangeDTO.class)).collect(Collectors.toList());
	}

	// PUT End-point to update a Return
	@Override
	public String updateReturnDetails(Integer returnId,ReturnAndExchangeDTO returnAndExchangeDto) {
		ReturnAndExchange persistantReturn=returnRepo.findById(returnId).get();
		mapper.map(returnAndExchangeDto, persistantReturn);
		return persistantReturn.getOrderId()+" updated!";
	}

	// DELETE End-point to delete a Return
	@Override
	public String deleteReturn(Integer returnId) {
		returnRepo.deleteById(returnId);
		return "return with id:"+returnId+"Deleted successfully";
	}

}
