package com.pdr.cobranza.cliente.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdr.cobranza.cliente.controller.TipoDireccionController;
import com.pdr.cobranza.cliente.dto.CbzTipoDocumentoResponseDTO;
import com.pdr.cobranza.cliente.service.TipoDireccionService;
import com.pdr.common.exception.DataNotFoundException;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/tipo-direccion")
@Slf4j
public class TipoDireccionControllerImpl implements TipoDireccionController {
	
	@Autowired
	private TipoDireccionService tipoDireccionService;
	
	@GetMapping("/obtener-tipo-direccion")
    public ResponseEntity<List<CbzTipoDocumentoResponseDTO>> obtenerTipoDireccion() throws DataNotFoundException{
		log.info("RatificarDatosCliente::Inicio del metodo");
		ResponseEntity<List<CbzTipoDocumentoResponseDTO>> response = null;
		List<CbzTipoDocumentoResponseDTO> result =   tipoDireccionService.getTipoDireccion();
		if(!result.isEmpty())
			response = new ResponseEntity<>(result, HttpStatus.OK);
		else
			throw DataNotFoundException.createWith("servicio sin informaion");
			
		log.info("RatificarDatosCliente::fin del metodo");
		return response;
    	
    }


}
