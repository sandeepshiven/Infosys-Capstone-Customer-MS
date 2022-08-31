package com.infytel.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infytel.dto.SimDetailsDTO;
import com.infytel.dto.SimOffersDTO;
import com.infytel.entity.SimDetails;
import com.infytel.entity.SimOffers;
import com.infytel.exceptions.SimActiveException;
import com.infytel.exceptions.SimDetailsWrongException;
import com.infytel.repository.SimDetailsRepository;
import com.infytel.repository.SimOffersRepository;
import com.infytel.util.SimActivationConstants;

@Service
@PropertySource("classpath:ValidationMessages.properties")
public class SimDetailsService {

	
	@Autowired
	SimDetailsRepository simDetailsRepository;
	
	@Autowired
	Environment environment;
	
	@Autowired
	SimOffersService simOffersService;
	
	@Autowired
	ModelMapper modelMapper;
	
	public List<SimOffersDTO> validateDetailsByServiceAndSimNumber(Long serviceNumber, Long simNumber) 
					throws SimDetailsWrongException, SimActiveException{
		
		SimDetails simDetails = simDetailsRepository.findByServiceNumberAndSimNumber(serviceNumber, simNumber);
		
		if(simDetails != null) {
			
			if("active".equals(simDetails.getSimStatus())) {
				
				//System.out.println(environment.getProperty(SimActivationConstants.SIM_ACTIVE.toString()));
				
				throw new SimActiveException(environment.getProperty(SimActivationConstants.SIM_ACTIVE.toString()));
			}
			
			List<SimOffersDTO> simOffersDTOs = simOffersService.getOffersBySimId(simDetails.getSimId());			
			return simOffersDTOs;
		}
		else {
			throw new SimDetailsWrongException(environment.getProperty(SimActivationConstants.SIM_DETAILS_INCORRECT.toString()));
		}
		
		
	}
	
	public SimDetailsDTO getSimByCustomerId(Long customerId) {
		return modelMapper.map(simDetailsRepository.findByCustomerId(customerId), SimDetailsDTO.class);
	}
	
	public void save(SimDetailsDTO simDetailsDTO) {
		simDetailsRepository.saveAndFlush(modelMapper.map(simDetailsDTO, SimDetails.class));
	}
}
