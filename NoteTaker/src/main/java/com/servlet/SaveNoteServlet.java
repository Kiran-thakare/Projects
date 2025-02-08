package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/savenote")
public class SaveNoteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String title = req.getParameter("title");
		String content = req.getParameter("content");

		System.out.println(title + " " + content);

		Note note = new Note(title, content, new Date());
		System.out.println(note.getAddDate());
		System.out.println(note.getId());

		Session s = FactoryProvider.getFactory().openSession();
		Transaction tx = s.beginTransaction();
		s.save(note);
		tx.commit();
		s.close();

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<h1 style='text-align:center;'>Note Added Successfully</h1>");
		out.println("<h1 style='text-align:center;'><a href='allnotes.jsp'>View All Notes</a></h1>");
		

	}
}
