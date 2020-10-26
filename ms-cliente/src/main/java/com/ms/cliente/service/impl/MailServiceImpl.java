package com.ms.cliente.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.cliente.dto.DemograficDataRequest;
import com.ms.cliente.dto.GenMailDTO;
import com.ms.cliente.dto.RatificarMailRequest;
import com.ms.cliente.repository.GenMailRepository;
import com.ms.cliente.repository.GenPersonaRepository;
import com.ms.cliente.service.MailService;
import com.ms.cliente.utils.ConstantesUtil;
import com.ms.cliente.utils.NotNullOrEmptyUtil;
import com.pdr.common.cobranza.entity.GenMailIdModel;
import com.pdr.common.cobranza.entity.GenMailModel;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private GenMailRepository genMailRepository;
	
	@Autowired
	private GenPersonaRepository genPersonaRepository;
	
	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public boolean ratificarMail(RatificarMailRequest dataRatificacion) {
		boolean result = false;
		if (NotNullOrEmptyUtil.isEmptyIdMail(dataRatificacion)) {
			return result;
		} else {
			GenMailIdModel identificador = new GenMailIdModel();
			identificador.setPersTipoId(dataRatificacion.getPersTipoId());
			identificador.setPersId(dataRatificacion.getPersId());
			identificador.setTipoDocto(ConstantesUtil.TIPO_DOCTO);
			identificador.setNumDocto(dataRatificacion.getNumDocto());
			Optional<GenMailModel> optionalMailModel = genMailRepository.findById(identificador);
			if (optionalMailModel.isPresent()) {
				GenMailModel model = optionalMailModel.get();
				model.setMailEmail(dataRatificacion.getMail());
				model.setMailUserMod(dataRatificacion.getUsuario());
				Calendar calendario = Calendar.getInstance(new Locale("CLT"));
				model.setMailFecMod(calendario.getTime());
				genMailRepository.save(model);
				result = true;
			}else{
				GenMailModel model = new GenMailModel();
				model.setGenPersonas(genPersonaRepository.findByPersId(dataRatificacion.getPersId()));
				model.setId(identificador);
				model.setMailEmail(dataRatificacion.getMail());
				model.setMailUserMod(dataRatificacion.getUsuario());
				Calendar calendario = Calendar.getInstance(new Locale("CLT"));
				model.setMailFecMod(calendario.getTime());
				genMailRepository.save(model);
				result = true;
			}
		}
		return result;
	}
	
	public List<GenMailDTO> buscarMails(DemograficDataRequest genMailRequest){
		List<GenMailModel> listado = genMailRepository.buscarMails(genMailRequest.getPersId(), genMailRequest.getNumDocto());
		return transform(listado);
	}
	
	private List<GenMailDTO> transform(List<GenMailModel> listado){
		List<GenMailDTO> result = new ArrayList<>();
		for (GenMailModel genMailModel : listado) {
			result.add(mapper.map(genMailModel, GenMailDTO.class));
		}
		return result;
	}

}
