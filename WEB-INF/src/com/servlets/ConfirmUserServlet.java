package com.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import com.POJO.*;

public class ConfirmUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		HttpSession session = req.getSession();
		
		String rollNo = req.getParameter("inputRollNo");

		User user = new User(rollNo);
		if (user.confirmUser()){
			//user confirm
		}else{
			//not confirm
		}
	}
}