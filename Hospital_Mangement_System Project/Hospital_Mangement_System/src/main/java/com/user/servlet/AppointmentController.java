package com.user.servlet;

import java.io.IOException;

import com.dao.AppointmentDao;
import com.entity.Appointment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/addappointment")
public class AppointmentController extends HttpServlet {
   
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("uid"));
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String appoint_date = req.getParameter("date");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String diseases = req.getParameter("diseases");
		int doctor_id = Integer.parseInt(req.getParameter("doct"));
		String address = req.getParameter("address");
		
		Appointment ap=new Appointment(id, name, gender, age, appoint_date, email, phone, diseases, doctor_id, address, "pending");
		
		AppointmentDao dao=new AppointmentDao();
		HttpSession session=req.getSession();
		
		int i=dao.addAppointment(ap);
		
		if(i>0) {
			session.setAttribute("success", "Appointment SuccessFully..!!");
			resp.sendRedirect("user_appointment.jsp");
		}else {
			session.setAttribute("failed", "Something Wrongy..!!");
			resp.sendRedirect("user_appointment.jsp");
		}
		
	}
}
