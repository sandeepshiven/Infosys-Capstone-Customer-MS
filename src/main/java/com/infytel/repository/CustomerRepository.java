package com.infytel.repository;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infytel.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query(value = "select c from Customer c where c.dateOfBirth = ?1 and c.emailAddress = ?2")
	public Customer findByDobAndEmail(LocalDate dob, String email);
	
	@Query(value = "select c from Customer c where c.firstName = ?1 and c.lastName = ?2")
	public Customer findByFirstAndLastName(String firstName, String lastName);
	

}
