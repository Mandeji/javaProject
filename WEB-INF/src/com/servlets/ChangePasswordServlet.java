package com.servlets;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import com.POJO.*;

public class ChangePasswordServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");

		boolean flag = false;
		String oldPassword = request.getParameter("InputOldPassword");
		String newPassword = request.getParameter("InputNewPassword");
		String confirmPassword = request.getParameter("InputConfirmPassword");

		if(oldPassword.equals(user.password)){
			flag = true;
		}
		if(confirmPassword.equals(newPassword)){
			flag = true;
		}

		if(flag){
		
			if(user.changePassword(newPassword)){
			
				System.out.println("Successful");
			}else{
			
				System.out.println("Failed");
			}
		}else{
		
			System.out.println("Data Failed");
		}

	}
}