/**
 * 
 */
package com.token.generator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.token.generator.common.TokenDetails;
import com.token.generator.exception.GeneratorException;
import com.token.generator.model.TokenGeneratorVO;
import com.token.generator.service.GeneratorService;

/**
 * Controller class for token generator
 * @author dsure
 *
 */
@RestController
@RequestMapping("/token")
@CrossOrigin(value = "*")
public class TokenGeneratorController {
	
	@Autowired
	public GeneratorService generatorService;

	/**
	 * Token Generator
	 * @param token
	 * @return
	 * @throws GeneratorException
	 */
	@PostMapping("/generate")
	public ResponseEntity<TokenDetails> tokenGenerator(@RequestBody TokenGeneratorVO tokenGeneratorVO) throws GeneratorException {
		TokenDetails tokenDetails= generatorService.tokenGenerator(tokenGeneratorVO);
        return new ResponseEntity<>(tokenDetails, HttpStatus.CREATED);
	}
}
