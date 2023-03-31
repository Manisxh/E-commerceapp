package com.shubham.ecom.dao;

import java.util.List;

import com.shubham.ecom.pojo.User;

public interface IUSerDao {
	
	boolean registerAdmin(User user);
	boolean registerCustomer(User user);
	boolean updateUser(User user);
	boolean deleteUser(int userId);
	List<User> getUserList();
	User GetProfile(int userId);
	
	User login(String userEmail,String userPassword);

}
