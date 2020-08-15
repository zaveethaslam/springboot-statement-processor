package com.rabobank.customer.statementprocessor.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ErrorRecords {

	private Long referenceNumber;

	private String accountNumber;

}
