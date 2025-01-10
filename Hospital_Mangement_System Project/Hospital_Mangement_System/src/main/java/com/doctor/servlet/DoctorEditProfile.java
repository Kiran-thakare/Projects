package com.doctor.servlet;

import java.io.IOException;

import com.dao.DoctorDao;
import com.entity.Doctor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/doctorupdateProfile")
public class DoctorEditProfile extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String date = req.getParameter("date");
		String email = req.getParameter("email");
		String qual = req.getParameter("qual");
		String spec = req.getParameter("spec");
		String mo = req.getParameter("mo");

		Doctor d = new Doctor(id, name, date, email, qual, spec, mo, "");

		DoctorDao dao = new DoctorDao();
		int i = dao.editDoctorprofile(d);

		HttpSession session = req.getSession();

		if (i > 0) {
			session.setAttribute("successmessage", "Doctor Add SuccessFully");
			req.getRequestDispatcher("doctor/editprofile.jsp").forward(req, resp);

		} else {
			session.setAttribute("errmsg", "Please Check Info ");
			req.getRequestDispatcher("doctor/editprofile.jsp").forward(req, resp);
		}

	}
}
