/**
 * 
 */
package com.token.generator.common;

/**
 * @author dsure
 *
 */

public class TokenDetails {
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * Refer the status
	 */
	private String token;
	/**
	 * Refer the message
	 */
	private String message;
	
	
}
