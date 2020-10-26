package com.pdr.cobranza.cliente.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pdr.cobranza.cliente.dto.GenComunasResponseDTO;
import com.pdr.common.exception.DataNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * Despliega las comunas de  chile.
 * 
 * @author NelsonAlvaradoVidal
 *
 */
@Api( value = "Microservicio de comunas")
public interface ComunasController {
	
	
	/**
	 * Despliega la informacion de todas las comunas de chile, que se encuentra registradas en la base de datos de pdr.
	 * 
	 * @param idRegion
	 * @return
	 */
	@ApiOperation(value = "Lista de Comunas, dependiendo del valor ingresado", notes = "Retorna la persona solicitada a partir de los datos!")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno satisfactorio")})
	public ResponseEntity<List<GenComunasResponseDTO>> listarComunas(Integer idRegion)throws DataNotFoundException;
	
	
}
