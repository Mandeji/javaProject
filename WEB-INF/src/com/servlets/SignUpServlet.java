package com.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import com.POJO.*;

public class SignUpServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		HttpSession session = req.getSession();
		String name = req.getParameter("inputname");
		String rollNo = req.getParameter("inputRollNo");
		String password = req.getParameter("inputPassword");
		String account = req.getParameter("user_type");
		boolean accountType;	

		if(account.equals("student"){
			accountType = true;
		}else{
			accountType = false;
		}

		//########register
		RequestDispatcher reqDis;
		if(accountType != null){
			User user = new User(name,password,rollNo,accountType);
			if(user.signUpUser()){
				reqDis = req.getRequestDispatcher("index.jsp");
				reqDis.forward(req,res);
			}else{
				req.setAttribute("duplicate_value","Duplicate value,You are not Register");
			}
		}
	}
}