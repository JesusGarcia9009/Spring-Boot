package com.pdr.cobranza.cliente.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdr.cobranza.cliente.controller.RegionesController;
import com.pdr.cobranza.cliente.dto.GenRegionesResponseDTO;
import com.pdr.cobranza.cliente.service.GenRegionesService;
import com.pdr.common.exception.DataNotFoundException;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/regiones")
@Slf4j
public class RegionesControllerImpl implements RegionesController  {

	@Autowired
	private GenRegionesService genRegionesService;
	
	@Override
	@GetMapping("/listar-regiones")
	public ResponseEntity<List<GenRegionesResponseDTO>> listarRegiones() throws DataNotFoundException {
		log.info("[listarRegiones]::Inicio del metodo");
		ResponseEntity<List<GenRegionesResponseDTO>> response = null;

		List<GenRegionesResponseDTO> dto = genRegionesService.getRegiones();
		
		if (!dto.isEmpty()) 
			response = new ResponseEntity<>(dto, HttpStatus.OK);
		else
			throw DataNotFoundException.createWith("no existen registros");
		
		log.info("[listarRegiones]::fin del metodo");
		return response;

	}
	
}
