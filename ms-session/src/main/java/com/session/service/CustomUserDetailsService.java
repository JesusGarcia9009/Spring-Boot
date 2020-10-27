package com.session.service;

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

import com.lib.common.dto.RolDTO;
import com.lib.common.dto.UserPrincipal;
import com.lib.common.entity.PerfilModel;
import com.lib.common.entity.UsuarioModel;
import com.lib.common.exception.UserNotAuthException;
import com.session.repository.PerfilRepository;
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
	private PerfilRepository profile;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserPrincipal loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		log.info("[loadUserByUsername]::inicio de metodo");
		UsuarioModel usuarioDTO = null;
		String[] usernameAndPass = StringUtils.split(usernameOrEmail, String.valueOf(ConstantesUtil.SEPARATOR));
		try {
			usuarioDTO = usersService.buscarUserByNameOrRut(usernameOrEmail);

			log.info("[loadUserByUsername]::fin de metodo");
			return createUserPrincipal(usuarioDTO, usernameAndPass[0], usernameAndPass[1]);

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
	private UserPrincipal createUserPrincipal(UsuarioModel usuarioDTO, String user, String password) throws Exception {
		log.info("[createUserPrincipal]::inicio de metodo");
		UserPrincipal userPrincipal = new UserPrincipal();

		userPrincipal.setIdUsuario(usuarioDTO.getIdUsuario());
		userPrincipal.setDscEmail("");
		userPrincipal.setFullName(usuarioDTO.getNombre() + " " + usuarioDTO.getApellidoPaterno());
		userPrincipal.setUsername(usuarioDTO.getUsuario());
		userPrincipal.setRut(usuarioDTO.getRut());
		userPrincipal.setPassword(passwordEncoder.encode(password));

		List<RolDTO> rolList = getRolList(usuarioDTO.getUsuario());
		userPrincipal.setListRoles(rolList);

		if (!rolList.isEmpty()) {
			List<GrantedAuthority> authorities = rolList.stream()
					.map(permiso -> new SimpleGrantedAuthority(permiso.getDscRol())).collect(Collectors.toList());
			userPrincipal.setAuthorities(authorities);
		}

		log.info("[createUserPrincipal]::fin de metodo");
		return userPrincipal;
	}

	private List<RolDTO> getRolList(String userName) {
		log.info("[getRolList]::inicio de metodo");
		List<RolDTO> rolList = new ArrayList<>();
		// Roles
		List<PerfilModel> list = profile.findbyUsername(userName);
		for (PerfilModel rol : list) {
			RolDTO r = new RolDTO();
			r.setIdRol(rol.getIdPerfil());
			r.setDscRol(rol.getNombre());
			rolList.add(r);
		}
		log.info("[getRolList]::fin de metodo");
		return rolList;
	}

}