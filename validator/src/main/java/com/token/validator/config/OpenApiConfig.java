package com.token.validator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
/**
 * Configuration class for open api
 * @author dsure
 *
 */
public class OpenApiConfig {
	 @Bean
	    public OpenAPI usersMicroserviceOpenAPI() {
	        return new OpenAPI()
	                .info(new Info().title("Token Validator")
	                                 .description("This service validates the input token. It validates using Lunh algorithm")
	                                 .version("1.0"));
	    }
}
