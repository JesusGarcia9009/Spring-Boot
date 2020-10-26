package com.session.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdr.common.session.entity.ProfileSubApplicationModel;

/**
 * @description The Interface CobPagareRepository.
 * @author BS2
 */
@Repository
public interface ProfileSubApplicationRepository extends JpaRepository<ProfileSubApplicationModel, BigDecimal> {

}
