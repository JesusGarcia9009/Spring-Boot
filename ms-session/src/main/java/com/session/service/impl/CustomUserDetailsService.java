package com.session.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pdr.common.dto.solp.UserInfoDTO;
import com.pdr.common.exception.UserNotAuthException;
import com.pdr.common.session.entity.ProfileModel;
import com.pdr.common.session.entity.UsersModel;
import com.pdr.common.session.security.dto.RolDTO;
import com.pdr.common.session.security.dto.UserPrincipal;
import com.session.dto.UserAuthRequestDTO;
import com.session.repository.ProfileRepository;
import com.session.service.SolpService;
import com.session.service.UsersService;
import com.session.utils.ConstantesUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @author BS2. CustomUserDetailsService.java
 */
@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersService usersService;

	@Autowired
	private ProfileRepository profile;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private SolpService solpService;

	@Override
	public UserPrincipal loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		log.info("[loadUserByUsername]::inicio de metodo");
		UsersModel usuarioDTO = null;
		String[] usernameAndPass = StringUtils.split(usernameOrEmail, String.valueOf(ConstantesUtil.SEPARATOR));
		try {
			if (usersService.countUserByNameOrRut(usernameAndPass[0]) > 0) {
				usuarioDTO = usersService.buscarUserByNameOrRut(usernameAndPass[0]);
				
				log.info("[loadUserByUsername]::fin de metodo");
				return createUserPrincipal(usuarioDTO, usernameAndPass[0], usernameAndPass[1]);
			}else {
				throw new UserNotAuthException(usernameOrEmail);
			}
		} catch (UserNotAuthException e) {
			log.error("Error en loadUserByUsername", e);
		} catch (Exception e) {
			log.error("Error en createUserPrincipal", e);
		}
		log.info("[loadUserByUsername]::fin de metodo");
		return new UserPrincipal();
	}

	/**
	 * Genera el Usuario a guardar en el token con toda su informacion y permisos
	 * asociados
	 * 
	 * @param usuarioDTO
	 * @return
	 */
	private UserPrincipal createUserPrincipal(UsersModel usuarioDTO, String user, String password) throws Exception {
		log.info("[createUserPrincipal]::inicio de metodo");
		UserPrincipal userPrincipal = new UserPrincipal();

		userPrincipal.setIdUsuario(usuarioDTO.getIdUser().longValue());
		userPrincipal.setDscEmail(usuarioDTO.getEmail());
		userPrincipal.setFullName(usuarioDTO.getFullName());
		userPrincipal.setDscEmail(usuarioDTO.getEmail());
		userPrincipal.setUsername(usuarioDTO.getUsername());
		userPrincipal.setRut(usuarioDTO.getRut());
		userPrincipal.setUserInput(user);
		userPrincipal.setPassword(passwordEncoder.encode(password));

		List<RolDTO> rolList = getRolList(usuarioDTO.getUsername());
		userPrincipal.setListRoles(rolList);

		if (!rolList.isEmpty()) {
			List<GrantedAuthority> authorities = rolList.stream()
					.map(permiso -> new SimpleGrantedAuthority(permiso.getDscRol())).collect(Collectors.toList());
			userPrincipal.setAuthorities(authorities);
		}

		UserInfoDTO temp = solpService.getSolp(getUserAuthRequestDTO(user, password));
		if (temp != null) {
			userPrincipal.setToken(temp.getToken());
		} else {
			log.error("Error en createUserPrincipal, No se obtuvo respuesta de SOLP");
			throw new UserNotAuthException(user);
		}
		log.info("[createUserPrincipal]::fin de metodo");
		return userPrincipal;
	}

	private List<RolDTO> getRolList(String userName) {
		log.info("[getRolList]::inicio de metodo");
		List<RolDTO> rolList = new ArrayList<>();
		// Roles
		List<ProfileModel> listRoles = profile.findbyUsername(userName);
		for (ProfileModel rol : listRoles) {
			RolDTO r = new RolDTO();
			r.setIdRol(rol.getIdProfile().longValue());
			r.setDscRol(rol.getName());
			rolList.add(r);
		}
		log.info("[getRolList]::fin de metodo");
		return rolList;
	}

	private UserAuthRequestDTO getUserAuthRequestDTO(String username, String password) {
		UserAuthRequestDTO request = new UserAuthRequestDTO();
		request.setPassword(password);
		request.setUsername(username);
		return request;
	}

}