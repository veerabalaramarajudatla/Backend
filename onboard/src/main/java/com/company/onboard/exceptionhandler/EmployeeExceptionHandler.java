package com.company.onboard.exceptionhandler;
@SuppressWarnings("serial")
public class EmployeeExceptionHandler extends RuntimeException {
	public EmployeeExceptionHandler(String message) {
		super(message);
	}
}
