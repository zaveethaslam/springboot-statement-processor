package com.rabobank.customer.statementprocessor.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CustomerRecord {

	private Long reference;

	private String accountNumber;

	private Double startBalance;

	private String mutation;

	private String description;

	private Double endBalance;

}
