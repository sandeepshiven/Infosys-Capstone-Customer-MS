package com.infytel.exceptions;

public class IncorrectEmailException extends Exception{

	private static final long serialVersionUID = 1L;

	public IncorrectEmailException(String errors) {
		super(errors);
	}
	
}
