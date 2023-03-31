package com.shubham.ecom.pojo;

/*
 * create table ecommerceuser(userId int primary key auto_increment,userFullName varchar(30),userEmail varchar(30),userPassword varchar(30),userType varchar(30),userAddress varchar(30));
 */

public class User {
	private int userId;
	private String userFullName;
	private String userEmail;
	private String userPassword;
	private String userAddress;
	private String userType;
	
	private User() {
		
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFullName=" + userFullName + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + ", userAddress=" + userAddress + ", userType=" + userType + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public User(int userId, String userFullName, String userEmail, String userPassword, String userAddress,
			String userType) {
		super();
		this.userId = userId;
		this.userFullName = userFullName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.userType = userType;
	}

	public User(String userFullName, String userEmail, String userPassword, String userAddress) {
		super();
		this.userFullName = userFullName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
	}

}
