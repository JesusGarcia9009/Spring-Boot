package com.pdr.cobranza.cliente.controller.mock;

import java.util.ArrayList;
import java.util.List;

import com.ms.cliente.dto.GenTelefonoResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelefonoMock {
	
	
	public static List<GenTelefonoResponse> telefonoMock(){
		log.info("[telefonoMock]:: inicio del metodo");
		List<GenTelefonoResponse> response = new ArrayList<GenTelefonoResponse>();
		
		GenTelefonoResponse dto = new GenTelefonoResponse();
		
		dto.setFonoArea("22");
		dto.setFonoNumeroResp("3232");
		dto.setFonoUserMod("nalvarado");
		dto.setIdPersona(null);
		
		response.add(dto);
		response.add(dto);
		response.add(dto);
		
		log.info("[telefonoMock]:: fin del metodo");
		return response;
		
	}

}
