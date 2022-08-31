package com.infytel.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infytel.dto.CustomerIdentityDTO;
import com.infytel.exceptions.CustomerNotFoundException;
import com.infytel.exceptions.InvalidDetailsException;
import com.infytel.repository.CustomerIdentityRepository;
import com.infytel.service.CustomerIdentityService;

@RestController
@RequestMapping("/customer-identity")
public class CustomerIdentityController {
	
	@Autowired
	CustomerIdentityService customerIdentityService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@PostMapping("/validate")
	public ResponseEntity<String> validate(@Valid @RequestBody CustomerIdentityDTO customerIdentityDTO) throws CustomerNotFoundException, InvalidDetailsException{
		return ResponseEntity.status(HttpStatus.OK).body(customerIdentityService.validate(customerIdentityDTO));
	}
	
	
}
