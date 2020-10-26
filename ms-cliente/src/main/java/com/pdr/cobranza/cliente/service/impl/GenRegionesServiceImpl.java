package com.pdr.cobranza.cliente.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdr.cobranza.cliente.dto.GenRegionesResponseDTO;
import com.pdr.cobranza.cliente.repository.GenRegionesRepository;
import com.pdr.cobranza.cliente.service.GenRegionesService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GenRegionesServiceImpl implements GenRegionesService{

	@Autowired
	private GenRegionesRepository genRegionesRepository;
	
	
	@Override
	public List<GenRegionesResponseDTO> getRegiones() {
		log.info("[getRegiones]:: Inicio del metodo Regiones");
		List<GenRegionesResponseDTO> response = genRegionesRepository.findAllCustom();
		log.info("[getRegiones]:: fin del metodo Region");
		return response;
	}

}
