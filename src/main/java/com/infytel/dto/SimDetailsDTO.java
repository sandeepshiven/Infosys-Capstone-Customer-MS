package com.infytel.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.infytel.entity.Customer;



public class SimDetailsDTO {

	private Long simId;

	@Min(value = (long)1e9, message= "{sim.service.number.invalid}")
	@Max(value = (long)1e10 - 1, message="{sim.service.number.invalid}")
	private Long serviceNumber;
	
	@Min(value = (long)1e12, message= "{sim.number.invalid}")
	@Max(value = (long)1e13 - 1, message="{sim.number.invalid}")
	private Long simNumber;
	private String simStatus;
	private Set<SimOffersDTO> simOffers = new HashSet<>();
	private Customer customer;

	public SimDetailsDTO() {
	}

	public SimDetailsDTO(Long simId, Long serviceNumber, Long simNumber, String simStatus, Set<SimOffersDTO> simOffers) {
		this.simId = simId;
		this.serviceNumber = serviceNumber;
		this.simNumber = simNumber;
		this.simStatus = simStatus;
		this.simOffers = simOffers;
	}

	public Long getSimId() {
		return simId;
	}

	public void setSimId(Long simId) {
		this.simId = simId;
	}

	public Long getServiceNumber() {
		return serviceNumber;
	}

	public void setServiceNumber(Long serviceNumber) {
		this.serviceNumber = serviceNumber;
	}

	public Long getSimNumber() {
		return simNumber;
	}

	public void setSimNumber(Long simNumber) {
		this.simNumber = simNumber;
	}

	public String getSimStatus() {
		return simStatus;
	}

	public void setSimStatus(String simStatus) {
		this.simStatus = simStatus;
	}

	public Set<SimOffersDTO> getSimOffers() {
		return simOffers;
	}

	public void setSimOffers(Set<SimOffersDTO> simOffers) {
		this.simOffers = simOffers;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
