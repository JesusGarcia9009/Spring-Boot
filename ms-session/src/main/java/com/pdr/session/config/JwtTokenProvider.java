package com.pdr.session.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdr.common.session.enums.KeyClaimsTokenEnum;
import com.pdr.common.session.security.dto.RolDTO;
import com.pdr.common.session.security.dto.UserPrincipal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * @author Nelson Alvarado
 * @version 1.0 Creacion
 */
@Component
public class JwtTokenProvider {

	private static final Logger LOGGER = LogManager.getLogger(JwtTokenProvider.class);

	//@Value("${api.losparques.secret}")
	private String jwtSecret ="PR-SOS-SECRET";

	
	/**
	 * Funcion que se encarga de crear el token utilizando el caracter secreto para
	 * crear el cuerpo y la cabecera del token
	 * 
	 * @param authentication Objeto que representa las caracteristicas principales
	 *                       del usuario autenticado
	 * @return String que representa la cadena de caracteres creadas para ser el
	 *         token del usuario
	 */
	public String generateToken(Authentication authentication) throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

		Collection<? extends GrantedAuthority> permisos = authentication.getAuthorities();
		Claims claims = Jwts.claims();

		claims.put(KeyClaimsTokenEnum.AUTHORITIES.getDescripcion(), mapper.writeValueAsString(permisos));
		claims.put(KeyClaimsTokenEnum.ROLES.getDescripcion(), mapper.writeValueAsString(userPrincipal.getListRoles()));
		
		//perfiles	//aplicaciones
		claims.put("password", userPrincipal.getTexto());
		
		claims.put(KeyClaimsTokenEnum.ID_USUARIO.getDescripcion(), userPrincipal.getIdUsuario());
		claims.put(KeyClaimsTokenEnum.FULL_NAME.getDescripcion(), userPrincipal.getFullName());
		claims.put(KeyClaimsTokenEnum.EMAIL.getDescripcion(), userPrincipal.getDscEmail());
		claims.put(KeyClaimsTokenEnum.USERNAME.getDescripcion(), userPrincipal.getUsername());
		claims.put(KeyClaimsTokenEnum.PICTURE.getDescripcion(), userPrincipal.getDscImagen());
		claims.put(KeyClaimsTokenEnum.RUT.getDescripcion(), userPrincipal.getRut());
		claims.put(KeyClaimsTokenEnum.USERINPUT.getDescripcion(), userPrincipal.getUserInput());

		Date expiryDate = new Date(System.currentTimeMillis() + 6000000);

		return Jwts.builder().setClaims(claims).setSubject(userPrincipal.getIdUsuario().toString())
				.setIssuedAt(new Date()).setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	public Long getUserIdFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}

	public String getFullNameFromJWT(String token) {
		return getDataByKeyClaims(KeyClaimsTokenEnum.FULL_NAME, token);
	}

	public String getUsernameFromJWT(String token) {
		return getDataByKeyClaims(KeyClaimsTokenEnum.USERNAME, token);
	}

	public Collection<? extends GrantedAuthority> getPermisos(String token) throws IOException {
		String permisos = getDataByKeyClaims(KeyClaimsTokenEnum.AUTHORITIES, token);
		
		Collection<GrantedAuthority> authorities = new ArrayList<>();

		if(permisos != null && !permisos.isEmpty()) {
			authorities = Arrays
				.asList(new ObjectMapper().addMixIn(SimpleGrantedAuthority.class, SimpleGrantedAuthorityMixin.class)
						.readValue(permisos.getBytes(), SimpleGrantedAuthority[].class));
		}

		return authorities;
	}

	public List<RolDTO> getRoles(String token) throws IOException {
		String roles = getDataByKeyClaims(KeyClaimsTokenEnum.ROLES, token);

		List<RolDTO> listado = new ArrayList<>();

		if(roles != null && !roles.equals("null")) {
			listado = Arrays
					.asList(new ObjectMapper().readValue(roles.toString().getBytes(), RolDTO[].class));
		}

		return listado;
	}

	public Claims getClaims(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return claims;
	}

	/**
	 * Genera el objeto UserPrincipal desde el token para el doFilterInternal
	 * 
	 * @param token
	 * @return
	 */
	public UserPrincipal getUserPrincipalFromToken(String token) throws IOException {

		Claims claims = getClaims(token);

		UserPrincipal userPrincipal = new UserPrincipal();

		userPrincipal.setAuthorities(getPermisos(token));
		userPrincipal.setListRoles(getRoles(token));
		userPrincipal.setIdUsuario(getUserIdFromJWT(token));
		userPrincipal.setFullName(findKeyClaimsInData(KeyClaimsTokenEnum.FULL_NAME, claims));
		userPrincipal.setDscEmail(findKeyClaimsInData(KeyClaimsTokenEnum.EMAIL, claims));
		userPrincipal.setUsername(findKeyClaimsInData(KeyClaimsTokenEnum.USERNAME, claims));
		userPrincipal.setDscImagen(findKeyClaimsInData(KeyClaimsTokenEnum.PICTURE, claims));
		userPrincipal.setRut(findKeyClaimsInData(KeyClaimsTokenEnum.RUT, claims));
		userPrincipal.setTexto(findKeyClaimsInData(KeyClaimsTokenEnum.TEXTO, claims));
		userPrincipal.setUserInput(findKeyClaimsInData(KeyClaimsTokenEnum.USERINPUT, claims));

		return userPrincipal;
	}

	/**
	 * Metodo que se encarga de revisar si el token es valido o ya expiro
	 * 
	 * @param authToken Secuencia de caracteres que representa el token recibido
	 * @return <boolean> Que especifica si el token es valido o no true = token
	 *         valido, false = token invalido
	 */
	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException ex) {
			LOGGER.error("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			LOGGER.error("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			LOGGER.error("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			LOGGER.error("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			LOGGER.error("JWT claims string is empty.");
		}
		return false;
	}

	private String getDataByKeyClaims(KeyClaimsTokenEnum keyClaimsTokenEnum, String token) {
		Claims claims = getClaims(token);

		return findKeyClaimsInData(keyClaimsTokenEnum, claims);
	}

	private String findKeyClaimsInData(KeyClaimsTokenEnum keyClaimsTokenEnum, Claims claims) {
		return claims.get(keyClaimsTokenEnum.getDescripcion(), String.class);
	}
}
