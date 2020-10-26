package com.ms.cliente.service.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.cliente.dto.DatosClienteResponseDTO;
import com.ms.cliente.dto.GenDireccionesResponse;
import com.ms.cliente.dto.GenMailDTO;
import com.ms.cliente.dto.GenPersonaIdRequest;
import com.ms.cliente.dto.GenPersonasDTO;
import com.ms.cliente.dto.GenTelefonoResponse;
import com.ms.cliente.dto.V360ClienteRequestDTO;
import com.ms.cliente.dto.V360ClienteResponseDTO;
import com.ms.cliente.repository.AtcParametrosRepository;
import com.ms.cliente.repository.GenDireccionesRepository;
import com.ms.cliente.repository.GenMailRepository;
import com.ms.cliente.repository.GenPersonaRepository;
import com.ms.cliente.repository.GenTelefonosRepository;
import com.ms.cliente.service.ClienteService;
import com.pdr.common.cobranza.entity.AtcParametrosModel;
import com.pdr.common.cobranza.entity.GenMailModel;
import com.pdr.common.cobranza.entity.GenPersonasIdModel;
import com.pdr.common.cobranza.entity.GenPersonasModel;
import com.pdr.common.cobranza.entity.GenTelefonosModel;
import com.pdr.common.utils.TransFormObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private GenPersonaRepository personaRepository;

	@Autowired
	private AtcParametrosRepository atcParametrosRepository;

	@Autowired
	private GenTelefonosRepository genTelefonosRepository;

	@Autowired
	private GenDireccionesRepository direccionesRepository;

	@Autowired
	private GenMailRepository genMailRepository;

	@Autowired
	private DozerBeanMapper mapper;

	@Autowired
	private TransFormObject transform;

	@Override
	public GenPersonasDTO buscarCliente(GenPersonaIdRequest cliente) {

		GenPersonasDTO dto;
		GenPersonasIdModel model = new GenPersonasIdModel();
		model.setPersTipoId(cliente.getPersTipoId());
		model.setPersId(cliente.getPersId());
		Optional<GenPersonasModel> optionalPersona = personaRepository.findById(model);
		dto = optionalPersona.isPresent() ? mapper.map(optionalPersona.get(), GenPersonasDTO.class) : null;
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	public List<V360ClienteResponseDTO> getListCliente(String buscador) {
		log.info("[getListCliente]::inicio de servicio que busca los clientes");

		List<V360ClienteResponseDTO> response = personaRepository.buscarClientesPersID(buscador);

		if (response.isEmpty()) {
			List<String> listBusqueda = Arrays.asList(buscador.split(" "));

			if (listBusqueda.size() > 1) {
				response = personaRepository.buscarClientesNombre("%" + listBusqueda.get(0).toLowerCase() + "%",
						"%" + listBusqueda.get(1).toLowerCase() + "%");
			} else {
				response = personaRepository.buscarClientesNombre("%" + buscador.toLowerCase() + "%");
			}

		}
		return response;

	}

	@Override
	public V360ClienteResponseDTO getListClienteFolio(V360ClienteRequestDTO folio) {
		return personaRepository.buscarClientesFolio(folio.getSerieCod(), folio.getDoctoFolio());
	}

	@Override
	public boolean validaClienteDesactualizado(String persID) {

		Integer diasMaximos = 0;
		Integer difTrans = 0;
		List<Object> dif = null;
		Optional<AtcParametrosModel> param = atcParametrosRepository
				.findById("ATC_MAX_DIAS_SIN_ACTUALIZACION_TELEFONO");

		if (param.isPresent()) {
			diasMaximos = Integer.valueOf(param.get().getParaValor());
			dif = genTelefonosRepository.datosClienteDesactualizado(persID);

			if (!dif.isEmpty()) {
				difTrans = ((BigDecimal) dif.get(0)).intValue();
			}

		}
		return (difTrans > diasMaximos) ? Boolean.TRUE : Boolean.FALSE;

	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {

		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	@Override
	public DatosClienteResponseDTO datosCliente(String persid, String numDocto) {
		log.info("[datosCliente]::inicio de servicio que busca la informacion del cliente");
		log.debug("[datosCliente]::persid-->" + persid);
		DatosClienteResponseDTO dto = new DatosClienteResponseDTO();
		GenPersonasModel pers = personaRepository.findByPersId(persid);
		
		if (pers != null) {
			BigDecimal numDoctoBigDecimal = new BigDecimal(numDocto);
			List<GenDireccionesResponse> listDirecciones = direccionesRepository.buscarDireccionesXPersId(persid,numDoctoBigDecimal);
			List<GenTelefonosModel> listaTelefonos = genTelefonosRepository.getTelefonosCliente(persid);
			List<GenMailModel> listaMail = genMailRepository.buscarMails(persid);
			
			dto.setCliente(transform.mapClass(pers, GenPersonasDTO.class));
			dto.setDirecciones(listDirecciones);
			dto.setTelefonos(transform.mapList(listaTelefonos, GenTelefonoResponse.class));
			dto.setEmails(transform.mapList(listaMail, GenMailDTO.class));
		} else {
			dto = null;
		}
		
		log.info("[datosCliente]::fin de servicio que busca la informacion del cliente");
		log.debug("[datosCliente]::result-->" + dto.toString());
		return dto;
	}

}
