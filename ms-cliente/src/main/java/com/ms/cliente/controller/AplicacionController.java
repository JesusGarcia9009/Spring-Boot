package com.ms.cliente.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lib.common.exception.UserNotFoundException;
import com.ms.cliente.dto.AplicacionesDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * Interfaz del controller
 * 
 * @author BS2
 */
@Api( value = "Microservicio de clientes")
public interface AplicacionController {

	/**
	 * Metodo que un cliente a partir del RUT
	 * 
	 * @return GenPersonaIdRequest
	 * @throws UserNotFoundException
	 */
	@ApiOperation(value = "Buscar Aplicaciones", notes = "Retorna el listado de todas las aplicaciones vinculadas!")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<List<AplicacionesDTO>> obtenerAplicaciones() ;
	
	
	
}
