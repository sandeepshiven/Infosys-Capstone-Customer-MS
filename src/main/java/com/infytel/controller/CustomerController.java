package com.infytel.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infytel.dto.CustomerAddressDTO;
import com.infytel.dto.CustomerDTO;
import com.infytel.dto.CustomerDTOForPersonalDetail;
import com.infytel.entity.Customer;
import com.infytel.exceptions.CustomerNotFoundException;
import com.infytel.exceptions.IncorrectEmailException;
import com.infytel.service.CustomerService;

@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/validate-basic")
	public ResponseEntity<String> validateBasicDetails(@Valid @RequestBody CustomerDTO customerDTO) {
		

		return ResponseEntity.status(HttpStatus.OK)
				.body(customerService.validateBasicDetails(customerDTO.getDateOfBirth(), customerDTO.getEmailAddress()));

	}
	
	@PostMapping("/validate-personal")
	public ResponseEntity<String> validatePersonalDetails(@Valid @RequestBody CustomerDTOForPersonalDetail customerDTO) throws IncorrectEmailException, CustomerNotFoundException {
		

		return ResponseEntity.status(HttpStatus.OK)
				.body(customerService.validatePersonalDetails(customerDTO));

	}
	
	@PutMapping("/{custId}/update-address")
	public ResponseEntity<String> updateAddress(@Valid @RequestBody CustomerAddressDTO customerAddressDTO,
												@PathVariable("custId") Long customerId) throws CustomerNotFoundException {
		

		return ResponseEntity.status(HttpStatus.OK)
				.body(customerService.updateAddress(customerAddressDTO, customerId));

	}
	
	

}
