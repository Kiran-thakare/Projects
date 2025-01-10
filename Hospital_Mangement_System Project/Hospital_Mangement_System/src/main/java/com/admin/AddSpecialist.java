package com.admin;

import java.io.IOException;

import com.dao.specialistDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addspecialist")
public class AddSpecialist extends HttpServlet {
   
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sname=req.getParameter("sname");
		
		specialistDao dao=new specialistDao();
		 
		boolean f=dao.addSpecialist(sname);
		
		HttpSession session=req.getSession();
		
		if(f) {
			session.setAttribute("succ", "Specialist Add SuccessFully....");
			resp.sendRedirect("admin/index.jsp");

		}else {
			session.setAttribute("succ", "Somthing Wrong....");
			resp.sendRedirect("Admin_Login.jsp");
		}
	}
}
