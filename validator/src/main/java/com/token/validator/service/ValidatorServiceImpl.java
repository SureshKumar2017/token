package com.token.validator.service;

import java.text.MessageFormat;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.token.validator.common.TokenNumberValidator;
import com.token.validator.common.TokenStatus;
import com.token.validator.common.ValidatorConstant;
import com.token.validator.exception.ValidatorError;
import com.token.validator.exception.ValidatorException;

@Service
/**
 * This service class used to do the token validation.
 * @author dsure
 *
 */
public class ValidatorServiceImpl implements ValidatorService{

	/**
	 * Logger
	 */
	private static Logger logger = LoggerFactory.getLogger(ValidatorServiceImpl.class);
	
	@Autowired
	/**
	 * Token number validator constant
	 */
	public TokenNumberValidator tokenNumberValidator;
	
	@Override
	public TokenStatus isValidToken(String token) throws ValidatorException{
		logger.info(MessageFormat.format(" Input Token Number {0} ", token));
		TokenStatus tokenStatus = new TokenStatus();
		if(!Optional.ofNullable(token).isEmpty()) {
			boolean isTokenValid= tokenNumberValidator.tokenExpressionValidator(token);
			if(isTokenValid) {
				token = token.replace("-", "");
				if(tokenNumberValidator.checkLuhnDigit(token)){
					logger.info(MessageFormat.format("Token {0} is valid ", token));
					tokenStatus.setStatus("Success");
					tokenStatus.setMessage("Token is VALID");
				}else{
					logger.info(MessageFormat.format("Token {0} is invalid ", token));
					tokenStatus.setStatus("Fail");
					tokenStatus.setMessage("Token is INVALID");
				}
			}else {
				ValidatorError error = new ValidatorError();
				error.setCode(ValidatorConstant.TOKEN_FORMAT_INVALID);
				throw new ValidatorException(error);
			}
		 }
		
        return tokenStatus;
	}	

}
