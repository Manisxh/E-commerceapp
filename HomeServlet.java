package com.shubham.ecom.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ecom")
public class HomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action;
		action =req.getParameter("action");
		
		if(action!=null&&action.equals("index")) {
			resp.sendRedirect("index.jsp");
		}
		else if(action!=null&&action.equals("about-us")) {
			resp.sendRedirect("aboutus.jsp");
		}
		else if(action!=null&&action.equals("contact-us")) {
			resp.sendRedirect("contactus.jsp");
		}
	}

}
