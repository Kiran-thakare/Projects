package com.user.servlet;

import java.io.IOException;

import com.dao.UserDao;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/userregister")
public class userRegister extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");

		User u = new User(name, email, pass);

		UserDao dao = new UserDao();
		boolean f = dao.register(u);

		HttpSession session = req.getSession();

		if (f) {
			session.setAttribute("msg", "Register Succesfully");
			req.getRequestDispatcher("signup.jsp").forward(req, resp);
		} else {
			session.setAttribute("err", "Something Wrong..");
			req.getRequestDispatcher("signup.jsp").forward(req, resp);
		}

	}

}
