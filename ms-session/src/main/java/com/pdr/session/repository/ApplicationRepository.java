package com.pdr.session.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pdr.common.session.entity.ApplicationModel;

/**
 * @description The Interface CobPagareRepository.
 * @author BS2
 */
@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationModel, BigDecimal> {
	
	@Query(value = "SELECT app FROM ApplicationModel app"
			+ " WHERE app.landingPage in :landingPage "
			+ " order by app.name asc ")
	List<ApplicationModel> findByLandingPageOrderByName(String landingPage);

	

}
