package com.ms.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.cliente.dto.AplicacionesDTO;
import com.ms.cliente.service.AplicacionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/aplicacion")
@Slf4j
public class AplicacionControllerImpl implements AplicacionController {

	@Autowired
	private AplicacionService aplciacionService;

	@Override
	@GetMapping("/obtener-aplicaciones")
	public ResponseEntity<List<AplicacionesDTO>> obtenerAplicaciones(){
		log.info("[obtenerAplicaciones]::Inicio del metodo");
		List<AplicacionesDTO> data = aplciacionService.obtenerAplicaciones();
		log.info("[obtenerAplicaciones]::fin del metodo");
        return new ResponseEntity<>(data, data.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}

}
