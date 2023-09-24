package com.token.validator.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;
import org.springframework.stereotype.Component;

@Component
/**
 * Utility class for token number validation
 * @author dsure
 *
 */
public class TokenNumberValidator {

	/**
	 * It validates the input token is in correct format like **** **** **** ****
	 * @param token
	 * @return
	 */
	public boolean tokenExpressionValidator(String token) {
		if(token!=null) {
			if(token.length()==19) {
				String regex = "^([0-9]{4}[- ]?){3}[0-9]{4}$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(token);
				return matcher.matches();
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	/**
	 * Validate the token is valid or not in LYHN algorithm
	 * @param token
	 * @return
	 */
	public boolean checkLuhnDigit(String token){
		return LuhnCheckDigit.LUHN_CHECK_DIGIT.isValid(token);
	}

}
