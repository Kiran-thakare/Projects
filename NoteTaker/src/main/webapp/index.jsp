<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Note Taker</title>

<%@include file="allcss.jsp"%>

</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>

		<br>
		<div class="card py-5">

			<img alt="img not Found" style="max-width: 400px"
				; src="img/notes.png" class="img-fluid mx-auto">
			<h1 class="text-primary text-uppercase text-center">Start Taking
				Your Notes</h1>
			<div class="d-flex justify-content-center mt-2">
				<a href="add_notes.jsp" class="btn btn-outline-primary">Start Here</a>
			</div>
		</div>


	</div>

</body>
</html>
