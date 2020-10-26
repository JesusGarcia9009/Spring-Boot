package com.pdr.common.entity;
// Generated 24-04-2020 11:25:23 by Hibernate Tools 5.4.12.Final

import java.math.BigInteger;
import java.util.Date;

/**
 * UserProfile generated by hbm2java
 */
public class UserProfile implements java.io.Serializable {

	private BigInteger idUserProfile;
	private Profile profile;
	private Users users;
	private Date createDate;
	private BigInteger createUser;
	private Date updateDate;
	private BigInteger updateUser;

	public UserProfile() {
	}

	public UserProfile(BigInteger idUserProfile, Profile profile, Users users, Date createDate, BigInteger createUser) {
		this.idUserProfile = idUserProfile;
		this.profile = profile;
		this.users = users;
		this.createDate = createDate;
		this.createUser = createUser;
	}

	public UserProfile(BigInteger idUserProfile, Profile profile, Users users, Date createDate, BigInteger createUser,
			Date updateDate, BigInteger updateUser) {
		this.idUserProfile = idUserProfile;
		this.profile = profile;
		this.users = users;
		this.createDate = createDate;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
	}

	public BigInteger getIdUserProfile() {
		return this.idUserProfile;
	}

	public void setIdUserProfile(BigInteger idUserProfile) {
		this.idUserProfile = idUserProfile;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
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

}
