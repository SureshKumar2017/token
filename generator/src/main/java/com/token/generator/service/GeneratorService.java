package com.token.generator.service;

import com.token.generator.common.TokenDetails;
import com.token.generator.exception.GeneratorException;
import com.token.generator.model.TokenGeneratorVO;
/**
 * 
 * @author dsure
 *
 */
public interface GeneratorService {
	/**
	 * It the token using the generator logic
	 * @param token
	 * @return
	 * @throws GeneratorException
	 */
	public TokenDetails tokenGenerator(TokenGeneratorVO tokenGeneratorVO) throws GeneratorException;
}
