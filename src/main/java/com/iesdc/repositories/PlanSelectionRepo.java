package com.iesdc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesdc.entities.PlanSelectionEntity;
import com.iesdc.entities.PlansEntity;

@Repository
public interface PlanSelectionRepo extends JpaRepository<PlanSelectionEntity, Integer>{

}
