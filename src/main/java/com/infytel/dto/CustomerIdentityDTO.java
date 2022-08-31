package com.infytel.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CustomerIdentityDTO {
	
	@NotNull(message = "{uniqueId.null}")
	@Min(value = (long)1e15, message = "{uniqueId.length}")
	private Long uniqueIdNumber;
	
	@NotNull(message = "{dob.null}")
	private LocalDate dateOfBirth;
	
	@NotEmpty(message = "{first.last.name.not.present}")
	private String firstName;
	
	@NotEmpty(message = "{first.last.name.not.present}")
	private String lastName;
	
	private String emailAddress;
	
	private String state;

	public CustomerIdentityDTO() {
	}

	public CustomerIdentityDTO(Long uniqueIdNumber, LocalDate dateOfBirth, String firstName, String lastName,
			String emailAddress, String state) {
		this.uniqueIdNumber = uniqueIdNumber;
		this.dateOfBirth = dateOfBirth;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
