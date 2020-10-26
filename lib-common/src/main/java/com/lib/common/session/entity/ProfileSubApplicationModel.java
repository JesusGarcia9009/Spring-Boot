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
@Table(name = "PROFILE_SUB_APPLICATION", schema = "EXTPAR")
public class ProfileSubApplicationModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idProfileSubApplication;
	private ProfileApplicationModel profileApplication;
	private SubMenuApplicationModel subMenuApplication;
	private BigDecimal ordercolumn;
	private Date createDate;
	private BigDecimal createUser;
	private Date updateDate;
	private BigDecimal updateUser;

	public ProfileSubApplicationModel() {
	}

	public ProfileSubApplicationModel(BigDecimal idProfileSubApplication, ProfileApplicationModel profileApplication,
			SubMenuApplicationModel subMenuApplication, BigDecimal ordercolumn, Date createDate, BigDecimal createUser) {
		this.idProfileSubApplication = idProfileSubApplication;
		this.profileApplication = profileApplication;
		this.subMenuApplication = subMenuApplication;
		this.ordercolumn = ordercolumn;
		this.createDate = createDate;
		this.createUser = createUser;
	}

	public ProfileSubApplicationModel(BigDecimal idProfileSubApplication, ProfileApplicationModel profileApplication,
			SubMenuApplicationModel subMenuApplication, BigDecimal ordercolumn, Date createDate, BigDecimal createUser,
			Date updateDate, BigDecimal updateUser) {
		this.idProfileSubApplication = idProfileSubApplication;
		this.profileApplication = profileApplication;
		this.subMenuApplication = subMenuApplication;
		this.ordercolumn = ordercolumn;
		this.createDate = createDate;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
	}

	@Id

	@Column(name = "ID_PROFILE_SUB_APPLICATION", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdProfileSubApplication() {
		return this.idProfileSubApplication;
	}

	public void setIdProfileSubApplication(BigDecimal idProfileSubApplication) {
		this.idProfileSubApplication = idProfileSubApplication;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PROFILE_APPLICATION", nullable = false)
	public ProfileApplicationModel getProfileApplication() {
		return this.profileApplication;
	}

	public void setProfileApplication(ProfileApplicationModel profileApplication) {
		this.profileApplication = profileApplication;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SUB_MENU_APPLICATION", nullable = false)
	public SubMenuApplicationModel getSubMenuApplication() {
		return this.subMenuApplication;
	}

	public void setSubMenuApplication(SubMenuApplicationModel subMenuApplication) {
		this.subMenuApplication = subMenuApplication;
	}

	@Column(name = "ORDERCOLUMN", nullable = false, precision = 22, scale = 0)
	public BigDecimal getOrdercolumn() {
		return this.ordercolumn;
	}

	public void setOrdercolumn(BigDecimal ordercolumn) {
		this.ordercolumn = ordercolumn;
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
