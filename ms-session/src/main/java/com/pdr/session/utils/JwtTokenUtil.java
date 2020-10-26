package com.pdr.session.utils;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.pdr.common.exception.UserNotAuthException;
import com.pdr.common.session.entity.UsersModel;
import com.pdr.common.session.security.dto.UserPrincipal;
import com.pdr.session.config.JwtTokenProvider;


/**
 * @author nelson Alvarado
 *
 *
 */
@Component
public class JwtTokenUtil {

	private static final Logger LOGGER = LogManager.getLogger(JwtTokenUtil.class);

	@Autowired
	public AuthenticationManager authenticationManager;

	@Autowired
	public JwtTokenProvider tokenProvider;

	/**
	 * Crea el token cuando se loguea el usuario
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public Authentication createToken(String usernameOrEmail, String password) throws UserNotAuthException {

		LOGGER.info("createToken -> usernameOrEmail " + usernameOrEmail);
		
		String userAndPass = usernameOrEmail + ConstantesUtil.SEPARATOR + password;

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(userAndPass, password));

		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return authentication;
	}

	/**
	 * Refresca el token ante una modificacion
	 * 
	 * @param usuario
	 * @return
	 */
	public String refreshToken(UsersModel usuario) throws UserNotAuthException {
		LOGGER.info("refreshToken -> idUsuario " + usuario.getFullName());
		String jwt ="";
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			// Obtenemos los datos
			UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

			// Actualizamos los datos
			userPrincipal.setUsername(usuario.getUsername());
			userPrincipal.setDscEmail(usuario.getEmail());
			userPrincipal.setFullName(usuario.getFullName());
			userPrincipal.setPassword(usuario.getPassword());
			userPrincipal.setRut(usuario.getRut());


			// Volvemos a generar el objeto
			authentication = new UsernamePasswordAuthenticationToken(userPrincipal, userPrincipal.getPassword(),
					userPrincipal.getAuthorities());

			jwt = generateToken(authentication);

		} catch (UserNotAuthException e) {
			LOGGER.error("No es posible refrescar el token del usuario " + e.getMessage());
			throw new UserNotAuthException("No es posible refrescar el token del usuario " + e.getMessage());
		}
		return jwt;
	}

	/**
	 * Setea la authentication en el context y genera el nuevo token
	 * 
	 * @param authentication
	 * @return
	 */
	public String generateToken(Authentication authentication) throws UserNotAuthException {
		String jwt ="";
		try {
			jwt = tokenProvider.generateToken(authentication);
		} catch (IOException e) {
			throw new UserNotAuthException("no se puede generar token");
		}
		return jwt;
	}
	
	
	
}
