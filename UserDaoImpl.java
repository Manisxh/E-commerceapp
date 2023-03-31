package com.shubham.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shubham.ecom.pojo.User;
import com.shubham.ecom.utility.DBConnection;

public class UserDaoImpl implements IUSerDao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	String sqlQuery;

	@Override
	public boolean registerAdmin(User user) {
		sqlQuery="insert into ecommerceuser(userFullName,userEmail,userPassword,userType,userAddress)values(?,?,?,'admin',?)";
		try {
			con=DBConnection.createCon();
			ps=con.prepareStatement(sqlQuery);
			ps.setString(1, user.getUserFullName());
			ps.setString(2, user.getUserEmail());
			ps.setString(3, user.getUserPassword());
			ps.setString(4, user.getUserAddress());
			
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean registerCustomer(User user) {
		sqlQuery="insert into ecommerceuser(userFullName,userEmail,userPassword,userType,userAddress)values(?,?,?,'customer',?)";
		try {
			con=DBConnection.createCon();
			ps=con.prepareStatement(sqlQuery);
			ps.setString(1, user.getUserFullName());
			ps.setString(2, user.getUserEmail());
			ps.setString(3, user.getUserPassword());
			ps.setString(4, user.getUserAddress());
			
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		sqlQuery="update ecommerceuser set userFullName =?,userEmail=?,userPassword=?,userAddress=? where userId=?";
		try {
			con=DBConnection.createCon();
			ps=con.prepareStatement(sqlQuery);
			ps.setString(1, user.getUserFullName());
			ps.setString(2, user.getUserEmail());
			ps.setString(3, user.getUserPassword());
			ps.setString(4, user.getUserAddress());
			ps.setInt(5, user.getUserId());
			
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(int userId) {

		sqlQuery="delete from ecommerceuser where userId=?";
		try {
			con=DBConnection.createCon();
			ps=con.prepareStatement(sqlQuery);
			
			ps.setInt(1, userId);
			
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<User> getUserList() {

		sqlQuery="select * from ecommerceuser";
		List<User> userlist=new ArrayList<>();
		
		try {
			con=DBConnection.createCon();
			ps=con.prepareStatement(sqlQuery);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				User user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(5));
				userlist.add(user);
			}
			return userlist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User GetProfile(int userId) {

		sqlQuery="select * from ecommerceuser where userId=?";
		return null;
	}
	public static void main(String[] args) {
		UserDaoImpl dao=new UserDaoImpl();
		User u=new User("Shubham", "shubham@gmail.com", "123", "Thane");
		boolean flag=dao.registerAdmin(u);
		
		if(flag) {
			System.out.println("Registration Successful");
		}
		else {
			System.out.println("Registration Unsuccessful");
		}
	}

	@Override
	public User login(String userEmail, String userPassword) {
		sqlQuery="select * from ecommerceuser where userEmail=? and userPassword=?";
		con=DBConnection.createCon();
		try {
			ps=con.prepareStatement(sqlQuery);
			ps.setString(1, userEmail);
			ps.setString(2, userPassword);
			System.out.println(ps);
			rs=ps.executeQuery();
			if(rs.next()) {
				User user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(5));
			    return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
