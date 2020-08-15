package com.rabobank.customer.statementprocessor.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.rabobank.customer.statementprocessor.api.dto.CustomerRecord;

@Service
public class ValidatorService {

	private static DecimalFormat df = new DecimalFormat("0.00");

	public List<List<CustomerRecord>> validateRequest(List<CustomerRecord> records) {
		List<List<CustomerRecord>> validatedRecords = new ArrayList<List<CustomerRecord>>();
		List<CustomerRecord> duplicateRecords = new ArrayList<CustomerRecord>();
		List<CustomerRecord> incorrectBalanceRecords = validateInvalidBalance(records);
		verifyDuplicateRecords(records, duplicateRecords);
		validatedRecords.add(duplicateRecords);
		validatedRecords.add(incorrectBalanceRecords);
		return validatedRecords;
	}

	private List<CustomerRecord> validateInvalidBalance(List<CustomerRecord> records) {

		Function<CustomerRecord, CustomerRecord> functionToValidateTransactionAmount = record -> {
			char mutationSymbol = record.getMutation().charAt(0);
			String mutationValue = record.getMutation().substring(1, record.getMutation().length());
			String endValueToBeMatched;
			double balanceValue = 0;

			if ('+' == mutationSymbol) {
				balanceValue = new BigDecimal(record.getStartBalance()).add(new BigDecimal(mutationValue))
						.doubleValue();
			} else if ('-' == mutationSymbol) {
				balanceValue = new BigDecimal(record.getStartBalance()).subtract(new BigDecimal(mutationValue))
						.doubleValue();
			}
			endValueToBeMatched = df.format(balanceValue);

			if (Double.parseDouble(endValueToBeMatched) != record.getEndBalance())
				return record;
			return null;
		};

		return records.stream().map(functionToValidateTransactionAmount).filter(Objects::nonNull)
				.collect(Collectors.toList());
	}

	private void verifyDuplicateRecords(List<CustomerRecord> records, List<CustomerRecord> duplicateRecords) {
		Map<Long, List<CustomerRecord>> groupByReferenceId = records.stream()
				.collect(Collectors.groupingBy(record -> record.getReference()));

		groupByReferenceId.forEach((k, v) -> {
			if (v.size() > 1) {
				duplicateRecords.addAll(v);
			}
		});

	}
}
