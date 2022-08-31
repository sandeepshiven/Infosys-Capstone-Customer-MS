package com.infytel.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infytel.dto.CustomerAddressDTO;
import com.infytel.entity.CustomerAddress;
import com.infytel.repository.CustomerAddressRepository;
import com.infytel.repository.CustomerRepository;

@Service
public class CustomerAddressService {
	
	@Autowired
	CustomerAddressRepository customerAddressRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public void update(CustomerAddressDTO customerAddressDTO) {
		customerAddressRepository.saveAndFlush(modelMapper.map(customerAddressDTO, CustomerAddress.class));
	}
	
}
