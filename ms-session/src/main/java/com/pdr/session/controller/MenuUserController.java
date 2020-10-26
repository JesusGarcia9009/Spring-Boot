package com.pdr.session.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pdr.common.session.security.dto.UserPrincipal;
import com.pdr.session.dto.ApplicationDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * MenuUserController
 * 
 * Servicio encargado de obtener los menus asociados a los roles de caga usuario
 * 
 * @author Nelson Alvarado
 */
public interface MenuUserController {
	
	
	/**
	 * Metodo encargado de llamar el menu principal a travez del token creado por el usuario principal
	 * 
	 * @param dto ApplicationDTO 
	 * @return
	 */
	@ApiOperation(value = "obtenerMenuPrincipal", notes = "Retorna las url asociadas al rol del usuario")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorno satisfactorio")
    })
	public ResponseEntity<List<ApplicationDTO>> menuLanding(UserPrincipal userToken) throws Exception;
	
	
	

}
