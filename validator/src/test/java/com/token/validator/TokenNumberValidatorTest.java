package com.token.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.token.validator.common.TokenNumberValidator;
/**
 * Junit test class for Token number validator
 * @author dsure
 *
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TokenNumberValidatorTest {

	@Autowired
    private TokenNumberValidator tokenNumberValidator;
	
	@BeforeEach
	public void init() {
	   MockitoAnnotations.openMocks(this);
	}
	
	
	/**
	 * Token Expression True scenario
	 */
	@Test
	public void tokenExpressionValidatorTrue() {
		String token = "2345-2354-5677-8976";
		boolean tokenValid = tokenNumberValidator.tokenExpressionValidator(token);
		assertTrue(tokenValid);
	}
	
	/**
	 *  Token Expression False scenario
	 */
	@Test
	public void tokenExpressionValidatorFailure() {
		String token = "2345-2354-5677-89763";
		boolean tokenValid = tokenNumberValidator.tokenExpressionValidator(token);
		assertFalse(tokenValid);
	}
	
	/**
	 *  Token Expression False alphanumeric scenario
	 */
	@Test
	public void tokenExpressionValidatorAlpha() {
		String token = "2345-2354-r677-9763";
		boolean tokenValid = tokenNumberValidator.tokenExpressionValidator(token);
		assertFalse(tokenValid);
	}
	
	/**
	 *  Check Luhn digit true  scenario
	 */
	@Test
	public void testCheckLuhnDigitSuccess() {
		String token = "4532015112830366";
		boolean tokenLuhn = tokenNumberValidator.checkLuhnDigit(token);
		assertTrue(tokenLuhn);
	}
	
	/**
	 *  Check Luhn digit false  scenario
	 */
	@Test
	public void testCheckLuhnDigitFailure() {
		String token = "4532015112830364";
		boolean tokenLuhn = tokenNumberValidator.checkLuhnDigit(token);
		assertFalse(tokenLuhn);
	}
}
