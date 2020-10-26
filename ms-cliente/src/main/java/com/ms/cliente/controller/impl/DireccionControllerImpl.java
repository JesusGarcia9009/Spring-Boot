package com.ms.cliente.controller.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.cliente.controller.DireccionController;
import com.ms.cliente.dto.GenDireccionesDTO;
import com.ms.cliente.dto.GenDireccionesResponse;
import com.ms.cliente.dto.RatificarDatosRequest;
import com.ms.cliente.service.DireccionService;
import com.ms.cliente.utils.ConstantesUtil;
import com.pdr.common.exception.InsertOrUpdateException;
import com.pdr.common.exception.NotRatificationException;
import com.pdr.common.exception.UserNotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/direccion")
@Slf4j
public class DireccionControllerImpl implements DireccionController {

	@Autowired
	private DireccionService direccionService;
	
	@GetMapping("/buscar-direcciones/{numDocto}")
	public ResponseEntity<List<GenDireccionesResponse>> buscarDirecciones(@PathVariable(value = "numDocto") BigDecimal numDocto) throws UserNotFoundException{
		log.info("buscarDirecciones::Inicio del metodo");
		ResponseEntity<List<GenDireccionesResponse>> response = null;

		List<GenDireccionesResponse> result = direccionService.buscarDirecciones(numDocto);
		
		if (result != null && !result.isEmpty())
			response = new ResponseEntity<>(result, HttpStatus.OK);
		else
			response = new ResponseEntity<>(result , HttpStatus.NO_CONTENT);
		
		log.info("buscarDirecciones::fin del metodo");
		return response;
	}
	
	@PostMapping("/ratificar-direccion")
	public ResponseEntity<Boolean> ratificaDireccion(@Valid @RequestBody RatificarDatosRequest dataRatificacion)
		throws NotRatificationException {
		log.info("RatificarDatosCliente::Inicio del metodo");
		ResponseEntity<Boolean> response = null;

		boolean resultado = direccionService.ratificarDireccion(dataRatificacion);
		
		if (resultado) 
			response = new ResponseEntity<>(resultado, HttpStatus.OK);
		else
			throw NotRatificationException.createWith(ConstantesUtil.TIPO_RATIFICACION_DIRECCION);
		
		log.info("RatificarDatosCliente::fin del metodo");
		return response;
	}
	
	@PostMapping("/guardar-direccion")
	public ResponseEntity<Boolean> insertarDireccion(@Valid @RequestBody  GenDireccionesDTO genDireccion) throws InsertOrUpdateException {
		log.info("insertarDireccion::Inicio del metodo");
		ResponseEntity<Boolean> response = null;

		//agregar la direccion
		boolean resultado = direccionService.insertDireccion(genDireccion);
		
		if (resultado) 
			response = new ResponseEntity<>(resultado, HttpStatus.OK);
		else
			throw InsertOrUpdateException.createWith("Controller:: insertarDireccion");
		
		log.info("insertarDireccion::fin del metodo");
		return response;
	}

}
