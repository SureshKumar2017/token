package com.token.generator.exception;

import lombok.Data;

@Data
public class GeneratorError {
	private String code;
	private String message;
}
