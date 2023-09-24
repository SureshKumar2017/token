package com.token.generator;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.token.generator.common.TokenNumberGenerator;
import com.token.generator.exception.GeneratorException;
import com.token.generator.service.GeneratorServiceImpl;
/**
 * Junit test class for Token number generator
 * @author dsure
 *
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TokenNumberGenerationTest {

	private static Logger logger = LoggerFactory.getLogger(TokenNumberGenerationTest.class);

	@Autowired
    private TokenNumberGenerator tokenNumberGenerator;
	
	@BeforeEach
	public void init() {
	   MockitoAnnotations.openMocks(this);
	}
	
	
	/**
	 * Token Expression True scenario
	 */
	@Test
	public void tokenExpressionValidatorTrue() {
		String tokenDigit = "7,9,9,8,0";
		String token=null;
		try {
			token = tokenNumberGenerator.tokenNumberGeneration(tokenDigit);
			logger.info(token);
		} catch (GeneratorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals("", token);
	}

}
