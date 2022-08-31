package com.infytel;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.infytel.entity.Customer;
import com.infytel.entity.CustomerAddress;
import com.infytel.entity.CustomerIdentity;
import com.infytel.entity.SimDetails;
import com.infytel.entity.SimOffers;
import com.infytel.repository.CustomerAddressRepository;
import com.infytel.repository.CustomerIdentityRepository;
import com.infytel.repository.CustomerRepository;
import com.infytel.repository.SimDetailsRepository;
import com.infytel.repository.SimOffersRepository;

@SpringBootApplication
public class SimActivationPortalApplication implements CommandLineRunner{
	
	@Autowired
	ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(SimActivationPortalApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		
		CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
		CustomerAddressRepository customerAddressRepository = context.getBean(CustomerAddressRepository.class);
		CustomerIdentityRepository customerIdentityRepository = context.getBean(CustomerIdentityRepository.class);
		
		SimDetailsRepository simDetailsRepository = context.getBean(SimDetailsRepository.class);
		SimOffersRepository simOffersRepository = context.getBean(SimOffersRepository.class);
		
		SimDetails simDetails1 = new SimDetails(1l, 1234567891l, 1234567891234l, "active");
		SimDetails simDetails2 = new SimDetails(2l, 1234567892l, 1234567891235l, "inactive");
		
		SimOffers simOffers1 = new SimOffers(1l, 100l, 100l, 120l, 10l, "Free calls and data");
		SimOffers simOffers2 = new SimOffers(2l, 150l, 50l, 100l, 16l, "Free calls");
		
		CustomerAddress customerAddress1 = new CustomerAddress(1l, "Jayanagar", "Bangalore", 560041l, "Karnataka");
		CustomerAddress customerAddress2 = new CustomerAddress(2l, "Vijaynagar", "Mysore", 567017l, "Karnataka");
		
		Customer customer1 = new Customer(1234567891234567l, LocalDate.of(1990, 12, 12), "smith@abc.com", "Smith",
				"John", "Aadhar", customerAddress1, "Karnatka");
		
		Customer customer2 = new Customer(1234567891234568l, LocalDate.of(1998, 12, 12), "bob@abc.com", "Bob",
				"Sam", "Aadhar", customerAddress2, "Karnatka");
		
		CustomerIdentity customerIdentity1 = new CustomerIdentity(1234567891234567l, LocalDate.of(1990, 12, 12), "Smith",
				"John", "smith@abc.com", "Karnatka");
		
		CustomerIdentity customerIdentity2 = new CustomerIdentity(1234567891234568l, LocalDate.of(1998, 12, 12), "Bob",
				"Sam", "bob@abc.com", "Karnatka");
		
		
		simDetails1.setCustomer(customer1);
		simDetails2.setCustomer(customer2);
		
//		customer1.setSimDetails(new HashSet<SimDetails>());
//		customer2.setSimDetails(new HashSet<SimDetails>());
//		
//		customer1.getSimDetails().add(simDetails1);
//		customer2.getSimDetails().add(simDetails2);
		
		simOffers1.addSimDetails(simDetails1);
		simOffers2.addSimDetails(simDetails2);
		
		customerAddressRepository.save(customerAddress1);
		customerAddressRepository.save(customerAddress2);
				
		customerIdentityRepository.save(customerIdentity1);
		customerIdentityRepository.save(customerIdentity2);
		
		
		customerRepository.save(customer1);
		customerRepository.save(customer2);
		
		simOffersRepository.save(simOffers1);
		simOffersRepository.save(simOffers2);
		
		simDetails1.setCustomer(customer1);
		simDetails2.setCustomer(customer2);
		
		simDetailsRepository.save(simDetails1);
		simDetailsRepository.save(simDetails2);
		
		
		
		
		
		
		
		
	}

}
