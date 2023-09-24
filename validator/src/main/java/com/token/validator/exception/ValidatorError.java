package com.token.validator.exception;

import lombok.Data;

@Data
public class ValidatorError {
	private String code;
	private String message;
}
