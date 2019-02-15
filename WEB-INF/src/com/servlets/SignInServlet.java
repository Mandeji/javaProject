package com.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import com.POJO.*;

public class SignInServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		HttpSession session = req.getSession();
		String rollNo = req.getParameter("inputRollNo");
		String password = req.getParameter("inputPassword");
		
		User user = new User();
		RequestDispatcher reqDis;
		if(user.loginUser(rollNo,password)){
			if(user.isAdmin()){
				session.setAttribute("user",user);
				reqDis = req.getRequestDispatcher("adminDash.jsp");
				reqDis.forward(req,res);
			}else{
				session.setAttribute("user",user);
				reqDis = req.getRequestDispatcher("StudentDash.jsp");
				reqDis.forward(req,res);
			}
		}else{
				req.setAttribute("incorrect_pass","Wrong Username or password. Please Check again");
		}
		
	}
}