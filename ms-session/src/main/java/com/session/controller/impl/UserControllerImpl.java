package com.session.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdr.common.exception.DataNotFoundException;
import com.pdr.common.session.entity.ProfileModel;
import com.session.controller.UserController;
import com.session.repository.ProfileRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("${api.config.common.base.uri}/user-util")
public class UserControllerImpl implements UserController {
	
	@Autowired
	private ProfileRepository profile;
	
	
	@GetMapping("/obtiene-idrol/{buscador}")
	public ResponseEntity<String> getRol(@PathVariable(value = "buscador") String nombre) throws DataNotFoundException
	{
		
		log.info("[getRol]:: inicio de metodo");
		log.debug("[getRol]consultamos-->" + nombre);
		ProfileModel pp = profile.findByNameProfile(nombre);
		
		ResponseEntity<String> response = null;
		
		if (pp != null)
			response = new ResponseEntity<>(pp.getIdProfile().toString(), HttpStatus.OK);
		else
			throw DataNotFoundException.createWith("rol consultado no existe ->" + nombre );
			
		log.info("[getRol]:: fin de metodo");
		return response;
		
	}

}
