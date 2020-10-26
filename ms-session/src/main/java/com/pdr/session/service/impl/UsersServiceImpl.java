package com.pdr.session.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdr.common.session.entity.UsersModel;
import com.pdr.session.repository.UsersRepository;
import com.pdr.session.service.UsersService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersRepository usersRepository;
	
	
	@Override
	public UsersModel buscarUsers(BigDecimal id) {
		log.info("[buscarUsers]::inicio de metodo");
		Optional<UsersModel> optional = usersRepository.findById(id);
		UsersModel result = null;
		if(optional.isPresent())
			result = optional.get();
		else
			result = null;
		log.info("[buscarUsers]::fin de metodo");
		return result;
	}
	
	
	@Override
	public UsersModel buscarUserByNameOrRut(String userNameOrRut) {
		log.info("[buscarUserByNameOrRut]::inicio de metodo");
		UsersModel resultado = null;
		resultado = usersRepository.findByRutOrUsername(userNameOrRut, userNameOrRut);
		
		log.info("[buscarUserByNameOrRut]::fin de metodo");
		return resultado;
	}
	
	@Override
	public Long countUserByNameOrRut(String userNameOrRut) {
		log.info("[countUserByNameOrRut]::inicio de metodo");
		Long resultado = null;
		resultado = usersRepository.countByRutOrUsername(userNameOrRut, userNameOrRut);
		
		log.info("[countUserByNameOrRut]::fin de metodo");
		return resultado;
	}

	
	
	
}
