package com.pdr.cobranza.cliente.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdr.cobranza.cliente.dto.GenComunasResponseDTO;
import com.pdr.cobranza.cliente.repository.GenComunasRepository;
import com.pdr.cobranza.cliente.service.GenComunasService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GenComunaServiceImpl implements GenComunasService {

	@Autowired
	private GenComunasRepository genComunasRepository;
	
	@Override
	public List<GenComunasResponseDTO> getComuna(Integer idRegion) {
		log.info("[getComuna]:: Inicio del metodo comuna");
		log.debug("[getComuna]::idRegion->" + idRegion);
		
		List<GenComunasResponseDTO> result = null;
		if(idRegion != null && idRegion > 0) {
			result = genComunasRepository.findByRegionCustom(idRegion);
		}else {
			result = genComunasRepository.findAllCustom();
		}
		
		log.info("[getComuna]:: fin del metodo comuna");
		return result;
		
	}
	
}
