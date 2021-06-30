package org.vishwa.springboot.employeeportal.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.vishwa.springboot.employeeportal.dto.HttpResponse;

import com.mongodb.DuplicateKeyException;

@ControllerAdvice
public class GlobalException {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

//	@ExceptionHandler(NoHandlerFoundException.class)
//	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<HttpResponse> noHandlerFoundException(NoHandlerFoundException ex, WebRequest request) {
		LOGGER.error("No URL mapped :: {}", ex.getMessage());
		return createHttpResponse(NOT_FOUND, ex.getLocalizedMessage(), ex.getMessage());
	}

	@ExceptionHandler(value = { InvalidInputException.class })
	public ResponseEntity<HttpResponse> handleInvalidInputException(InvalidInputException ex) {
		LOGGER.error("Invalid input parameters supplied:: {}", ex.getMessage());
		return createHttpResponse(BAD_REQUEST, ex.getLocalizedMessage(), ex.getMessage());
	}

	@ExceptionHandler(value = { Unauthorized.class })
	public ResponseEntity<HttpResponse> handleUnauthorizedException(Unauthorized ex) {
		LOGGER.error("Unauthorized Exception: {}", ex.getMessage());
		return createHttpResponse(BAD_REQUEST, ex.getLocalizedMessage(), ex.getMessage());
	}

	@ExceptionHandler(value = { EmployeePortalException.class })
	public ResponseEntity<HttpResponse> handleBusinessException(EmployeePortalException ex) {
		LOGGER.error("Business Exception: {}", ex.getMessage());
		return createHttpResponse(INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), ex.getMessage());
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public ResponseEntity<HttpResponse> internalServerErrorException(DuplicateKeyException ex, WebRequest request) {
		LOGGER.error("Duplicate value: {}", ex.getMessage());
		return createHttpResponse(CONFLICT, ex.getLocalizedMessage(), ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<HttpResponse> internalServerErrorException(Exception ex, WebRequest request) {
		LOGGER.error("Exception: {}", ex.getMessage());
		return createHttpResponse(INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), ex.getMessage());
	}

	private ResponseEntity<HttpResponse> createHttpResponse(HttpStatus httpStatus, String message, String error) {
		return new ResponseEntity<>(new HttpResponse(httpStatus.value(), error, null), httpStatus);
	}

}
