package com.shubham.ecom.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private DBConnection(){
		
	}
	
	private static String Driver="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/BasicDB";
	private static String user="dbuser";
	private static String password="Squ@d123";
	
	private static Connection con = null;
	
	public static Connection createCon() {
		try {
			Class.forName(Driver);//Register the database driver
			con=DriverManager.getConnection(url, user, password);//Establish the connection with database
			System.out.println("Connected");
			
		} catch (Exception e) {
			
		}
		return con;
		
	}
	public static void main(String[] args) {
		createCon();
	}
	
	
	
	

}
