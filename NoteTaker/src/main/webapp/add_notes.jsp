<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes</title>
<%@include file="allcss.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>

		<h1>Please Fill Your Note Details</h1>

		<!-- This is Add from -->
		<form action="savenote" method="post">
			<div class="mb-3">
				<label for="title" class="form-label">Note Title </label> <input
					type="text" class="form-control" id="title"
					aria-describedby="emailHelp" name="title" required="required">

			</div>
			<div class="mb-3">
				<label for="content" class="form-label">Note Content</label>
				<textarea class="form-control" id="content" rows="7" name="content"></textarea>
			</div>
			<div class="d-flex justify-content-center">
				<button type="submit" class="btn btn-primary">Add</button>
			</div>
		</form>
	</div>
</body>
</html>