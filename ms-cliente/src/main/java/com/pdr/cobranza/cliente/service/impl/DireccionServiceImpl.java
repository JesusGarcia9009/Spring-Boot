package com.pdr.cobranza.cliente.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdr.cobranza.cliente.dto.GenDireccionesDTO;
import com.pdr.cobranza.cliente.dto.GenDireccionesResponse;
import com.pdr.cobranza.cliente.dto.RatificarDatosRequest;
import com.pdr.cobranza.cliente.repository.GenComunasRepository;
import com.pdr.cobranza.cliente.repository.GenDireccionesRepository;
import com.pdr.cobranza.cliente.repository.GenPersonaRepository;
import com.pdr.cobranza.cliente.service.DireccionService;
import com.pdr.cobranza.cliente.utils.ConstantesUtil;
import com.pdr.common.cobranza.entity.GenDireccionesModel;
import com.pdr.common.exception.InsertOrUpdateException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DireccionServiceImpl implements DireccionService {

	@Autowired
	private GenDireccionesRepository genDireccionesRepository;

	@Autowired
	private GenComunasRepository genComunasRepository;

	@Autowired
	private GenPersonaRepository genPersonaRepository;

	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public boolean ratificarDireccion(RatificarDatosRequest dataRatificacion) {
		
		BigDecimal idRatificar = new  BigDecimal(dataRatificacion.getIdDatoRatificacion());
		boolean result = false;
		if (dataRatificacion.getIdDatoRatificacion() == null) {
			return result;
		} else {
			Optional<GenDireccionesModel> optionalDireccionModel = genDireccionesRepository.findById(idRatificar);
			if (optionalDireccionModel.isPresent()) {
				GenDireccionesModel model = optionalDireccionModel.get();
				model.setDireUserMod(dataRatificacion.getUsuario());
				Calendar calendario = Calendar.getInstance(new Locale("CLT"));
				model.setDireFecMod(calendario.getTime());
				genDireccionesRepository.save(model);
				result = true;
			}
		}
		return result;
	}

	public List<GenDireccionesResponse> buscarDirecciones(BigDecimal numDocto) {
		List<GenDireccionesModel> listado = genDireccionesRepository.buscarDireccion(numDocto);
		return transform(listado);
	}

	private List<GenDireccionesResponse> transform(List<GenDireccionesModel> listado) {
		List<GenDireccionesResponse> result = new ArrayList<>();
		for (GenDireccionesModel genDireccionesModel : listado) {
			GenDireccionesResponse dto = mapper.map(genDireccionesModel, GenDireccionesResponse.class);
			dto.setComuDesc(new StringBuilder(genDireccionesModel.getGenComunas().getComuCod()).toString());
			result.add(dto);
		}
		return result;
	}

	public boolean insertDireccion(GenDireccionesDTO genDireccion) throws InsertOrUpdateException {
		boolean result = false;
		if (genDireccion == null) {
			return result;
		} else {
			GenDireccionesModel model = mapper.map(genDireccion, GenDireccionesModel.class);
			try {
				log.info("Empieza comuna buscar comuna");
				model.setGenComunas(genComunasRepository.findByCod(genDireccion.getComuCod()));
				log.info("termina comuna y empieza persona");
				model.setGenPersonas(genPersonaRepository.findByPersId(genDireccion.getPersId()));
				log.info("termina persona");
				
				model.setDireCodPostal(null);
				model.setDireNac(ConstantesUtil.DIRE_NAC);
				model.setDirePais(ConstantesUtil.DIRE_PAIS);
				model.setDireEstaCod(ConstantesUtil.DIRE_ESTADO_COD);
				model.setDireIndVerif(null);
				model.setDireFecVerif(null);
				model.setSoscSec(null);
				model.setContNumOpe(null);
				model.setReinSec(null);
				Calendar calendario = Calendar.getInstance(new Locale("CLT"));
				model.setDireFecMod(calendario.getTime());
				model.setDireIndEnvCorr(ConstantesUtil.DIRE_IND_ENV_CORR);
				model.setTipoDocto(ConstantesUtil.TIPO_DOCTO);

				genDireccionesRepository.save(model);
				result = true;
			} catch (Exception e) {
				throw InsertOrUpdateException.createWith("insertDireccion");
			}
		}
		return result;
	}

}