package com.token.validator.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
/**
 * Generic controller advice for token validation
 * @author dsure
 *
 */
public class ValidatorControllerAdvice {

	@Autowired
	private ValidatorMessageSource messageSource;
	
	/**
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ValidatorException.class)
	public ResponseEntity<JSONResponse> exceptionERPHandler(ValidatorException ex) {
		JSONResponse error = new JSONResponse();
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		if(ex!=null && ex.getError()!=null) {
			ValidatorError validatorError = (ValidatorError)ex.getError();
			String errorMessage= messageSource.getMessage(validatorError.getCode());
			error.setErrorMessage(errorMessage);
		}
		return new ResponseEntity<JSONResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<JSONResponse> exceptionHandler(Exception ex) {
		JSONResponse error = new JSONResponse();
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setErrorMessage("Internal server occurred");
		return new ResponseEntity<JSONResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
