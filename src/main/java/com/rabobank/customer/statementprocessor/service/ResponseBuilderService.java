package com.rabobank.customer.statementprocessor.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rabobank.customer.statementprocessor.api.dto.CustomerRecord;
import com.rabobank.customer.statementprocessor.api.dto.ErrorRecord;
import com.rabobank.customer.statementprocessor.api.dto.ResponseMessage;

@Service
public class ResponseBuilderService {

	ValidatorService validator;

	public ResponseBuilderService(ValidatorService validator) {
		this.validator = validator;
	}

	public ResponseMessage processRecords(List<CustomerRecord> records) {
		return buildResponseCode(validator.validateRequest(records));
	}

	private List<ErrorRecord> buildErrorRecords(List<CustomerRecord> list) {
		Set<Long> referenceSet = new HashSet<>();
		return list.stream().filter(record -> referenceSet.add(record.getReference()))
				.map(record -> new ErrorRecord(record.getReference(), record.getAccountNumber()))
				.collect(Collectors.toList());
	}

	private List<ErrorRecord> buildErrorRecordsForBothErrors(List<List<CustomerRecord>> validatedRecords) {
		Set<Long> referenceSet = new HashSet<>();
		return validatedRecords.stream().flatMap(List::stream).filter(record -> referenceSet.add(record.getReference()))
				.map(record -> new ErrorRecord(record.getReference(), record.getAccountNumber()))
				.collect(Collectors.toList());
	}

	private ResponseMessage buildResponseCode(List<List<CustomerRecord>> validatedRecords) {
		if (validatedRecords.get(0).size() == 0 && validatedRecords.get(1).size() == 0) {
			return ResponseMessage.builder().result("SUCCESSFUL").build();
		} else if (validatedRecords.get(0).size() != 0 && validatedRecords.get(1).size() == 0) {
			return ResponseMessage.builder().result("DUPLICATE_REFERENCE")
					.errorRecords(buildErrorRecords(validatedRecords.get(0))).build();
		} else if (validatedRecords.get(0).size() == 0 && validatedRecords.get(1).size() != 0) {
			return ResponseMessage.builder().result("INCORRECT_END_BALANCE")
					.errorRecords(buildErrorRecords(validatedRecords.get(1))).build();
		} else if (validatedRecords.get(0).size() != 0 && validatedRecords.get(1).size() != 0) {
			return ResponseMessage.builder().result("DUPLICATE_REFERENCE_INCORRECT_END_BALANCE")
					.errorRecords(buildErrorRecordsForBothErrors(validatedRecords)).build();
		} else {
			return ResponseMessage.builder().result("BAD_REQUEST").build();
		}
	}

}
