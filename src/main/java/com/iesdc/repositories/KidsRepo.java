package com.iesdc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesdc.entities.KidsEntity;

@Repository
public interface KidsRepo extends JpaRepository<KidsEntity, Integer> {

	List<KidsEntity> findByCaseNo(long caseNum);

}
