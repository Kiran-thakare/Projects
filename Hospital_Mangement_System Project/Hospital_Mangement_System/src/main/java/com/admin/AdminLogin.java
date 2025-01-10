package com.admin;

import java.io.IOException;

import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin")
public class AdminLogin extends HttpServlet {
   
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		HttpSession session=req.getSession();
		
		if("admin@gmail.com".equals(email) && "admin".equals(pass)) {
			session.setAttribute("admin", new User());
			resp.sendRedirect("admin/index.jsp");
		}else {
			session.setAttribute("alog", "Invalid email & passWord");
			resp.sendRedirect("Admin_Login.jsp");
		}
	}
}
