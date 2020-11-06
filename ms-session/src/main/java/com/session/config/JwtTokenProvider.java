package com.session.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.session.dto.RolDTO;
import com.session.dto.UserPrincipal;
import com.session.enums.KeyClaimsTokenEnum;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

/**
 * JwtTokenProvider - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
@Component
@Slf4j
public class JwtTokenProvider {

	//@Value("${api.losparques.secret}")
	private String jwtSecret ="PR-SOS-SECRET";
	
	//@Value("${api.losparques.secret}")
	private Integer currentMillis = 6000000;

	
	/**
	 * generateToken - JwtTokenProvider - Spring Boot
	 *
	 * @author Jesus Garcia
	 * @since 1.0
	 * @version jdk-11
	 * @param authentication -  Objeto de usuario autenticado
	 * @return String - token del usuario
	 */
	public String generateToken(Authentication authentication) throws IOException {
		log.info("[generateToken]--> inicio del metodo");

		ObjectMapper mapper = new ObjectMapper();

		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

		Collection<? extends GrantedAuthority> permisos = authentication.getAuthorities();
		Claims claims = Jwts.claims();

		claims.put(KeyClaimsTokenEnum.AUTHORITIES.getDescripcion(), mapper.writeValueAsString(permisos));
		claims.put(KeyClaimsTokenEnum.ROLES.getDescripcion(), mapper.writeValueAsString(userPrincipal.getListRoles()));
		claims.put(KeyClaimsTokenEnum.ID_USUARIO.getDescripcion(), userPrincipal.getIdUsuario());
		claims.put(KeyClaimsTokenEnum.FULL_NAME.getDescripcion(), userPrincipal.getFullName());
		claims.put(KeyClaimsTokenEnum.USERNAME.getDescripcion(), userPrincipal.getUsername());
		claims.put(KeyClaimsTokenEnum.RUT.getDescripcion(), userPrincipal.getRut());
		Date expiryDate = new Date(System.currentTimeMillis() + currentMillis);
		return Jwts.builder().setClaims(claims).setSubject(userPrincipal.getIdUsuario().toString())
				.setIssuedAt(new Date()).setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	/**
	 * getUserPrincipalFromToken - JwtTokenProvider - Spring Boot
	 *
	 * @author Jesus Garcia
	 * @since 1.0
	 * @version jdk-11
	 * @param String - token del usuario
	 * @return Object - Objeto de usuario autenticado {@link UserPrincipal}
	 */
	public UserPrincipal getUserPrincipalFromToken(String token) throws IOException {
		Claims claims = getClaims(token);
		UserPrincipal userPrincipal = new UserPrincipal();
		userPrincipal.setAuthorities(getPermisos(token));
		userPrincipal.setListRoles(getRoles(token));
		userPrincipal.setIdUsuario(getUserIdFromJWT(token));
		userPrincipal.setFullName(findKeyClaimsInData(KeyClaimsTokenEnum.FULL_NAME, claims));
		userPrincipal.setUsername(findKeyClaimsInData(KeyClaimsTokenEnum.USERNAME, claims));
		userPrincipal.setRut(findKeyClaimsInData(KeyClaimsTokenEnum.RUT, claims));

		return userPrincipal;
	}

	/**
	 * validateToken - JwtTokenProvider - Spring Boot
	 *
	 * @author Jesus Garcia
	 * @since 1.0
	 * @version jdk-11
	 * @param authToken - Secuencia de caracteres que representa el token recibido
	 * @return <boolean> Que especifica si el token es valido o no "true = token valido" o "false = token invalido"
	 */
	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException ex) {
			log.error("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			log.error("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			log.error("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			log.error("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			log.error("JWT claims string is empty.");
		}
		return false;
	}
	
	/**
	 * findKeyClaimsInData - JwtTokenProvider - Spring Boot
	 *
	 * @author Jesus Garcia
	 * @since 1.0
	 * @version jdk-11
	 * @param String, Claims  - token del usuario, caracteristicas de usuario
	 * @return Object - Objeto de usuario autenticado {@link UserPrincipal}
	 */
	private String findKeyClaimsInData(KeyClaimsTokenEnum keyClaimsTokenEnum, Claims claims) {
		return claims.get(keyClaimsTokenEnum.getDescripcion(), String.class);
	}
	
	/**
	 * getClaims - JwtTokenProvider - Spring Boot
	 *
	 * @author Jesus Garcia
	 * @since 1.0
	 * @version jdk-11
	 * @param String - token del usuario
	 * @return Claims - Objeto que encapsula las caracteristicas del usuario
	 */
	public Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
	}

	private String getDataByKeyClaims(KeyClaimsTokenEnum keyClaimsTokenEnum, String token) {
		Claims claims = getClaims(token);

		return findKeyClaimsInData(keyClaimsTokenEnum, claims);
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
			listado = Arrays.asList(new ObjectMapper().readValue(roles.toString().getBytes(), RolDTO[].class));
		}

		return listado;
	}

	
	
	
}
