package com.token.generator.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class JSONResponse {
	@JsonInclude(Include.NON_EMPTY)
	private int status;
	private String errorMessage = null;
	private Object result = null;

	public JSONResponse()
	{
		
	}
	public JSONResponse(Object result, int status) {
		this.result = result;
		this.status = status;
	}

	
}
