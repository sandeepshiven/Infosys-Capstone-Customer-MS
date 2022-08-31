package com.infytel.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infytel.dto.SimDetailsDTO;
import com.infytel.dto.SimOffersDTO;
import com.infytel.entity.SimDetails;
import com.infytel.entity.SimOffers;
import com.infytel.exceptions.SimActiveException;
import com.infytel.exceptions.SimDetailsWrongException;
import com.infytel.service.SimDetailsService;

@RestController
@RequestMapping("/sim")
public class SimDetailsController {
	
	@Autowired
	SimDetailsService simDetailsService;
	
	@PostMapping("/validate")
	public ResponseEntity<List<SimOffersDTO>> validateSim(@Valid @RequestBody SimDetailsDTO simDetails)
			throws SimDetailsWrongException, SimActiveException{
			
		
		return ResponseEntity.status(HttpStatus.OK).body(simDetailsService.validateDetailsByServiceAndSimNumber(simDetails.getServiceNumber(), simDetails.getSimNumber()));
	}
	
}
