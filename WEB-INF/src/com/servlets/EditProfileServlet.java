package com.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import com.POJO.*;

public class EditProfileServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		HttpSession session = req.getSession();

		User user = (User)session.getAttribute("user");

		String name = req.getParameter("name");
		String rollNo = req.getParameter("inputRollNo");
		String contact = req.getParameter("contactno");
		String address = req.getParameter("pub_des");
		
		
		User user = new User(name,rollNo,contact,address);
		if (user.editProfile()){
			//session.setAttribute();
			//updated successfully
		}else{
			//session.setAttribute();
			//not updated
		}
	}
}