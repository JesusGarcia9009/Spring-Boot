package com.pdr.cobranza.cliente.service;

import java.util.List;

import com.pdr.cobranza.cliente.dto.DemograficDataRequest;
import com.pdr.cobranza.cliente.dto.GenMailDTO;
import com.pdr.cobranza.cliente.dto.RatificarMailRequest;

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
