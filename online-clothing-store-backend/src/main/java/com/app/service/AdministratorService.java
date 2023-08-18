package com.app.service;

import java.util.List;

import com.app.dtos.AdministratorDto;

public interface AdministratorService {
	
	public String addAdministrator(AdministratorDto administratorDto);
	public AdministratorDto getAdministratorDetails(Integer administratorId);
	public List<AdministratorDto> getAllAdministrators();
	public String updateAdministratorDetails(Integer adminId,AdministratorDto administratorDto);
	public String deleteAdministrator(Integer administratorId);
	
}
