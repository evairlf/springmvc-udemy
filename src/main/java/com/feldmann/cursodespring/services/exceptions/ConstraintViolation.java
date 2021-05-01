package com.feldmann.cursodespring.services.exceptions;

public class ConstraintViolation extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ConstraintViolation(String msg) {
		super(msg);
	}
	
	public ConstraintViolation(String msg, Throwable cause) {
		super(msg,cause);
	}

}
