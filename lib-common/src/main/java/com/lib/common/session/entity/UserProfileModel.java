package com.lib.common.session.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author BS2
 */
@Entity
@Table(name = "USER_PROFILE", schema = "EXTPAR")
public class UserProfileModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idUserProfile;
	private ProfileModel profile;
	private UsersModel users;
	private Date createDate;
	private BigDecimal createUser;
	private Date updateDate;
	private BigDecimal updateUser;

	public UserProfileModel() {
	}

	public UserProfileModel(BigDecimal idUserProfile, ProfileModel profile, UsersModel users, Date createDate, BigDecimal createUser) {
		this.idUserProfile = idUserProfile;
		this.profile = profile;
		this.users = users;
		this.createDate = createDate;
		this.createUser = createUser;
	}

	public UserProfileModel(BigDecimal idUserProfile, ProfileModel profile, UsersModel users, Date createDate, BigDecimal createUser,
			Date updateDate, BigDecimal updateUser) {
		this.idUserProfile = idUserProfile;
		this.profile = profile;
		this.users = users;
		this.createDate = createDate;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
	}

	@Id

	@Column(name = "ID_USER_PROFILE", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdUserProfile() {
		return this.idUserProfile;
	}

	public void setIdUserProfile(BigDecimal idUserProfile) {
		this.idUserProfile = idUserProfile;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PROFILE", nullable = false)
	public ProfileModel getProfile() {
		return this.profile;
	}

	public void setProfile(ProfileModel profile) {
		this.profile = profile;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USER", nullable = false)
	public UsersModel getUsers() {
		return this.users;
	}

	public void setUsers(UsersModel users) {
		this.users = users;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", nullable = false, length = 11)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "CREATE_USER", nullable = false, precision = 22, scale = 0)
	public BigDecimal getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(BigDecimal createUser) {
		this.createUser = createUser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DATE", length = 11)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "UPDATE_USER", precision = 22, scale = 0)
	public BigDecimal getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(BigDecimal updateUser) {
		this.updateUser = updateUser;
	}

}
