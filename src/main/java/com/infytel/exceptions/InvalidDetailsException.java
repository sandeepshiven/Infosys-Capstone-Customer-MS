package com.infytel.exceptions;

public class InvalidDetailsException extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidDetailsException(String errors) {
		super(errors);
	}
	
}
