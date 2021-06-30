/**
 * 
 */
package org.vishwa.springboot.employeeportal.exception;

/**
 * @author Vishwanath Hatgundi
 *
 */
public class InvalidInputException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidInputException(String message) {
		super(message);
	}

	public InvalidInputException(Throwable cause) {
		super(cause);
	}

}
