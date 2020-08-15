package com.rabobank.customer.statementprocessor.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rabobank.customer.statementprocessor.api.dto.CustomerRecords;
import com.rabobank.customer.statementprocessor.api.dto.ResponseMessage;
import com.rabobank.customer.statementprocessor.service.ValidatorService;

@RestController
public class StatementProcessorController {
	
	ValidatorService validator;
	
	public StatementProcessorController(ValidatorService validator) {
		this.validator = validator;
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, path="/process")
	public ResponseEntity<ResponseMessage> validateRecords(@RequestBody List<CustomerRecords> records){
		ResponseMessage responseMessage = validator.validateRequest(records);
		return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
	}

}
