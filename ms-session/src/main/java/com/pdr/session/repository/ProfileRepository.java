package com.pdr.session.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pdr.common.session.entity.ProfileModel;

/**
 * @description The Interface CobPagareRepository.
 * @author BS2
 */
@Repository
public interface ProfileRepository extends JpaRepository<ProfileModel, BigDecimal> {

	@Query(value = "SELECT p FROM ProfileModel p "
			+ "INNER JOIN p.userProfiles up " + 
			"WHERE up.users.username = :username ")
	List<ProfileModel> findbyUsername(String username);

}
