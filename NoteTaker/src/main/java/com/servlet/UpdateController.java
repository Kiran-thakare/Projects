package com.servlet;

import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(req.getParameter("uid").trim());
			String title = req.getParameter("title");
			String content = req.getParameter("content");

			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			Note n = s.get(Note.class, id);
			n.setTitle(title);
			n.setContent(content);
			n.setAddDate(new Date());

			tx.commit();

			s.close();
			resp.sendRedirect("allnotes.jsp");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
