package com.ms.cliente.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.cliente.controller.TelefonoController;
import com.ms.cliente.dto.DemograficDataRequest;
import com.ms.cliente.dto.GenTelefonoDTO;
import com.ms.cliente.dto.GenTelefonoResponse;
import com.ms.cliente.dto.RatificarDatosRequest;
import com.ms.cliente.service.TelefonoService;
import com.ms.cliente.utils.ConstantesUtil;
import com.pdr.common.exception.InsertOrUpdateException;
import com.pdr.common.exception.NotRatificationException;
import com.pdr.common.exception.UserNotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/telefono")
@Slf4j
public class TelefonoControllerImpl implements TelefonoController {

	@Autowired
	private TelefonoService telefonoService;
	
	@PostMapping("/ratificar-telefono")
	public ResponseEntity<Boolean> ratificaTelefono(@Valid @RequestBody RatificarDatosRequest dataRatificacion)
		throws NotRatificationException {
		log.info("RatificarDatosCliente::Inicio del metodo");
		ResponseEntity<Boolean> response = null;

		boolean resultado = telefonoService.ratificarTelefono(dataRatificacion);
		
		if (resultado) 
			response = new ResponseEntity<>(resultado, HttpStatus.OK);
		else
			throw NotRatificationException.createWith(ConstantesUtil.TIPO_RATIFICACION_TELEFONO);
		
		log.info("RatificarDatosCliente::fin del metodo");
		return response;
	}
	
	@PostMapping("/buscar-telefonos")
	public ResponseEntity<List<GenTelefonoResponse>> buscarTelefonos(@Valid @RequestBody DemograficDataRequest genTelefonoRequest) throws UserNotFoundException{
		log.info("buscarMails::Inicio del metodo");
		ResponseEntity<List<GenTelefonoResponse>> response = null;
		List<GenTelefonoResponse> result = telefonoService.buscarTelefonos(genTelefonoRequest);
		
		if (result != null && !result.isEmpty())
			response = new ResponseEntity<>(result, HttpStatus.OK);
		else
			response = new ResponseEntity<>(result , HttpStatus.NO_CONTENT);
		
		log.info("buscarMails::fin del metodo");
		return response;
	}
	
	@PostMapping("/insertar-telefono")
	public ResponseEntity<Boolean> insertTelefono(@Valid @RequestBody GenTelefonoDTO genTelefono) throws InsertOrUpdateException {
		log.info("insertarDireccion::Inicio del metodo");
		ResponseEntity<Boolean> response = null;

		//agregar la telefono
		boolean resultado = telefonoService.insertTelefono(genTelefono);
		
		if (resultado) 
			response = new ResponseEntity<>(resultado, HttpStatus.OK);
		else
			throw InsertOrUpdateException.createWith("Controller:: insertTelefono");
		
		log.info("insertarDireccion::fin del metodo");
		return response;
	}

}
