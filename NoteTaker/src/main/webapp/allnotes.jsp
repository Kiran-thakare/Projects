<%@page import="com.entities.Note"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Notes</title>
<%@include file="allcss.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>

		<div class="row">
			<div class="col-12  ">
				<h1>All Notes</h1>

				<%
				Session s = FactoryProvider.getFactory().openSession();
				Query q = s.createQuery("from Note");

				List<Note> list = q.list();
				for (Note n : list) {
				%>

				<div class="card mt-3">
					<img class="card-img-top m-4 mx-auto" style="max-width: 100px;"
						src="img/notes.png" alt="Card image cap">
					<div class="card-body px-5">
						<h5 class="card-title"><%=n.getTitle()%></h5>
						<p class="card-text"><%=n.getContent()%></p>
						<p class="card-text">
							<b>Date :<%=n.getAddDate()%></b>
						</p>
						<div class="text-center">

							<a href="edit.jsp?id=<%=n.getId()%>" class="btn btn-primary">Update</a>
							<a href="delete?id=<%=n.getId()%>" class="btn btn-danger">Delete</a>
						</div>
					</div>
				</div>



				<%
				}

				s.close();
				%>


			</div>



		</div>






	</div>


</body>
</html>