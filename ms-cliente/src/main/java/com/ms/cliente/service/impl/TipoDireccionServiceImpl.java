package com.ms.cliente.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.cliente.dto.CbzTipoDocumentoResponseDTO;
import com.ms.cliente.repository.CbzTipoDireccionRepository;
import com.ms.cliente.service.TipoDireccionService;
import com.pdr.common.cobranza.entity.CbzTipoDireccionModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TipoDireccionServiceImpl implements TipoDireccionService {

	@Autowired
	private CbzTipoDireccionRepository cbzTipoDireccionRepository;

	public List<CbzTipoDocumentoResponseDTO> getTipoDireccion() {
		log.info("[getTipoDocumento]::inicio de la busqueda de informacion");
		List<CbzTipoDocumentoResponseDTO> ret = new ArrayList<>();
		List<CbzTipoDireccionModel> model = cbzTipoDireccionRepository.findAll();

		for (CbzTipoDireccionModel dto : model) {

			CbzTipoDocumentoResponseDTO tipo = new CbzTipoDocumentoResponseDTO();
			tipo.setIdTipoDireccion(dto.getIdTipoDireccion());
			tipo.setTipoDirDescripcion(dto.getTipoDirDescripcion());
			tipo.setTipoDirTrio(dto.getTipoDirTrio());
			ret.add(tipo);
		}
		log.info("[getTipoDocumento]::fin de la busqueda de informacion");
		log.debug("[getTipoDocumento]::return->" + ret.toString());
		return ret;
	}

}
