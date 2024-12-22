package com.iesdc.bindingclasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncomeDto {

	private Long caseNo;
	private Double propertyIncome;
	private Double rentIncome;
}
