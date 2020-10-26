package com.pdr.cobranza.cliente.controller.mock;

import java.util.ArrayList;
import java.util.List;

import com.ms.cliente.dto.CbzTipoDocumentoResponseDTO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class TipoDireccionMock {

	public static List<CbzTipoDocumentoResponseDTO> tipoDocumentoMock() {
		log.info("[tipoDocumentoMock]:: inicio del documento");
		List<CbzTipoDocumentoResponseDTO> result = new ArrayList<CbzTipoDocumentoResponseDTO>();

		CbzTipoDocumentoResponseDTO dto = new CbzTipoDocumentoResponseDTO();

		dto.setIdTipoDireccion(1L);
		dto.setTipoDirDescripcion("Particular");
		dto.setTipoDirTrio("PART");

		result.add(dto);

		dto = new CbzTipoDocumentoResponseDTO();
		dto.setIdTipoDireccion(2L);
		dto.setTipoDirDescripcion("Comercial");
		dto.setTipoDirTrio("COME");
		result.add(dto);

		dto = new CbzTipoDocumentoResponseDTO();
		dto.setIdTipoDireccion(3L);
		dto.setTipoDirDescripcion("contacto");
		dto.setTipoDirTrio("CONT");
		result.add(dto);
		log.info("[tipoDocumentoMock]:: fin del documento");
		return result;
	}

}
