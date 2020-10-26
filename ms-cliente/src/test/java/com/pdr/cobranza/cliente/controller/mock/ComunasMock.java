package com.pdr.cobranza.cliente.controller.mock;

import java.util.ArrayList;
import java.util.List;

import com.pdr.cobranza.cliente.dto.GenComunasResponseDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ComunasMock {
	
	
	public static List<GenComunasResponseDTO> mockComunas(){
		log.info("[mockComunas]:: inicio");
		List<GenComunasResponseDTO> response = new  ArrayList<GenComunasResponseDTO>();
		GenComunasResponseDTO dto = new GenComunasResponseDTO();
		dto.setCiudCod("ALGARROBO");
		dto.setComuCod("San Antonio");
		dto.setComuDesc("Algarrobo");
		dto.setRegiCod(5);
		
		response.add(dto);
		response.add(dto);
		response.add(dto);
		response.add(dto);
		log.info("[mockComunas]:: fin");
		return response;
	}

}
