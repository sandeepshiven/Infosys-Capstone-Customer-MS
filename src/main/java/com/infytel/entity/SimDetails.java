package com.infytel.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="sim_details")
public class SimDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sim_id")
	private Long simId;
	
	@Column(name="service_number")
	private Long serviceNumber;
	@Column(name="sim_number")
	private Long simNumber;
	@Column(name="sim_status")
	private String simStatus;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "simDetails")
	@JsonIgnore
	private Set<SimOffers> simOffers = new HashSet<>();
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Customer customer;

	public SimDetails() {

	}

	

	public SimDetails(Long simId, Long serviceNumber, Long simNumber, String simStatus) {
		this.simId = simId;
		this.serviceNumber = serviceNumber;
		this.simNumber = simNumber;
		this.simStatus = simStatus;
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

	public Set<SimOffers> getSimOffers() {
		return simOffers;
	}

	public void setSimOffers(Set<SimOffers> simOffers) {
		this.simOffers = simOffers;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
