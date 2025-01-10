package com.doctor.servlet;

import java.io.IOException;

import com.dao.DoctorDao;
import com.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/doctorChangePassword")
public class DoctorPasswordChange extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("uid"));
		String oldpass = req.getParameter("oldPassword");
		String npass = req.getParameter("newPassword");

		System.out.println(id + " :" + oldpass + " :" + npass);

		DoctorDao dao = new DoctorDao();

		HttpSession session = req.getSession();

		if (dao.checkOldPassword(id, oldpass)) {
			if (dao.changePassword(id, npass)) {
				session.setAttribute("passcorrect", "PassWord Change Succesfully..!!");
				resp.sendRedirect("doctor/editprofile.jsp");
			} else {
				session.setAttribute("incorrect", "Old Password Incorrect");
				resp.sendRedirect("doctor/editprofile.jsp");
			}

		} else {
			session.setAttribute("incorrect", " Something Wrong Incorrect");
			resp.sendRedirect("doctor/editprofile.jsp");
		}

	}

}
