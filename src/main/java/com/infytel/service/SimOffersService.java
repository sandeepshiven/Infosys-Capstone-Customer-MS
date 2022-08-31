package com.infytel.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infytel.dto.SimOffersDTO;
import com.infytel.repository.SimOffersRepository;

@Service
public class SimOffersService {

	@Autowired
	private SimOffersRepository simOffersRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public List<SimOffersDTO> getOffersBySimId(Long simId){
		
		List<SimOffersDTO> simOffersDTOs = simOffersRepository.findBySimDetails_SimId(simId)
											.stream()
											.map(simOffer -> modelMapper.map(simOffer, SimOffersDTO.class)).toList();
		
		return simOffersDTOs;
	}
	
	
}
