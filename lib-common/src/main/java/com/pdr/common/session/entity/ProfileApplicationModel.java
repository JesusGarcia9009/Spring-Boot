package com.pdr.common.session.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author BS2
 */
@Entity
@Table(name = "PROFILE_APPLICATION", schema = "EXTPAR")
public class ProfileApplicationModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idProfileApplication;
	private ApplicationModel application;
	private ProfileModel profile;
	private BigDecimal ordercolumn;
	private Date createDate;
	private BigDecimal createUser;
	private Date updateDate;
	private BigDecimal updateUser;
	private Set<ProfileSubApplicationModel> profileSubApplications = new HashSet<ProfileSubApplicationModel>(0);

	public ProfileApplicationModel() {
	}

	public ProfileApplicationModel(BigDecimal idProfileApplication, ApplicationModel application, ProfileModel profile,
			BigDecimal ordercolumn, Date createDate, BigDecimal createUser) {
		this.idProfileApplication = idProfileApplication;
		this.application = application;
		this.profile = profile;
		this.ordercolumn = ordercolumn;
		this.createDate = createDate;
		this.createUser = createUser;
	}

	public ProfileApplicationModel(BigDecimal idProfileApplication, ApplicationModel application, ProfileModel profile,
			BigDecimal ordercolumn, Date createDate, BigDecimal createUser, Date updateDate, BigDecimal updateUser,
			Set<ProfileSubApplicationModel> profileSubApplications) {
		this.idProfileApplication = idProfileApplication;
		this.application = application;
		this.profile = profile;
		this.ordercolumn = ordercolumn;
		this.createDate = createDate;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.profileSubApplications = profileSubApplications;
	}

	@Id

	@Column(name = "ID_PROFILE_APPLICATION", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdProfileApplication() {
		return this.idProfileApplication;
	}

	public void setIdProfileApplication(BigDecimal idProfileApplication) {
		this.idProfileApplication = idProfileApplication;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_APPLICATION", nullable = false)
	public ApplicationModel getApplication() {
		return this.application;
	}

	public void setApplication(ApplicationModel application) {
		this.application = application;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PROFILE", nullable = false)
	public ProfileModel getProfile() {
		return this.profile;
	}

	public void setProfile(ProfileModel profile) {
		this.profile = profile;
	}

	@Column(name = "ORDERCOLUMN", nullable = false, precision = 22, scale = 0)
	public BigDecimal getOrdercolumn() {
		return this.ordercolumn;
	}

	public void setOrdercolumn(BigDecimal ordercolumn) {
		this.ordercolumn = ordercolumn;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE", nullable = false, length = 7)
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

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DATE", length = 7)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "profileApplication")
	public Set<ProfileSubApplicationModel> getProfileSubApplications() {
		return this.profileSubApplications;
	}

	public void setProfileSubApplications(Set<ProfileSubApplicationModel> profileSubApplications) {
		this.profileSubApplications = profileSubApplications;
	}

}
