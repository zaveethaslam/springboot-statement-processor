package com.rabobank.customer.statementprocessor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import com.rabobank.customer.statementprocessor.api.dto.CustomerRecord;

class ResponseBuilderServiceTest {

	@Mock
	ValidatorService validator;
	
	@Test
	public void test_process_records_successful() {
		ResponseBuilderService responseBuilder = new ResponseBuilderService(validator);
		List<List<CustomerRecord>> validatedRecords = new ArrayList<List<CustomerRecord>>();
		List<CustomerRecord> list1 = new ArrayList<CustomerRecord>();
		List<CustomerRecord> list2 = new ArrayList<CustomerRecord>();
		validatedRecords.add(list1);
		validatedRecords.add(list2);
		assertEquals("SUCCESSFUL", responseBuilder.buildResponseCode(validatedRecords).getResult());
	}
	
	@Test
	public void test_process_records_duplicate_records() {
		ResponseBuilderService responseBuilder = new ResponseBuilderService(validator);
		List<List<CustomerRecord>> validatedRecords = new ArrayList<List<CustomerRecord>>();
		List<CustomerRecord> list1 = new ArrayList<CustomerRecord>();
		List<CustomerRecord> list2 = new ArrayList<CustomerRecord>();
		list1.add(CustomerRecord.builder().build());
		validatedRecords.add(list1);
		validatedRecords.add(list2);
		assertEquals("DUPLICATE_REFERENCE", responseBuilder.buildResponseCode(validatedRecords).getResult());
	}
	
	@Test
	public void test_process_records_unbalanced_records() {
		ResponseBuilderService responseBuilder = new ResponseBuilderService(validator);
		List<List<CustomerRecord>> validatedRecords = new ArrayList<List<CustomerRecord>>();
		List<CustomerRecord> list1 = new ArrayList<CustomerRecord>();
		List<CustomerRecord> list2 = new ArrayList<CustomerRecord>();
		list2.add(CustomerRecord.builder().build());
		validatedRecords.add(list1);
		validatedRecords.add(list2);
		assertEquals("INCORRECT_END_BALANCE", responseBuilder.buildResponseCode(validatedRecords).getResult());
	}
	
	@Test
	public void test_process_records_duplicate_unbalanced_records() {
		ResponseBuilderService responseBuilder = new ResponseBuilderService(validator);
		List<List<CustomerRecord>> validatedRecords = new ArrayList<List<CustomerRecord>>();
		List<CustomerRecord> list1 = new ArrayList<CustomerRecord>();
		List<CustomerRecord> list2 = new ArrayList<CustomerRecord>();
		list1.add(CustomerRecord.builder().build());
		list2.add(CustomerRecord.builder().build());
		validatedRecords.add(list1);
		validatedRecords.add(list2);
		assertEquals("DUPLICATE_REFERENCE_INCORRECT_END_BALANCE", responseBuilder.buildResponseCode(validatedRecords).getResult());
	}
	
}
