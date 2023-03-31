package com.shubham.ecom.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shubham.ecom.dao.IUSerDao;
import com.shubham.ecom.dao.UserDaoImpl;
import com.shubham.ecom.pojo.User;
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	User user=null;
	IUSerDao userdao=new UserDaoImpl();
	boolean flag;
	HttpSession session=null;
	List<User> userlist=null;
	String action;
	String userFullName;
	String userEmail;
	String userPassword;
	String userAddress;
	int userId;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action =req.getParameter("action");
		session=req.getSession();
		
		if(action!=null&&action.equals("login")) {
			resp.sendRedirect("login.jsp");
		}
		else if(action!=null&&action.equals("register")) {
			resp.sendRedirect("register.jsp");
		}
		else if(action!=null&&action.equals("customerlist")) {
			userlist=userdao.getUserList();
			session.setAttribute("userlist", userlist);
			resp.sendRedirect("userlist1.jsp");
		}
		else if(action!=null&&action.equals("delete")) {
			userId=Integer.parseInt(req.getParameter("userId"));
			userdao.deleteUser(userId);
			userlist=userdao.getUserList();
			session.setAttribute("userlist", userlist);
			resp.sendRedirect("userlist1.jsp");
		}
		else if(action!=null&&action.equals("logout")) 
		{
			session=req.getSession();
			if(session!=null) {
				session.invalidate();
				resp.sendRedirect("index.jsp");
			}
		}
		else if(action!=null&&action.equals("registeradmin")) 
		{
			resp.sendRedirect("adminRegister.jsp");
		}
    }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		action=req.getParameter("action");
		if(action!=null&&action.equals("customerregistration")) {
			userFullName=req.getParameter("userFullName");
			userEmail=req.getParameter("userEmail");
			userPassword=req.getParameter("userPassword");
			userAddress=req.getParameter("userAddress");

			/*System.out.println(userFullName);
			System.out.println(userEmail);
			System.out.println(userPassword);
			System.out.println(userAddress);*/
			user=new User(userFullName, userEmail, userPassword, userAddress);
			flag=userdao.registerCustomer(user);
			if(flag) {
				resp.sendRedirect("login.jsp");
			}
			else {
				req.setAttribute("msg", "Something went wrong...");
				req.getRequestDispatcher("register.jsp").forward(req, resp);;
				
			}	
			
		}
		else if(action!=null&&action.equals("login")) {
			userEmail=req.getParameter("userEmail");
			userPassword=req.getParameter("userPassword");
			user=userdao.login(userEmail, userPassword);
			if(user!=null) {
				session=req.getSession();
				session.setAttribute("user", user);
				resp.sendRedirect("index.jsp");
			}
			else {
				resp.sendRedirect("login.jsp");
			}
		}
		else if(action!=null&&action.equals("adminregistration")) 
		{
			userFullName=req.getParameter("userFullName");
			userEmail=req.getParameter("userEmail");
			userPassword=req.getParameter("userPassword");
			userAddress=req.getParameter("userAddress");
			
			user=new User(userFullName, userEmail, userPassword, userAddress);
			
			flag = userdao.registerAdmin(user);
			if(flag) {
				resp.sendRedirect("index.jsp");
			}
			else {
				req.setAttribute("msg", "Something went wrong...");
				req.getRequestDispatcher("adminregister.jsp").forward(req, resp);;
				
			}	
		}
		else if(action!=null&&action.equals("emailcheck")) 
		{
			userEmail=req.getParameter("userEmail");
			System.out.println(userEmail);
		}
		
	}
}
