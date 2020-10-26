package com.pdr.common.session.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdr.common.session.entity.ProfileModel;

@Repository
public interface ProfileRepository  extends JpaRepository<ProfileModel, BigDecimal>{

	
	Optional<ProfileModel> findByName(String name); 
	
}
