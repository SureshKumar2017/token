/**
 * 
 */
package com.token.validator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.token.validator.common.TokenStatus;
import com.token.validator.exception.ValidatorException;
import com.token.validator.service.ValidatorService;

/**
 * Controller class for token validator
 * @author dsure
 *
 */
@RestController
@RequestMapping("/token")
@CrossOrigin(value = "*")
public class TokenValidatorController {
	
	@Autowired
	public ValidatorService validatorService;

	/**
	 * 
	 * @param token
	 * @return
	 * @throws ValidatorException
	 */
	@GetMapping("/validate/{token}")
	public ResponseEntity<TokenStatus> tokenValidate(@PathVariable("token") String token) throws ValidatorException {
		TokenStatus tokenStatus= validatorService.isValidToken(token);
        return new ResponseEntity<>(tokenStatus, HttpStatus.OK);
	}
}
