package com.lib.common.utils;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lib.common.repository.CbzPropiedadesCommonRepository;

@Component
public class FechaUtils {

	private static CbzPropiedadesCommonRepository propRepository;

	@Autowired
	private CbzPropiedadesCommonRepository propRepositoyInject;

	@PostConstruct
	void init() {
		propRepository = this.propRepositoyInject;
	}

	public static Date getDate() {
		return propRepository.getDate();
	}
	
	
	
	

}
