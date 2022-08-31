package com.infytel.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerAddressDTO {

	private Long addressId;
	
	@Size(min=1, max=25)
	@NotEmpty(message = "{city.null}")
	private String address;
	
	@NotEmpty(message = "{city.null}")
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "{state.name.invalid}")
	@Size(min=1)
	private String city;
	
	@Min(value = (long)1e5, message = "{pin.invalid}")
	@Max(value = (long)1e6-1, message = "{pin.invalid}")
	@NotNull(message = "{pin.null}")
	private Long pincode;
	
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "{state.name.invalid}")
	@Size(min=1)
	@NotEmpty(message = "{city.null}")
	private String state;

	public CustomerAddressDTO() {
	}

	public CustomerAddressDTO(Long addressId, String address, String city, Long pincode, String state) {
		this.addressId = addressId;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
