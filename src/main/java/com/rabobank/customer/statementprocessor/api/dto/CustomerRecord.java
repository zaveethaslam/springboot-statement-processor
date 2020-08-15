package com.rabobank.customer.statementprocessor.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRecord {

	private Long transactionReference;

	private String accountNumber;

	private Double startBalance;

	private String mutationSymbol;

	private Double mutationValue;

	private String description;

	private Double endBalance;

}
