package com.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.io.IOException;
import javax.servlet.HttpSession;

import com.POJO.*;


public class SignOutServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		HttpSession session = req.getSession();
		session.invalidate();
		RequestDispatcher reqDis = req.getRequestDispatcher("index.jsp");
		rqDis.forward(req,res);
		
	}
}