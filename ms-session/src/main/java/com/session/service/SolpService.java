package com.session.service;

import com.pdr.common.dto.solp.UserInfoDTO;
import com.pdr.common.exception.UserNotAuthException;
import com.session.dto.UserAuthRequestDTO;


/**
 * @author BS2
 */
public interface SolpService {

	
	/**
	 * Obtiene los datos del solp
	 * 
	 * @param dto
	 * @return
	 */
	public UserInfoDTO getSolp (UserAuthRequestDTO request) throws UserNotAuthException; 
	
	
	/**
	 * Obtiene los datos del landing page
	 * 
	 * @param dto
	 * @return
	 */
	public UserInfoDTO getLanding(String token) throws UserNotAuthException;
}
