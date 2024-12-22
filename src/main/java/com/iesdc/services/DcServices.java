package com.iesdc.services;

import java.util.Map;

import com.iesdc.bindingclasses.EducationDto;
import com.iesdc.bindingclasses.IncomeDto;
import com.iesdc.bindingclasses.KidsDto;
import com.iesdc.bindingclasses.PlanSelectionDto;
import com.iesdc.bindingclasses.Summarydto;

public interface DcServices {
	
	public Map<Integer, String> getPlans();
	public boolean savePlanSelection(PlanSelectionDto planSelectionDto);
	public boolean saveIncome(IncomeDto incomeDto);
	public boolean saveEducation(EducationDto educationDto );
	public boolean saveKids(KidsDto kidsDto);
	public Summarydto fetchSummaryInfo(long caseNum);

}
