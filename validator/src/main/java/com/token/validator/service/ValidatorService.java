package com.token.validator.service;

import com.token.validator.common.TokenStatus;
import com.token.validator.exception.ValidatorException;
/**
 * 
 * @author dsure
 *
 */
public interface ValidatorService {
	/**
	 * It validate the token with Lunh algorthim
	 * @param token
	 * @return
	 * @throws ValidatorException
	 */
	public TokenStatus isValidToken(String token) throws ValidatorException;
}
