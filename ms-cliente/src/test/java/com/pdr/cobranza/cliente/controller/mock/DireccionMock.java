package com.pdr.cobranza.cliente.controller.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pdr.cobranza.cliente.dto.GenDireccionesResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DireccionMock {

	public static List<GenDireccionesResponse> mockDirecciones() {
		log.info("[mockDirecciones]:inicio de mock");

		List<GenDireccionesResponse> response = new ArrayList<GenDireccionesResponse>();
		GenDireccionesResponse dto = new GenDireccionesResponse();
		dto.setDireSec(new BigDecimal(3541986));
		dto.setDireTipo("COME");
		dto.setDireCalle("Puntiagudo");
		dto.setDireNumero("5633");
		dto.setDireRestoDire(null);
		dto.setDireCodPostal("null");
		dto.setDireNac("N");
		dto.setDirePais("null");
		dto.setDireEstaCod("CONFIRMADO");
		dto.setDireIndVerif("SI");
		dto.setDireFecVerif(new Date());
		dto.setSoscSec(null);
		dto.setContNumOpe(null);
		dto.setReinSec(null);
		dto.setDireUserMod("PORTAL CLIENTE");
		dto.setDireFecMod(new Date());
		dto.setTipoDocto("VTA_CONT");
		dto.setNumDocto(new BigDecimal(280456) );
		dto.setDireIndEnvCorr("NO");
		dto.setComuDesc("CONCHALI");

		response.add(dto);
		response.add(dto);
		response.add(dto);
		response.add(dto);
		log.info("[mockDirecciones]:fin de mock");
		return response;

	}

}
