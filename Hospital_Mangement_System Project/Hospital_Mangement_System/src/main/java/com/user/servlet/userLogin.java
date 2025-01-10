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

@WebServlet("/userlog")
public class userLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String pass = req.getParameter("pass");

//		User u = new User();
//		u.setEmail(email);
//		u.setPass(pass);

		UserDao dao = new UserDao();
		User user = dao.login(email,pass);

		if (user != null) {
			HttpSession session=req.getSession();
			session.setAttribute("user", user);
			resp.sendRedirect("userdash.jsp");
			

		}else {
			
			req.setAttribute("err", "User Not Found");
			req.getRequestDispatcher("User_Login.jsp").forward(req, resp);
		}
	}
}
