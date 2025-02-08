<%@page import="com.entities.Note"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.helper.FactoryProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Page</title>
<%@include file="allcss.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<h1>Edit Your Note</h1>

		<%
		int id = Integer.parseInt(request.getParameter("id").trim());
		Session s = FactoryProvider.getFactory().openSession();

		Note n = s.get(Note.class, id);
		%>

		<form action="update" method="post">

			<input type="hidden" name="uid" value="<%=n.getId()%>">
			<div class="mb-3">
				<label for="title" class="form-label">Note Title </label> <input
					type="text" class="form-control" id="title"
					aria-describedby="emailHelp" name="title" required="required"
					value="<%=n.getTitle()%>">

			</div>
			<div class="mb-3">
				<label for="content" class="form-label">Note Content</label>
				<textarea class="form-control" id="content" rows="7" name="content"><%=n.getContent()%></textarea>
			</div>
			<div class="d-flex justify-content-center">
				<button type="submit" class="btn btn-success">Update</button>
			</div>
		</form>

	</div>
</body>
</html>