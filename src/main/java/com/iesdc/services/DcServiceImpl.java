package com.iesdc.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iesdc.bindingclasses.EducationDto;
import com.iesdc.bindingclasses.IncomeDto;
import com.iesdc.bindingclasses.KidDto;
import com.iesdc.bindingclasses.KidsDto;
import com.iesdc.bindingclasses.PlanSelectionDto;
import com.iesdc.bindingclasses.Summarydto;
import com.iesdc.entities.EducationEntity;
import com.iesdc.entities.IncomeEntity;
import com.iesdc.entities.KidsEntity;
import com.iesdc.entities.PlanSelectionEntity;
import com.iesdc.entities.PlansEntity;
import com.iesdc.repositories.EducationRepo;
import com.iesdc.repositories.IesAppsRepo;
import com.iesdc.repositories.IncomeRepo;
import com.iesdc.repositories.KidsRepo;
import com.iesdc.repositories.PlanSelectionRepo;
import com.iesdc.repositories.PlansRepo;
import com.iesdc.repositories.UserRepo;

@Service
public class DcServiceImpl implements DcServices {

	private UserRepo userRepo;
	private EducationRepo educationRepo;
	private IesAppsRepo iesAppsRepo;
	private IncomeRepo incomeRepo;
	private KidsRepo kidsRepo;
	private PlanSelectionRepo planSelectionRepo;
	private PlansRepo plansRepo;

	@Autowired
	public DcServiceImpl(UserRepo userRepo, EducationRepo educationRepo, IesAppsRepo iesAppsRepo, IncomeRepo incomeRepo,
			KidsRepo kidsRepo, PlanSelectionRepo planSelectionRepo, PlansRepo plansRepo) {
		super();
		this.userRepo = userRepo;
		this.educationRepo = educationRepo;
		this.iesAppsRepo = iesAppsRepo;
		this.incomeRepo = incomeRepo;
		this.kidsRepo = kidsRepo;
		this.planSelectionRepo = planSelectionRepo;
		this.plansRepo = plansRepo;
	}

	@Override
	public Map<Integer, String> getPlans() {
		List<PlansEntity> findAll = this.plansRepo.findAll();
		Map<Integer, String> map = new HashMap<>();

		for (PlansEntity plansEntity : findAll) {
			map.put(plansEntity.getPlanId(), plansEntity.getPlanName());
		}
		return map;
	}

	@Override
	public boolean savePlanSelection(PlanSelectionDto planSelectionDto) {
		PlanSelectionEntity planSelectionEntity = new PlanSelectionEntity();
		BeanUtils.copyProperties(planSelectionDto, planSelectionEntity);
		PlanSelectionEntity save = this.planSelectionRepo.save(planSelectionEntity);
		if (save != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean saveIncome(IncomeDto incomeDto) {
		IncomeEntity incomeEntity = new IncomeEntity();
		BeanUtils.copyProperties(incomeDto, incomeEntity);
		IncomeEntity save = this.incomeRepo.save(incomeEntity);
		if (save != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean saveEducation(EducationDto educationDto) {
		EducationEntity educationEntity = new EducationEntity();
		BeanUtils.copyProperties(educationDto, educationEntity);
		EducationEntity save = this.educationRepo.save(educationEntity);
		if (save != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean saveKids(KidsDto kidsDto) {
		KidsEntity kidsEntity = new KidsEntity();
		BeanUtils.copyProperties(kidsDto, kidsEntity);
		KidsEntity save = this.kidsRepo.save(kidsEntity);
		if (save != null) {
			return true;
		}
		return false;
	}

	@Override
	public Summarydto fetchSummaryInfo(long caseNum) {

		Summarydto summarydto = new Summarydto();

		IncomeEntity incomeEntity = this.incomeRepo.findByCaseNO(caseNum);
		EducationEntity educationEntity = this.educationRepo.findBYCaseNo(caseNum);
		List<KidsEntity> kidsEntity = this.kidsRepo.findByCaseNo(caseNum);
		IncomeDto incomeDto = new IncomeDto();
		KidsDto kidsDto = new KidsDto();
		List<KidDto> dtos = null;
		for (KidsEntity kidsEntity2 : kidsEntity) {
			KidDto kidDto = new KidDto();
			BeanUtils.copyProperties(kidsEntity2, kidDto);
			dtos.add(kidDto);
		}
		kidsDto.setKidDtos(dtos);
		EducationDto educationDto = new EducationDto();
		BeanUtils.copyProperties(educationEntity, educationDto);
		BeanUtils.copyProperties(kidsEntity, kidsDto);
		BeanUtils.copyProperties(incomeEntity, incomeDto);
		summarydto.setEducationDto(educationDto);
		summarydto.setIncomeDto(incomeDto);
		summarydto.setKidsDto(kidsDto);
		return summarydto;
	}

}
