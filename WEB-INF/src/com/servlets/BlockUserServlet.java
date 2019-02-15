package com.servlets;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import com.POJO.*;

public class BlockUserServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
	
		HttpSession session = request.getSession();


		String rollNo = request.getParameter("roll_no");

		User user = new User(rollNo);
		
		if(user.blockUser()){
			System.out.println("Successful");
		
		}else{
			System.out.println("Failed")
		}
		
		//request.getRequestDispatcher("").forward(request,response);

	}
}