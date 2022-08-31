package com.infytel.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infytel.dto.CustomerAddressDTO;
import com.infytel.dto.CustomerDTO;
import com.infytel.dto.CustomerDTOForPersonalDetail;
import com.infytel.entity.Customer;
import com.infytel.exceptions.CustomerNotFoundException;
import com.infytel.exceptions.IncorrectEmailException;
import com.infytel.repository.CustomerRepository;
import com.infytel.util.SimActivationConstants;

@Service
@PropertySource("classpath:ValidationMessages.properties")
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerAddressService customerAddressService;

	@Autowired
	Environment environment;

	public String validateBasicDetails(LocalDate dob, String email) {

		Customer customer = customerRepository.findByDobAndEmail(dob, email);
		// System.out.println(customer);
		if (customer != null) {
			// System.out.println("sucsess");
			return "Success! Found request for sim in database";
		} else {
			return "No request placed for you";
		}

	}

	public String validatePersonalDetails(CustomerDTOForPersonalDetail customerDTO)
			throws IncorrectEmailException, CustomerNotFoundException {

		Customer customer = customerRepository.findByFirstAndLastName(customerDTO.getFirstName(),
				customerDTO.getLastName());

		if (customer != null) {
			if (!customer.getEmailAddress().equals(customerDTO.getEmailAddress())) {
				throw new IncorrectEmailException(
						environment.getProperty(SimActivationConstants.INCORRECT_EMAIL.toString()));
			} else {
				return "Success!! Customer Personal Details are validated";
			}
		} else {
			throw new CustomerNotFoundException(
					environment.getProperty(SimActivationConstants.CUSTOMER_NOT_FOUND.toString()));
		}

	}

	public String updateAddress(CustomerAddressDTO customerAddressDTO, Long customerId) throws CustomerNotFoundException {
		
		Optional<Customer> cust = customerRepository.findById(customerId);
		
		if(cust.isEmpty()) {
			throw new CustomerNotFoundException(environment.getProperty(SimActivationConstants.CUSTOMER_NOT_FOUND.toString()));
		}
		
		Customer customer = cust.get();
		customerAddressDTO.setAddressId(customer.getCustomerAddress().getAddressId());
		
		customerAddressService.update(customerAddressDTO);
		
		return "Update Successful";
	}

}
