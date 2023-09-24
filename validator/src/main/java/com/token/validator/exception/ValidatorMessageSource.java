package com.token.validator.exception;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
/**
 * Configuration class for read common message from properties file.
 * @author dsure
 *
 */
public class ValidatorMessageSource {
	
	/**
	 * 
	 * @return
	 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:locale/messages", "classpath:/framework_messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setUseCodeAsDefaultMessage(true);
		return messageSource;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public String getMessage(String id) {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource().getMessage(id, null, locale);
	}

	/**
	 * 
	 * @param id
	 * @param args
	 * @return
	 */
	public String getMessage(String id, Object[] args) {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource().getMessage(id, args, locale);
	}
}
