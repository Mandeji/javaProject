package com.servlets;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import com.POJO.*;

public class ChangeNotificationServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		HttpSession session = request.getSession;

		User user = (User)session.getAttribute("user");

		if(user.changeNotifyStatus()){

			System.out.println("Successful");
		
		}else{
			System.out.println("Failed");
		}
	}
}