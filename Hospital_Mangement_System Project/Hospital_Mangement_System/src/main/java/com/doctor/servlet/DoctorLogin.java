package com.doctor.servlet;

import java.io.IOException;

import com.dao.DoctorDao;
import com.dao.UserDao;
import com.entity.Doctor;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/doctorlogin")
public class DoctorLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String pass = req.getParameter("pass");

		HttpSession session = req.getSession();

		DoctorDao dao = new DoctorDao();
		Doctor d = dao.login(email, pass);

		if (d == null) {
			session.setAttribute("err", "Check Email and Password ");
			resp.sendRedirect("Doctor_login.jsp");

		} else {

			session.setAttribute("doc", d);
			resp.sendRedirect("doctor/index.jsp");
		}
	}
}
