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

import com.pdr.cobranza.cliente.dto.DemograficDataRequest;
import com.pdr.cobranza.cliente.dto.GenTelefonoDTO;
import com.pdr.cobranza.cliente.dto.GenTelefonoResponse;
import com.pdr.cobranza.cliente.dto.RatificarDatosRequest;
import com.pdr.cobranza.cliente.repository.GenPersonaRepository;
import com.pdr.cobranza.cliente.repository.GenTelefonosRepository;
import com.pdr.cobranza.cliente.service.TelefonoService;
import com.pdr.cobranza.cliente.utils.ConstantesUtil;
import com.pdr.common.cobranza.entity.GenPersonasIdModel;
import com.pdr.common.cobranza.entity.GenPersonasModel;
import com.pdr.common.cobranza.entity.GenTelefonosModel;
import com.pdr.common.exception.InsertOrUpdateException;

@Service
public class TelefonoServiceImpl implements TelefonoService {

	@Autowired
	private GenTelefonosRepository genTelefonosRepository;
	
	@Autowired
	private GenPersonaRepository genPersonaRepository;
	
	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public boolean ratificarTelefono(RatificarDatosRequest dataRatificacion) {
		BigDecimal idRatificar = new BigDecimal(dataRatificacion.getIdDatoRatificacion());
		boolean result = false;
		if (dataRatificacion.getIdDatoRatificacion() == null) {
			return result;
		} else {
			Optional<GenTelefonosModel> optionalTelefonoModel = genTelefonosRepository.findById(idRatificar);
			if (optionalTelefonoModel.isPresent()) {
				GenTelefonosModel model = optionalTelefonoModel.get();
				model.setFonoUserMod(dataRatificacion.getUsuario());
				Calendar calendario = Calendar.getInstance(new Locale("CLT"));
				model.setFonoFecMod(calendario.getTime());
				genTelefonosRepository.save(model);
				result = true;
			}
		}
		return result;
	}
	
	@Override
	public List<GenTelefonoResponse> buscarTelefonos(DemograficDataRequest genTelefonoRequest){
		List<GenTelefonosModel> listado = genTelefonosRepository.buscarTelefonos(genTelefonoRequest.getPersId(), genTelefonoRequest.getNumDocto());
		return transform(listado);
	}
	
	
	
	public boolean insertTelefono(GenTelefonoDTO genTelefono) throws InsertOrUpdateException{
		boolean result = false;
		if (genTelefono == null) {
			return result;
		} else {
			GenTelefonosModel model = mapper.map( genTelefono,  GenTelefonosModel.class);
			try {
				GenPersonasIdModel id = new GenPersonasIdModel();
				id.setPersId(genTelefono.getPersId());
				id.setPersTipoId(genTelefono.getPersTipoId());
				Optional<GenPersonasModel> personaModel = genPersonaRepository.findById(id);
				model.setGenPersonas(personaModel.isPresent() ? personaModel.get() : null);
				
				model.setFonoArea(null);
				model.setSoscSec(null);
				model.setTipoDocto(ConstantesUtil.TIPO_DOCTO);
				model.setNumDocto(genTelefono.getNumDocto());
				model.setFonoIndCelu(ConstantesUtil.FONO_IND_CELU);
				Calendar calendario = Calendar.getInstance(new Locale("CLT"));
				model.setFonoFecMod(calendario.getTime());
				model.setFonoNumeroResp(null);

				genTelefonosRepository.save(model);
				result = true;
			} catch (Exception e) {
				throw InsertOrUpdateException.createWith("Services:: insertTelefono");
			}
		}
		return result;
	}
	
	private List<GenTelefonoResponse> transform(List<GenTelefonosModel> listado){
		List<GenTelefonoResponse> result = new ArrayList<>();
		for (GenTelefonosModel genTelefonoModel : listado) {
			GenTelefonoResponse temp = mapper.map(genTelefonoModel, GenTelefonoResponse.class);
			temp.setIdPersona(genTelefonoModel.getGenPersonas().getId());
			result.add(temp);
		}
		return result;
	}

}
