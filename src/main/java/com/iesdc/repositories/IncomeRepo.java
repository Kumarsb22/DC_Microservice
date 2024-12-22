package com.iesdc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesdc.entities.IncomeEntity;

@Repository
public interface IncomeRepo extends JpaRepository<IncomeEntity, Integer>{

	IncomeEntity findByCaseNO(long caseNum);

}
