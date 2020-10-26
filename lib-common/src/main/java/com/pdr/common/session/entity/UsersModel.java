package com.pdr.common.session.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author BS2
 */
@Entity
@Table(name = "USERS", schema = "EXTPAR")
public class UsersModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idUser;
	private String fullName;
	private String rut;
	private String email;
	private String password;
	private String username;
	private BigDecimal administrator;
	private BigDecimal valid;
	private Set<UserProfileModel> userProfiles = new HashSet<UserProfileModel>(0);

	public UsersModel() {
	}

	public UsersModel(BigDecimal idUser, String fullName, String password, BigDecimal administrator, BigDecimal valid) {
		this.idUser = idUser;
		this.fullName = fullName;
		this.password = password;
		this.administrator = administrator;
		this.valid = valid;
	}

	public UsersModel(BigDecimal idUser, String fullName, String rut, String email, String password, String username,
			BigDecimal administrator, BigDecimal valid, Set<UserProfileModel> userProfiles) {
		this.idUser = idUser;
		this.fullName = fullName;
		this.rut = rut;
		this.email = email;
		this.password = password;
		this.username = username;
		this.administrator = administrator;
		this.valid = valid;
		this.userProfiles = userProfiles;
	}

	@Id

	@Column(name = "ID_USER", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdUser() {
		return this.idUser;
	}

	public void setIdUser(BigDecimal idUser) {
		this.idUser = idUser;
	}

	@Column(name = "FULL_NAME", nullable = false, length = 250)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "RUT", length = 12)
	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	@Column(name = "EMAIL", length = 200)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PASSWORD", nullable = false, length = 200)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "USERNAME", length = 100)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "ADMINISTRATOR", nullable = false, precision = 22, scale = 0)
	public BigDecimal getAdministrator() {
		return this.administrator;
	}

	public void setAdministrator(BigDecimal administrator) {
		this.administrator = administrator;
	}

	@Column(name = "VALID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getValid() {
		return this.valid;
	}

	public void setValid(BigDecimal valid) {
		this.valid = valid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<UserProfileModel> getUserProfiles() {
		return this.userProfiles;
	}

	public void setUserProfiles(Set<UserProfileModel> userProfiles) {
		this.userProfiles = userProfiles;
	}

}
