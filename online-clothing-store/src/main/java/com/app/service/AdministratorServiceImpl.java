package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.AdministratorDto;
import com.app.pojos.Administrator;
import com.app.repository.AdministratorRepository;

@Service
@Transactional
public class AdministratorServiceImpl implements AdministratorService{
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AdministratorRepository adminRepo;
	
	
	@Override
	public String addAdministrator(AdministratorDto administratorDto) {
		Administrator administrator=mapper.map(administratorDto, Administrator.class);
		Administrator persistantAdministrator=adminRepo.save(administrator);
		return "Administrator : "+persistantAdministrator.getUsername()+" added successfully!";
	}

	@Override
	public AdministratorDto getAdministratorDetails(Integer administratorId) {
		Optional<Administrator> administrator=adminRepo.findById(administratorId);
		AdministratorDto administratorDto=mapper.map(administrator.get(), AdministratorDto.class);
		return administratorDto;
	}

	@Override
	public List<AdministratorDto> getAllAdministrators() {
		List<Administrator> adminList=adminRepo.findAll();
		return adminList.stream().map(admin->mapper.map(admin, AdministratorDto.class)).collect(Collectors.toList());
		
	}

	@Override
	public String updateAdministratorDetails(Integer adminId,AdministratorDto administratorDto) {
		Optional<Administrator> persistantAdministrator=adminRepo.findById(adminId);
		mapper.map(administratorDto, persistantAdministrator.get());
		return persistantAdministrator.get().getUsername()+" updated successfully!";
	}

	@Override
	public String deleteAdministrator(Integer administratorId) {
		adminRepo.deleteById(administratorId);
		return "Admin with id :"+administratorId+" deleted successfully!";
	}

}
