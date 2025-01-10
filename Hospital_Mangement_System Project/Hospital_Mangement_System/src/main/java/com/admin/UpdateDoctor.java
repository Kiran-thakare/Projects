package com.admin;

import java.io.IOException;

import com.dao.DoctorDao;
import com.entity.Doctor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updatedoctor")
public class UpdateDoctor extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String date = req.getParameter("date");
		String email = req.getParameter("email");
		String qual = req.getParameter("qual");
		String spec = req.getParameter("spec");
		String mo = req.getParameter("mo");
		String pass = req.getParameter("pass");

		Doctor d = new Doctor(id, name, date, email, qual, spec, mo, pass);

		DoctorDao dao = new DoctorDao();
		int i = dao.updateDoctor(d);

		if (i > 0) {
			req.setAttribute("update", "Update Succesfully Doctor");
			req.getRequestDispatcher("admin/viewdoctor.jsp").forward(req, resp);
		} else {
			req.setAttribute("err", "Somthing Wrong Doctor");
			req.getRequestDispatcher("admin/edit_doctor.jsp").forward(req, resp);
		}

	}
}
