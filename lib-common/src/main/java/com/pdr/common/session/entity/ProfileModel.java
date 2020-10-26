package com.pdr.common.session.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author BS2
 */
@Entity
@Table(name = "PROFILE", schema = "EXTPAR")
public class ProfileModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idProfile;
	private String name;
	private Date createDate;
	private BigDecimal createUser;
	private Date updateDate;
	private BigDecimal updateUser;
	private char valid;
	private Set<ProfileApplicationModel> profileApplications = new HashSet<ProfileApplicationModel>(0);
	private Set<UserProfileModel> userProfiles = new HashSet<UserProfileModel>(0);

	public ProfileModel() {
	}

	public ProfileModel(BigDecimal idProfile, String name, Date createDate, BigDecimal createUser, char valid) {
		this.idProfile = idProfile;
		this.name = name;
		this.createDate = createDate;
		this.createUser = createUser;
		this.valid = valid;
	}

	public ProfileModel(BigDecimal idProfile, String name, Date createDate, BigDecimal createUser, Date updateDate,
			BigDecimal updateUser, char valid, Set<ProfileApplicationModel> profileApplications,
			Set<UserProfileModel> userProfiles) {
		this.idProfile = idProfile;
		this.name = name;
		this.createDate = createDate;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.valid = valid;
		this.profileApplications = profileApplications;
		this.userProfiles = userProfiles;
	}

	@Id

	@Column(name = "ID_PROFILE", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdProfile() {
		return this.idProfile;
	}

	public void setIdProfile(BigDecimal idProfile) {
		this.idProfile = idProfile;
	}

	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Column(name = "VALID", nullable = false, length = 1)
	public char getValid() {
		return this.valid;
	}

	public void setValid(char valid) {
		this.valid = valid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "profile")
	public Set<ProfileApplicationModel> getProfileApplications() {
		return this.profileApplications;
	}

	public void setProfileApplications(Set<ProfileApplicationModel> profileApplications) {
		this.profileApplications = profileApplications;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "profile")
	public Set<UserProfileModel> getUserProfiles() {
		return this.userProfiles;
	}

	public void setUserProfiles(Set<UserProfileModel> userProfiles) {
		this.userProfiles = userProfiles;
	}

}
