package com.infytel.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;




public class SimOffersDTO {
	

	private Long offerId;
	private Long callQty;
	private Long cost;
	private Long dataQty;
	private Long duration;
	private String offerName;
	
	@JsonIgnore
	private Set<SimDetailsDTO> simDetails = new HashSet<>();
	
	public SimOffersDTO() {
	}

	public SimOffersDTO(Long offerId, Long callQty, Long cost, Long dataQty, Long duration, String offerName,
			Set<SimDetailsDTO> simDetails) {
		this.offerId = offerId;
		this.callQty = callQty;
		this.cost = cost;
		this.dataQty = dataQty;
		this.duration = duration;
		this.offerName = offerName;
		this.simDetails = simDetails;
	}

	public void addSimDetails(SimDetailsDTO simDetail) {
		this.simDetails.add(simDetail);
		simDetail.getSimOffers().add(this);
	}

	public void removeSimDetails(Long simId) {
		SimDetailsDTO simDetail = this.simDetails.stream().filter(t -> t.getSimId() == simId).findFirst().orElse(null);
		if (simDetail != null) {
			this.simDetails.remove(simDetail);
			simDetail.getSimOffers().remove(this);
		}
	}

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public Long getCallQty() {
		return callQty;
	}

	public void setCallQty(Long callQty) {
		this.callQty = callQty;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

	public Long getDataQty() {
		return dataQty;
	}

	public void setDataQty(Long dataQty) {
		this.dataQty = dataQty;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public Set<SimDetailsDTO> getSimDetails() {
		return simDetails;
	}

	public void setSimDetails(Set<SimDetailsDTO> simDetails) {
		this.simDetails = simDetails;
	}
}
