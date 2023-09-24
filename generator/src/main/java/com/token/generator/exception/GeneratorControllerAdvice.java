package com.token.generator.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class GeneratorControllerAdvice {

	private static Logger logger = LoggerFactory.getLogger(GeneratorControllerAdvice.class);

	@Autowired
	private GeneratorMessageSource messageSource;
	
	/**
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(GeneratorException.class)
	public ResponseEntity<JSONResponse> exceptionERPHandler(GeneratorException ex) {
		JSONResponse error = new JSONResponse();
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		if(ex!=null && ex.getError()!=null) {
			GeneratorError validatorError = (GeneratorError)ex.getError();
			String errorMessage= messageSource.getMessage(validatorError.getCode());
			error.setErrorMessage(errorMessage);
		}
		logger.debug(ex.getMessage());
		return new ResponseEntity<JSONResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<JSONResponse> exceptionHandler(Exception ex) {
		logger.debug(ex.getMessage());
		JSONResponse error = new JSONResponse();
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setErrorMessage("Internal server occurred");
		return new ResponseEntity<JSONResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
