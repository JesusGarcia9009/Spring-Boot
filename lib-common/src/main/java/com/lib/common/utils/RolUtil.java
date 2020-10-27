package com.lib.common.utils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lib.common.dto.RolDTO;
import com.lib.common.entity.PerfilModel;
import com.lib.common.repository.PerfilRepository;

@Component
public class RolUtil {

	@SuppressWarnings("unused")
	private static PerfilRepository perfilRepository;
	
	@Autowired
	private PerfilRepository perfil;

	@PostConstruct
	public void init() {
		RolUtil.perfilRepository = perfil;
	}

	/**
	 * 
	 * @param listRoles
	 * @param rolBottom
	 * @return
	 */
	public static Boolean permiteActualizarSimulacion(List<RolDTO> listRoles, List<Integer> autorizaList) {

		Boolean result = Boolean.FALSE;
		for (RolDTO rol : listRoles) {
			for (int autoriza : autorizaList)
				if (autoriza == rol.getIdRol().intValue()) {
					return Boolean.TRUE;

				}
		}

		return result;

	}

	public static List<PerfilModel> getAllRoles() {
		return perfilRepository.findAll();
	}

	public static String getRolDeList(List<PerfilModel> roles, String name) {
		List<PerfilModel> listRol = roles.stream().filter(rol -> rol.getNombre().trim().equalsIgnoreCase(name.strip()))
				.collect(Collectors.toList());
		return (listRol != null) ? listRol.get(0).getIdPerfil().toString() : "0";
	}
	
	
	public static List<BigDecimal> getListRolId(List<RolDTO> rol){
		return rol.stream().map( x -> new BigDecimal (x.getIdRol()) ).collect(Collectors.toList());
	}

}
