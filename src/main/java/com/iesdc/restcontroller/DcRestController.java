package com.iesdc.restcontroller;

import javax.net.ssl.HttpsURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iesdc.bindingclasses.EducationDto;
import com.iesdc.bindingclasses.IncomeDto;
import com.iesdc.bindingclasses.KidsDto;
import com.iesdc.bindingclasses.PlanSelectionDto;
import com.iesdc.bindingclasses.Summarydto;
import com.iesdc.services.DcServices;

@RestController
public class DcRestController {

	Logger logger = LoggerFactory.getLogger(DcRestController.class);

	private DcServices dcServices;

	@Autowired
	public DcRestController(DcServices dcServices) {
		this.dcServices = dcServices;
	}

	@PostMapping("/plan-selection")
	public ResponseEntity<String> createPlanSelection(@RequestBody PlanSelectionDto planSelectionDto) {
		logger.debug("PlanSelection Creation process started");
		boolean planSelection = this.dcServices.savePlanSelection(planSelectionDto);
		logger.debug("PlanSelection Creation process completed");
		if (planSelection) {
			logger.info("Plan Selection Created");
			return new ResponseEntity<String>("Plan Selection created", HttpStatus.CREATED);
		}
		logger.info(" Plan Selection failed");
		return new ResponseEntity<>(" Plan Selection failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/education")
	public ResponseEntity<String> createEducation(@RequestBody EducationDto educationDto) {
		logger.debug("Education Creation process started");
		boolean education = this.dcServices.saveEducation(educationDto);
		logger.debug("Education Creation process completed");
		if (education) {
			logger.info("Education Created Successfully");
			return new ResponseEntity<String>("Education Created Successfully", HttpStatus.CREATED);
		}
		logger.info("Education Creation Failed");
		return new ResponseEntity<String>("Education Creation Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/income")
	public ResponseEntity<String> createIncome(@RequestBody IncomeDto incomeDto) {
		logger.debug("Income creation process started");
		boolean income = this.dcServices.saveIncome(incomeDto);
		logger.debug("Income creatiom process completed");
		if (income) {
			logger.info("Income Created Successfully");
			return new ResponseEntity<String>("Income Created Successfully", HttpStatus.CREATED);

		}
		logger.info("Income Creation failed");
		return new ResponseEntity<String>("Income Creation failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/kids")
	public ResponseEntity<String> createKid(@RequestBody KidsDto kidsDto) {
		logger.debug("Kids Creation process started");
		boolean kids = this.dcServices.saveKids(kidsDto);
		logger.debug("Kids creation process completed");
		if (kids) {
			logger.info("Kids Created Successfully");
			return new ResponseEntity<String>("Kids Created Successfully", HttpStatus.CREATED);
		}
		logger.info("Kids Creation faild");
		return new ResponseEntity<String>("Kids Creation faild", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/summary/{caseNO}")
	public ResponseEntity<Summarydto> fetchSummary(@PathVariable("caseNo") Long caseNO) {
		logger.info("Summary fetched successfully");
		return new ResponseEntity<Summarydto>(this.dcServices.fetchSummaryInfo(caseNO), HttpStatus.OK);
	}

}
