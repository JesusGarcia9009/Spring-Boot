package com.ms.cliente.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ms.cliente.dto.DatosClienteResponseDTO;
import com.ms.cliente.dto.GenPersonaIdRequest;
import com.ms.cliente.dto.GenPersonasDTO;
import com.ms.cliente.dto.V360ClienteDesactulizadoRequestDTO;
import com.ms.cliente.dto.V360ClienteRequestDTO;
import com.ms.cliente.dto.V360ClienteResponseDTO;
import com.pdr.common.exception.DataNotFoundException;
import com.pdr.common.exception.NotRatificationException;
import com.pdr.common.exception.UserNotFoundException;

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
public interface ClienteController {

	/**
	 * Metodo que un cliente a partir del RUT
	 * 
	 * @return GenPersonaIdRequest
	 * @throws UserNotFoundException
	 */
	@ApiOperation(value = "Buscar Cliente", notes = "Retorna la persona solicitada a partir de los datos!")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<GenPersonasDTO> buscarCliente(GenPersonaIdRequest personaId) throws UserNotFoundException;
	
	
	/**
	 * Metodo lista los clientes a partir de nombre o pers_id
	 * 
	 * @return GenPersonaIdRequest
	 * @throws UserNotFoundException
	 */
	@ApiOperation(value = "Busca Clientes", notes = "Retorna las personas solicitadas a partir de los datos!")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<List<V360ClienteResponseDTO>> buscarClientesByString(String buscador);
	
	

	/**
	 * Metodo lista los clientes a partir de folio
	 * 
	 * @return GenPersonaIdRequest
	 * @throws UserNotFoundException
	 */
	@ApiOperation(value = "Busca Cliente por Folio", notes = "Retorna la persona solicitadas a partir del folio!")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<V360ClienteResponseDTO> buscarClientesFolio(V360ClienteRequestDTO folio);
	
	
	
	/**
	 * Metodo que ratifica el telefono valido
	 * 
	 * @return RatificarDatosRequest
	 * @throws NotRatificationException
	 */
    @ApiOperation(value = "Busca date del Cliente desactualizada", notes = "Retorna un boolean")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<Boolean> clienteDesactualizado(V360ClienteDesactulizadoRequestDTO persID);

    /**
     * Obtiene todos los datos del cliente.
     * 
     * @param persID
     * @return
     */
    @ApiOperation(value = "Busca date del Cliente desactualizada", notes = "Retorna un boolean")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<DatosClienteResponseDTO> datosCliente(String persID, String numDocto) throws DataNotFoundException ;
	
}
