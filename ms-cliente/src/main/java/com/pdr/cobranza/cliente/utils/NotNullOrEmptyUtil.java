/**
 * 
 */
package com.pdr.cobranza.cliente.utils;

import com.pdr.cobranza.cliente.dto.RatificarMailRequest;

/**
 * @author BS2
 *
 */
public class NotNullOrEmptyUtil {
	
	private NotNullOrEmptyUtil () {
		
	}
	
	public static boolean isEmptyIdMail(RatificarMailRequest dataRatificacion) {
		if((dataRatificacion.getPersTipoId() == null || dataRatificacion.getPersTipoId().isEmpty()) 
				|| (dataRatificacion.getPersId() == null || dataRatificacion.getPersId().isEmpty()) 
				|| (dataRatificacion.getTipoDocto() == null || dataRatificacion.getTipoDocto().isEmpty()) 
				|| (dataRatificacion.getNumDocto() == null))
			return true;
		else 
			return false;
	}

}
