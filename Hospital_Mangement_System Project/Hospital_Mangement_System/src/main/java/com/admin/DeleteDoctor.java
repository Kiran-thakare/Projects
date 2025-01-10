package com.admin;

import java.io.IOException;

import com.dao.DoctorDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deletedoctor")
public class DeleteDoctor extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("uid"));
		
		DoctorDao dao=new DoctorDao();
		int i=dao.deleteDoctor(id);
		  
		HttpSession session=req.getSession();
		if(i>0) {
			session.setAttribute("del", "Doctor Deleted Succesfully..!!");
			resp.sendRedirect("admin/viewdoctor.jsp");
		}else {
			session.setAttribute("err", "somthing wrong..!!");
			resp.sendRedirect("admin/viewdoctor.jsp");		}
	}

}
