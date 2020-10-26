package com.ms.cliente.service;

import java.util.List;

import com.ms.cliente.dto.DemograficDataRequest;
import com.ms.cliente.dto.GenMailDTO;
import com.ms.cliente.dto.RatificarMailRequest;

/**
 * @author BS2
 */
public interface MailService {

	/**
	 * Ratificar informacion de direccion de mail
	 */
	public boolean ratificarMail(RatificarMailRequest dataRatificacion);
	
	/**
	 * Buscar listado de Mails
	 */
	public List<GenMailDTO> buscarMails(DemograficDataRequest genMailRequest);
}
