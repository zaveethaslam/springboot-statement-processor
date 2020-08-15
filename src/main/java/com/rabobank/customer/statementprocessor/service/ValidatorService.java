package com.rabobank.customer.statementprocessor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rabobank.customer.statementprocessor.api.dto.CustomerRecords;
import com.rabobank.customer.statementprocessor.api.dto.ResponseMessage;

@Service
public class ValidatorService {
	
	public ResponseMessage validateRequest(List<CustomerRecords> records) {
		return ResponseMessage.builder()
		.result("SUCCESSFUL")
		.build();
	}

}
