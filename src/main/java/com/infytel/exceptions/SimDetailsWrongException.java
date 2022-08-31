package com.infytel.exceptions;

public class SimDetailsWrongException extends Exception{

	private static final long serialVersionUID = 1L;

	
	public SimDetailsWrongException(String errors) {
		super(errors);
	}
	
}
