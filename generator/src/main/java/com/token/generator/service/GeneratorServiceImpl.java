package com.token.generator.service;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.token.generator.common.TokenDetails;
import com.token.generator.common.TokenNumberGenerator;
import com.token.generator.exception.GeneratorException;
import com.token.generator.model.TokenGeneratorVO;

@Service
/**
 * This service class used to do the token generation.
 * @author dsure
 *
 */
public class GeneratorServiceImpl implements GeneratorService{

	/**
	 * Logger
	 */
	private static Logger logger = LoggerFactory.getLogger(GeneratorServiceImpl.class);
	
	@Autowired
	public TokenNumberGenerator generator;
	
	@Override
	public TokenDetails tokenGenerator(TokenGeneratorVO tokenGeneratorVO) throws GeneratorException {
		TokenDetails tokenDetails = new TokenDetails();
		String inputDigit= tokenGeneratorVO.getInputDigit();
		logger.info(MessageFormat.format("Input digit {0}", inputDigit));
		
		String token = generator.tokenNumberGeneration(inputDigit);
		
		logger.info(MessageFormat.format("Generated token is {0}", token));
		
		tokenDetails.setToken(token);
		if(token!=null && !"".equalsIgnoreCase(token)) {
			tokenDetails.setMessage("Token Generated");
		}
		return tokenDetails;
	}
	
}
