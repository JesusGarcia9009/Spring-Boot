package com.pdr.cobranza.cliente.controller.mock;

import java.util.ArrayList;
import java.util.List;

import com.ms.cliente.dto.GenRegionesResponseDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegionesMock {
	
	
	public static List<GenRegionesResponseDTO> regionesMock(){
		log.info("[RegionesMock]:: inico del metodo");
		List<GenRegionesResponseDTO> response = new ArrayList<GenRegionesResponseDTO>();

		response.add(new GenRegionesResponseDTO(1, "comuna", "comuna"));
		response.add(new GenRegionesResponseDTO(1, "comuna", "comuna"));
		response.add(new GenRegionesResponseDTO(1, "comuna", "comuna"));
		
		
		log.info("[RegionesMock]:: fin del metodo");
		return response;
	}

}
