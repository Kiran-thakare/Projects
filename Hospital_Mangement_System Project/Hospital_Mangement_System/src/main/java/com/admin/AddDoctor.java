package com.admin;

import java.io.IOException;

import com.dao.DoctorDao;
import com.entity.Doctor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adddoctor")
public class AddDoctor extends HttpServlet {
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String date=req.getParameter("date");
		String email=req.getParameter("email");
		String qual=req.getParameter("qual");
		String spec=req.getParameter("spec");
		String mo=req.getParameter("mo");
		String pass=req.getParameter("pass");
		
		Doctor d=new Doctor(name, date, email, qual, spec, mo, pass);
		
		DoctorDao dao=new DoctorDao();
		int i =dao.addDoctor(d);
		
		HttpSession session=req.getSession();
		
		if(i>0)
		{
			session.setAttribute("msg", "Doctor Add SuccessFully");
			req.getRequestDispatcher("admin/viewdoctor.jsp").forward(req, resp);
			
		}else {
			session.setAttribute("err", "Please Check Info ");
			req.getRequestDispatcher("admin/Doc.jsp").forward(req, resp);
		}
		
	}
}
