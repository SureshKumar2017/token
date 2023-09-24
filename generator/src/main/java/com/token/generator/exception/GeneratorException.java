/**
 * 
 */
package com.token.generator.exception;

import lombok.Data;

/**
 * @author dsure
 *
 */
@Data
public class GeneratorException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Validation error
	 */
	private GeneratorError error;
	/**
	 * Message
	 */
	private String message=null;
	
	public GeneratorException() {
	}
	
	public GeneratorException(GeneratorError error) {
		this.error = error;
	}
	
	public GeneratorException(String message) {
		this.message = message;
	}
}
