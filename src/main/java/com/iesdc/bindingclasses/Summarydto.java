package com.iesdc.bindingclasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Summarydto {

	private EducationDto educationDto;
	private IncomeDto incomeDto;
	private KidsDto kidsDto;
}
