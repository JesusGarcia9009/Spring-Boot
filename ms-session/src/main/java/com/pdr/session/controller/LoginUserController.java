package com.pdr.session.controller;

import org.springframework.http.ResponseEntity;

import com.pdr.common.exception.UserNotAuthException;
import com.pdr.session.dto.UserAuthRequestDTO;
import com.pdr.session.dto.UserAuthResponseDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * LoginUserController
 * 
 * Servicio encargado de hacer login en los nuevos microservicios y ademas otorgando los roles por usuario
 * 
 * @author Nelson Alvarado
 */
@Api(value = "Microservicio de Login", description = "Esta API tiene los servicios referentes a operaciones de autentificacion")
public interface LoginUserController {


	@ApiOperation(value = "Autentificar", notes = "Retorna los datos de la api de coneccion a nuestra aplicacion")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorno satisfactorio"),
            @ApiResponse(code = 401, message = "No autorizado"),
            @ApiResponse(code = 403, message = "Prohibido"),
            @ApiResponse(code = 404, message = "No encontrado")
    })

	
	/**
	 * Metodo encargado de llamar la autentificacion de parque y asignar los roles al token creado.
	 * 
	 * @param dto UserAuthRequestDTO.class 
	 * @return
	 */
	public ResponseEntity<UserAuthResponseDTO> autenticacionUsuario(UserAuthRequestDTO dto)  throws UserNotAuthException ;
	
}
