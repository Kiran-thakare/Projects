package com.doctor.servlet;

import java.io.IOException;

import com.dao.AppointmentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updatestatus")
public class UpdateStatus extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		int drid=Integer.parseInt(req.getParameter("did"));
		String comm=req.getParameter("comment");
		
		AppointmentDao dao=new AppointmentDao();
		int i=dao.updateCommentStatus(id, drid, comm);
		
		HttpSession session=req.getSession();
		
		if(i>0) {
			session.setAttribute("Csuccess", "Comment Updated");
			resp.sendRedirect("doctor/patient.jsp");
		}else {
			session.setAttribute("PFailed", "Somthing Wrong.. ");
			resp.sendRedirect("doctor/patient.jsp");
		}
		
	}

}
