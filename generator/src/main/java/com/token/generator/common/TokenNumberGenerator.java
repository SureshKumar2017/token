package com.token.generator.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.token.generator.exception.GeneratorError;
import com.token.generator.exception.GeneratorException;

@Component
/**
 * Utility class for token number generation
 * @author dsure
 *
 */
public class TokenNumberGenerator {
	
	/**
	 * Logger for token number generator
	 */
	private static Logger logger = LoggerFactory.getLogger(TokenNumberGenerator.class);


	/**
	 * 
	 * @param inputDigit
	 * @return
	 * @throws GeneratorException
	 */
	public String tokenNumberGeneration(String inputDigit) throws GeneratorException {
		StringBuilder finalOutput = new StringBuilder();
		StringBuilder app = new StringBuilder();
		
		String[] stringArray2 = null;
		List<Integer> tokenNum = new ArrayList<>();
		List<Integer> tokenList = new ArrayList<>();
			int tokenIndex=1;
			
			if(inputDigit!=null && inputDigit.contains(",")) {
				stringArray2 = inputDigit.split(",");
			}
			
			if(stringArray2!=null) {
				if(stringArray2.length<2) {
					GeneratorError error = new GeneratorError();
					error.setCode(GeneratorConstant.TOKEN_GENERATOR_LENGTH_MINIMUM);
					throw new GeneratorException(error);
				}
				
				tokenIntValidation(stringArray2, tokenNum);
				
				if(!tokenNum.isEmpty()) {
					for(int k=0;k<10;k++) {
						Collections.shuffle(tokenNum);
						tokenList.addAll(tokenNum);
					}
				}
				tokenFormation(finalOutput, app, tokenList, tokenIndex);
			}else {
				GeneratorError error = new GeneratorError();
				error.setCode(GeneratorConstant.TOKEN_GENERATOR_LENGTH);
				throw new GeneratorException(error);
			}
			
		
		return finalOutput.toString();
	}
	/**
	 * 
	 * @param finalOutput
	 * @param app
	 * @param tokenList
	 * @param tokenIndex
	 */
	private void tokenFormation(StringBuilder finalOutput, StringBuilder app, List<Integer> tokenList, int tokenIndex) {
		for(Integer tokenInt : tokenList) {
			if(tokenIndex==1) {
				finalOutput.append(tokenInt);
			}
			if(tokenIndex%4==0 && tokenIndex<17) {
				finalOutput.append(app.toString());
				if(tokenIndex<16) {
					finalOutput.append("-");
				}
				app = new StringBuilder();
			}
			app.append(tokenInt);
			tokenIndex++;
		}
	}

	/**
	 * 
	 * @param stringArray2
	 * @param tokenNum
	 * @throws GeneratorException
	 */
	private void tokenIntValidation(String[] stringArray2, List<Integer> tokenNum) throws GeneratorException {
		for(String strArr : stringArray2) {
			if(!strArr.matches("\\d+")) {
				GeneratorError error = new GeneratorError();
				error.setCode(GeneratorConstant.TOKEN_GENERATOR_ALPHANUMERIC);
				throw new GeneratorException(error);
			}
			
			int tokenIntValue = Integer. parseInt(strArr);
			if(tokenIntValue>=0 && tokenIntValue<10) {
				tokenNum.add(Integer. parseInt(strArr));
			}else {
				GeneratorError error = new GeneratorError();
				error.setCode(GeneratorConstant.TOKEN_GENERATOR_CONTAIN_SINGLE_DIGIT);
				throw new GeneratorException(error);
			}
		}
	}
	
}
