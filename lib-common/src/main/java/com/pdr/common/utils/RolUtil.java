package com.pdr.common.utils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pdr.common.session.entity.ProfileModel;
import com.pdr.common.session.repository.ProfileRepository;
import com.pdr.common.session.security.dto.RolDTO;

@Component
public class RolUtil {

	@SuppressWarnings("unused")
	private static ProfileRepository profileRepository;
	
	@Autowired
	private ProfileRepository profile;

	@PostConstruct
	public void init() {
		RolUtil.profileRepository = profile;
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

	public static List<ProfileModel> getAllRoles() {
		return RolUtil.profileRepository.findAll();
	}

	public static String getRolDeList(List<ProfileModel> roles, String name) {
		List<ProfileModel> listRol = roles.stream().filter(rol -> rol.getName().trim().equalsIgnoreCase(name.strip()))
				.collect(Collectors.toList());
		return (listRol != null) ? listRol.get(0).getIdProfile().toString() : "0";
	}
	
	
	public static List<BigDecimal> getListRolId(List<RolDTO> rol){
		return rol.stream().map( x -> new BigDecimal (x.getIdRol()) ).collect(Collectors.toList());
	}

}
