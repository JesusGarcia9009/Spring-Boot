package com.ms.cliente.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.cliente.controller.ComunasController;
import com.ms.cliente.dto.GenComunasResponseDTO;
import com.ms.cliente.service.GenComunasService;
import com.pdr.common.exception.DataNotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/comunas")
@Slf4j
public class ComunasControllerImpl implements ComunasController {

	@Autowired
	private GenComunasService genComunasService;
	
	@Override
	@GetMapping("/listar-comunas/{idRegion}")
	public ResponseEntity<List<GenComunasResponseDTO>> listarComunas(@PathVariable(value = "idRegion") Integer idRegion) throws DataNotFoundException{
		log.info("[listarComunas]::Inicio del metodo");
		ResponseEntity<List<GenComunasResponseDTO>> response = null;

		List<GenComunasResponseDTO> dto = genComunasService.getComuna(idRegion);
		
		if (!dto.isEmpty()) 
			response = new ResponseEntity<>(dto, HttpStatus.OK);
		else
			throw DataNotFoundException.createWith(idRegion.toString());
		
		log.info("[listarComunas]::fin del metodo");
		return response;
		
	}
}
