package com.iesdc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iesdc.entities.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer>{

}
