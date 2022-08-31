package com.infytel.exceptions;

public class SimActiveException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public SimActiveException(String errors) {
		super(errors);
	}

}
