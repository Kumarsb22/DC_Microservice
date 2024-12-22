package com.iesdc.bindingclasses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KidsDto {

	private Long caseNo;
	private Integer userId;
	private List<KidDto> kidDtos;

}
