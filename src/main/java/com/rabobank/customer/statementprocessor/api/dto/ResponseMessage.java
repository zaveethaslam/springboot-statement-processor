package com.rabobank.customer.statementprocessor.api.dto;

import java.util.ArrayList;
import java.util.List;

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

public class ResponseMessage {

	@Builder.Default
	private String result ="SUCCESSFUL";

	@Builder.Default
	private List<ErrorRecords> errorRecords = new ArrayList<ErrorRecords>();

}
