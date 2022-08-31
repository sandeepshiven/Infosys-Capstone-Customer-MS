package com.infytel.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infytel.dto.CustomerIdentityDTO;
import com.infytel.dto.SimDetailsDTO;
import com.infytel.entity.CustomerIdentity;
import com.infytel.entity.SimDetails;
import com.infytel.exceptions.CustomerNotFoundException;
import com.infytel.exceptions.InvalidDetailsException;
import com.infytel.repository.CustomerIdentityRepository;
import com.infytel.util.SimActivationConstants;

@Service
public class CustomerIdentityService {
	
	@Autowired
	CustomerIdentityRepository customerIdentityRepository;
	
	@Autowired
	SimDetailsService simDetailsService;
	
	@Autowired
	Environment environment;
	
	public String validate(CustomerIdentityDTO customerIdentityDTO) throws CustomerNotFoundException, InvalidDetailsException {
		
		Optional<CustomerIdentity> customerIdentityOptional = customerIdentityRepository.findById(customerIdentityDTO.getUniqueIdNumber());
		
		if(customerIdentityOptional.isPresent()) {
			
			CustomerIdentity customerIdentity = customerIdentityOptional.get();
		
			if(customerIdentity.getUniqueIdNumber().equals(customerIdentityDTO.getUniqueIdNumber())
					&& customerIdentity.getFirstName().equals(customerIdentityDTO.getFirstName())
					&& customerIdentity.getLastName().equals(customerIdentityDTO.getLastName())
					&& customerIdentity.getDateOfBirth().equals(customerIdentityDTO.getDateOfBirth())) {
				
				SimDetailsDTO simDetailsDTO = simDetailsService.getSimByCustomerId(customerIdentity.getUniqueIdNumber());
				simDetailsDTO.setSimStatus("active");
				simDetailsService.save(simDetailsDTO);
				
				return "Sim Activated successfully";
			}
			else {
				throw new InvalidDetailsException(environment.getProperty(SimActivationConstants.INVALID_DETAILS.toString()));
			}
		}
		else {
			throw new CustomerNotFoundException(environment.getProperty(SimActivationConstants.CUSTOMER_NOT_FOUND.toString()));
		}
		
	
	}
	
	
}
