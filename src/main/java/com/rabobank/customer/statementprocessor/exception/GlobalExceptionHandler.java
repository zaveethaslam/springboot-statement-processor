package com.rabobank.customer.statementprocessor.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rabobank.customer.statementprocessor.api.controller.StatementProcessorController;
import com.rabobank.customer.statementprocessor.api.dto.ResponseMessage;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(StatementProcessorController.class);
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ResponseMessage handleInvalidFormatException(final Exception exception,
			final HttpServletRequest request) {
		logger.error(HttpStatus.BAD_REQUEST + " Bad Request");
		return ResponseMessage.builder()
				.result("BAD_REQUEST")
				.build();
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ResponseMessage handleException(final Exception exception,
			final HttpServletRequest request) {
		logger.error(HttpStatus.INTERNAL_SERVER_ERROR + " Internal Server occured");
		return ResponseMessage.builder()
				.result("INTERNAL_SERVER_ERROR")
				.build();
	}
	
}


