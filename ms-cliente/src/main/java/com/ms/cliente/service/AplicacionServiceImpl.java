package com.ms.cliente.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.common.entity.AplicacionModel;
import com.ms.cliente.dto.AplicacionesDTO;
import com.ms.cliente.repository.AplicacionRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AplicacionServiceImpl implements AplicacionService {

	@Autowired
	private AplicacionRepository aplicacionRepository;
	
	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public List<AplicacionesDTO> obtenerAplicaciones() {
		log.info("[obtenerAplicaciones]::inicio de servicio");
		List<AplicacionesDTO> resultado = new ArrayList<>();
		List<AplicacionModel> listado = aplicacionRepository.findAll();
		for (AplicacionModel aplicacionModel : listado) {
			resultado.add(mapper.map(aplicacionModel, AplicacionesDTO.class));
		}
		log.info("[obtenerAplicaciones]::fin de servicio");
		return resultado;
	}

}
