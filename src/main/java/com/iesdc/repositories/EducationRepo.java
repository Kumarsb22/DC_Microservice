package com.iesdc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesdc.entities.EducationEntity;

@Repository
public interface EducationRepo extends JpaRepository<EducationEntity, Integer>{

	EducationEntity findBYCaseNo(long caseNum);

}
