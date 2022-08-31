package com.infytel.dto;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.infytel.entity.CustomerAddress;


public class CustomerDTO {

	private Long uniqueIdNumber;
	

	@NotNull(message = "{dob.email.required}")
	private LocalDate dateOfBirth;
	
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "{email.not.valid}")
	@NotNull(message = "{dob.email.required}")
	private String emailAddress;
	private String firstName;
	private String lastName;
	private String idType;
	private CustomerAddress customerAddress;
	private Set<SimDetailsDTO> simDetails;
	private String state;

	public CustomerDTO() {
	}

	public CustomerDTO(Long uniqueIdNumber, LocalDate dateOfBirth, String emailAddress, String firstName,
			String lastName, String idType, CustomerAddress customerAddress, Set<SimDetailsDTO> simDetails, String state) {
		this.uniqueIdNumber = uniqueIdNumber;
		this.dateOfBirth = dateOfBirth;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idType = idType;
		this.customerAddress = customerAddress;
		this.simDetails = simDetails;
		this.state = state;
	}

	public Long getUniqueIdNumber() {
		return uniqueIdNumber;
	}

	public void setUniqueIdNumber(Long uniqueIdNumber) {
		this.uniqueIdNumber = uniqueIdNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public CustomerAddress getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Set<SimDetailsDTO> getSimDetails() {
		return simDetails;
	}

	public void setSimDetails(Set<SimDetailsDTO> simDetails) {
		this.simDetails = simDetails;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
