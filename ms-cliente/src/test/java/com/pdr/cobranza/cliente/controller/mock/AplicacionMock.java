package com.pdr.cobranza.cliente.controller.mock;

import java.util.ArrayList;
import java.util.List;

import com.ms.cliente.dto.AplicacionesDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AplicacionMock {

	public static List<AplicacionesDTO> mockAplicacion() {
		log.info("[mockAplicacion]:: creamos un mock de dto.Aplicacion");
		List<AplicacionesDTO> listado = new ArrayList<>();
		AplicacionesDTO dto = new AplicacionesDTO(1l, "URL", "App1", "App1", "icon", "color");
		listado.add(dto);
		log.info("[mockPersona]:: fin");
		return listado;
	}

	

}
