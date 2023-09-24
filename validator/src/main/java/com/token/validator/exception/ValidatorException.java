/**
 * 
 */
package com.token.validator.exception;

import lombok.Data;

/**
 * @author dsure
 *
 */
@Data
public class ValidatorException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Validation error
	 */
	private ValidatorError error;
	/**
	 * Message
	 */
	private String message=null;
	
	public ValidatorException() {
	}
	
	public ValidatorException(ValidatorError error) {
		this.error = error;
	}
	
	public ValidatorException(String message) {
		this.message = message;
	}
}
