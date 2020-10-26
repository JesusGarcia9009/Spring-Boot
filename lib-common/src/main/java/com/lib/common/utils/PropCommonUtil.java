package com.lib.common.utils;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lib.common.entity.CbzPropiedadesModel;
import com.lib.common.repository.CbzPropiedadesCommonRepository;

@Component
public class PropCommonUtil {

	private static CbzPropiedadesCommonRepository propRepository;
	
	@Autowired
	private CbzPropiedadesCommonRepository propRepositoyInject;
	
	@PostConstruct
	void init() {
		propRepository = this.propRepositoyInject;
	}
	
	
	public static CbzPropiedadesModel getModelProp(String key) {
		CbzPropiedadesModel res = null;
		Optional<CbzPropiedadesModel>  prop = propRepository.findByCpPropKey(key);
		if(prop.isPresent()) {
			res = prop.get();
		}
		return res;
	}
	
	
	public static String getValue(String key) {
		String res = null;
		Optional<CbzPropiedadesModel>  prop = propRepository.findByCpPropKey(key);
		if(prop.isPresent()) {
			res = prop.get().getCpPropValue();
		}
		return res;
	}
	
	public static String getKeyById(Integer id) {
		String res = null;
		Optional<CbzPropiedadesModel>  prop = propRepository.findById(id);
		if(prop.isPresent()) {
			res = prop.get().getCpPropKey();
		}
		return res;
	}
	
	
}
