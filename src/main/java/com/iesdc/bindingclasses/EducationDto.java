package com.iesdc.bindingclasses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {

	private Long caseNo;
	private String HighestDegree;
	private LocalDate graduationYear;
	private String university;
	
}
