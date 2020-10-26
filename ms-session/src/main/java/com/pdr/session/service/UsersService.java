package com.pdr.session.service;

import java.math.BigDecimal;

import com.pdr.common.session.entity.UsersModel;


/**
 * @author BS2
 */
public interface UsersService {

	
	/**
	 * Obtiene el Dto de lo usuarios
	 * 
	 * @param dto
	 * @return
	 */
	public UsersModel buscarUsers(BigDecimal id); 
	
	/**
	 * Obtiene el el modelo by username o rut
	 * 
	 * @param string userNameOrRut
	 * @return model @see UsersModel
	 */
	public UsersModel buscarUserByNameOrRut(String userNameOrRut); 
	
	/**
	 * Cuenta que exista el usuario por rut o urname
	 * 
	 * @param string userNameOrRut
	 * @return model @see UsersModel
	 */
	public Long countUserByNameOrRut(String userNameOrRut) ;
}
