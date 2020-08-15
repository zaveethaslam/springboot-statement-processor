package com.rabobank.customer.statementprocessor.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rabobank.customer.statementprocessor.api.dto.CustomerRecord;
import com.rabobank.customer.statementprocessor.api.dto.ResponseMessage;
import com.rabobank.customer.statementprocessor.service.ResponseBuilderService;

@RestController
public class StatementProcessorController {

	ResponseBuilderService responseBuilder;

	public StatementProcessorController(ResponseBuilderService responseBuilder) {
		this.responseBuilder = responseBuilder;
	}

	@PostMapping(path = "/process")
	public ResponseEntity<ResponseMessage> validateRecords(@RequestBody List<CustomerRecord> records) {
		ResponseMessage responseMessage = responseBuilder.processRecords(records);
		return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
	}

}
