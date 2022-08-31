package com.infytel.util;

public enum SimActivationConstants {
	
	
	SIM_DETAILS_INCORRECT("sim.details.wrong"),
	SIM_ACTIVE("sim.active"),
	CUSTOMER_NOT_FOUND("customer.not.found"),
	INCORRECT_EMAIL("email.not.valid"),
	INVALID_DETAILS("invalid.details");
	
	private final String type;
	
	private SimActivationConstants(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type;
	}

}
