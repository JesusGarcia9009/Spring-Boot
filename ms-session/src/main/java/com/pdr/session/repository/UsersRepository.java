package com.pdr.session.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdr.common.session.entity.UsersModel;

/**
 * @description The Interface CobPagareRepository.
 * @author BS2
 */
@Repository
public interface UsersRepository extends JpaRepository<UsersModel, BigDecimal> {
	
	UsersModel findByRutOrUsername(String rut, String username);
	
	Long countByRutOrUsername(String rut, String username);
	
}
