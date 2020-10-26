package com.pdr.common.entity;
// Generated 24-04-2020 11:25:23 by Hibernate Tools 5.4.12.Final

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ProfileApplication generated by hbm2java
 */
public class ProfileApplication implements java.io.Serializable {

	private BigInteger idProfileApplication;
	private Application application;
	private Profile profile;
	private BigInteger ordercolumn;
	private Date createDate;
	private BigInteger createUser;
	private Date updateDate;
	private BigInteger updateUser;
	private Set profileSubApplications = new HashSet(0);

	public ProfileApplication() {
	}

	public ProfileApplication(BigInteger idProfileApplication, Application application, Profile profile,
			BigInteger ordercolumn, Date createDate, BigInteger createUser) {
		this.idProfileApplication = idProfileApplication;
		this.application = application;
		this.profile = profile;
		this.ordercolumn = ordercolumn;
		this.createDate = createDate;
		this.createUser = createUser;
	}

	public ProfileApplication(BigInteger idProfileApplication, Application application, Profile profile,
			BigInteger ordercolumn, Date createDate, BigInteger createUser, Date updateDate, BigInteger updateUser,
			Set profileSubApplications) {
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

	public BigInteger getIdProfileApplication() {
		return this.idProfileApplication;
	}

	public void setIdProfileApplication(BigInteger idProfileApplication) {
		this.idProfileApplication = idProfileApplication;
	}

	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public BigInteger getOrdercolumn() {
		return this.ordercolumn;
	}

	public void setOrdercolumn(BigInteger ordercolumn) {
		this.ordercolumn = ordercolumn;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public BigInteger getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(BigInteger createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public BigInteger getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(BigInteger updateUser) {
		this.updateUser = updateUser;
	}

	public Set getProfileSubApplications() {
		return this.profileSubApplications;
	}

	public void setProfileSubApplications(Set profileSubApplications) {
		this.profileSubApplications = profileSubApplications;
	}

}
