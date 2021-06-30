package org.vishwa.springboot.employeeportal.exception;

public class EmployeePortalException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeePortalException(String message) {
		super(message);
	}

	public EmployeePortalException(Throwable cause) {
		super(cause);
	}

}
