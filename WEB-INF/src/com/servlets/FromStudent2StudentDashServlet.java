package com.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import com.POJO.*;

public class FromStudent2StudentDashServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		RequestDispatcher reqDis = req.getRequestDispatcher("StudentDash.jsp");
		reqDis.forward(req,res);
	}
}