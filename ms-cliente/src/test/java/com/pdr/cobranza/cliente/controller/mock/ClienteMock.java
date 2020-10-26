package com.pdr.cobranza.cliente.controller.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pdr.cobranza.cliente.dto.DatosClienteResponseDTO;
import com.pdr.cobranza.cliente.dto.GenDireccionesResponse;
import com.pdr.cobranza.cliente.dto.GenMailDTO;
import com.pdr.cobranza.cliente.dto.GenPersonasDTO;
import com.pdr.cobranza.cliente.dto.GenTelefonoResponse;
import com.pdr.cobranza.cliente.dto.V360ClienteResponseDTO;
import com.pdr.common.cobranza.entity.GenPersonasIdModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClienteMock {

	public static GenPersonasDTO mockPersona() {
		log.info("[mockPersona]:: creamos un mock de dto.setPersona");
		GenPersonasDTO dto = new GenPersonasDTO();
		GenPersonasIdModel id = new GenPersonasIdModel();
		id.setPersId("7296795");
		id.setPersTipoId("RUT");
		dto.setId(id);
		dto.setPersApeMat("SANHUESA");
		dto.setPersDigVer(" K");
		dto.setPersApePat(" SANHUEZA");
		dto.setPersApeMat(" NECOCHEA");
		dto.setPersNombres(" VERONICA EDITH");
		dto.setPersRazonSocial(" null");
		dto.setPersNomFantasia(" null");
		dto.setPersNivelEduc(" null");
		dto.setPersFecNac(null);
		dto.setPersFecDefun(null);
		dto.setPersEdadDefun(" null");
		dto.setPersEstCivil(" null");
		dto.setPersNaci(" CHILENO");
		dto.setPersSexo(" F");
		dto.setPersTipo(" NAT");
		dto.setPersGiro(" null");
		dto.setPersUserMod(" MIGRACION");
		dto.setPersFecMod(new Date());
		log.info("[mockPersona]:: fin");
		log.debug("[mockPersona]:: return-->" + dto.toString());
		return dto;
	}

	public static List<V360ClienteResponseDTO> MockClientesV360() {

		log.info("[MockPersonas]:: creamos un mock de dto.setPersona");
		List<V360ClienteResponseDTO> responseList = new ArrayList<V360ClienteResponseDTO>();
		V360ClienteResponseDTO dto = new V360ClienteResponseDTO();

		dto.setPersTipoId("729K6795");
		dto.setPersId("RUT");
		dto.setPersDigVer("K");
		dto.setPersApePat("ALVARADO");
		dto.setPersApeMat("VIDA");
		dto.setPersNombres("NELSON");
		dto.setPersRazonSocial("PUTAZO");
		dto.setPersNomFantasia("GERMAN ZATULA");
		dto.setPersNivelEduc("UNIVERSITARIO DE UNIVERSIDAD DE ROCCO");
		dto.setPersFecNac(new Date());
		dto.setPersFecDefun(new Date());
		dto.setPersEdadDefun("666");
		dto.setPersEstCivil("soltero");
		dto.setPersNaci("");
		dto.setPersSexo("Macho pichulon");
		dto.setPersTipo("");
		dto.setPersGiro("puto");
		dto.setPersUserMod("albertirijillo");
		dto.setPersFecMod(new Date());
		responseList.add(dto);
		responseList.add(dto);
		responseList.add(dto);

		log.debug("[MockPersonas]:: return-->" + dto.toString());

		return responseList;

	}

	public static V360ClienteResponseDTO MockClienteV360() {

		log.info("[MockClienteV360]:: creamos un mock de dto.setPersona");
		V360ClienteResponseDTO dto = new V360ClienteResponseDTO();

		dto.setPersTipoId("729K6795");
		dto.setPersId("RUT");
		dto.setPersDigVer("K");
		dto.setPersApePat("ALVARADO");
		dto.setPersApeMat("VIDA");
		dto.setPersNombres("NELSON");
		dto.setPersRazonSocial("PUTAZO");
		dto.setPersNomFantasia("GERMAN ZATULA");
		dto.setPersNivelEduc("UNIVERSITARIO DE UNIVERSIDAD DE ROCCO");
		dto.setPersFecNac(new Date());
		dto.setPersFecDefun(new Date());
		dto.setPersEdadDefun("666");
		dto.setPersEstCivil("soltero");
		dto.setPersNaci("");
		dto.setPersSexo("Macho pichulon");
		dto.setPersTipo("");
		dto.setPersGiro("puto");
		dto.setPersUserMod("albertirijillo");
		dto.setPersFecMod(new Date());

		log.debug("[MockPersonas]:: return-->" + dto.toString());

		return dto;

	}

	public static DatosClienteResponseDTO MockCliente() {

		log.info("[MockClienteV360]:: creamos un mock de dto.setPersona");
		DatosClienteResponseDTO dto = new DatosClienteResponseDTO();

		GenPersonasIdModel id = new GenPersonasIdModel();
		id.setPersId("7296795");
		id.setPersTipoId("RUT");
		GenPersonasDTO personas = new GenPersonasDTO();
		personas.setId(id);
		personas.setPersApeMat("SANHUESA");
		personas.setPersDigVer(" K");
		personas.setPersApePat(" SANHUEZA");
		personas.setPersApeMat(" NECOCHEA");
		personas.setPersNombres(" VERONICA EDITH");
		personas.setPersRazonSocial(" null");
		personas.setPersNomFantasia(" null");
		personas.setPersNivelEduc(" null");
		personas.setPersFecNac(null);
		personas.setPersFecDefun(null);
		personas.setPersEdadDefun(" null");
		personas.setPersEstCivil(" null");
		personas.setPersNaci(" CHILENO");
		personas.setPersSexo(" F");
		personas.setPersTipo(" NAT");
		personas.setPersGiro(" null");
		personas.setPersUserMod(" MIGRACION");
		personas.setPersFecMod(new Date());
		GenDireccionesResponse direccion = new GenDireccionesResponse();
		direccion.setDireSec(new BigDecimal(123));
		direccion.setDireTipo("Direccion 1 ");
		direccion.setDireCalle("Calle 1");
		direccion.setDireNumero("234");
		direccion.setDireRestoDire("Direccion 1 calle 1");
		direccion.setDireCodPostal("98072222");
		direccion.setDireNac("Direc");
		direccion.setDirePais("Chile");
		direccion.setDireEstaCod("CH02");
		direccion.setDireIndVerif("CH03");
		direccion.setDireFecVerif(new Date());
		direccion.setSoscSec(new BigDecimal(234));
		direccion.setContNumOpe(new BigDecimal(234));
		direccion.setReinSec(new BigDecimal(234));
		direccion.setDireUserMod("userMod");
		direccion.setDireFecMod(new Date());
		direccion.setTipoDocto("L");
		direccion.setNumDocto(new BigDecimal(234));
		direccion.setDireIndEnvCorr("Calle Falsa 123");
		GenTelefonoResponse telefono = new GenTelefonoResponse();
		telefono.setFonoTipo("CELULAR");
		telefono.setFonoNumero("09-9325465");
		GenMailDTO mail = new GenMailDTO();
		mail.setMailEmail("juan.alvarado@gmail.com");

		log.debug("[MockPersonas]:: return-->" + dto.toString());

		return dto;

	}

}
