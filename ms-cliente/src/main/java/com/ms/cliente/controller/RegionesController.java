package com.ms.cliente.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ms.cliente.dto.GenRegionesResponseDTO;
import com.pdr.common.exception.DataNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Despliega laa regiones de chile.
 * 
 * @author NelsonAlvaradoVidal
 *
 */
@Api( value = "Microservicio de regiones")
public interface RegionesController {

	/**
	 * Despliega la informacion de todas la regiones de chile, que se encuentra registradas en la base de datos de pdr.
	 * 
	 * @return List<GenRegionesResponseDTO>
	 */
	@ApiOperation(value = "Lista de Regiones", notes = "Retorna la persona solicitada a partir de los datos!")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno satisfactorio")})
	public ResponseEntity<List<GenRegionesResponseDTO>> listarRegiones() throws DataNotFoundException ;
	
}
