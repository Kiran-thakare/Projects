<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Specalist"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.specialistDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doc</title>
<%@include file="../componant/allcss.jsp"%>
</head>
<body>
	<%@include file="admin_navbar.jsp"%>

	<div class="container-fluid p-2">
		<div class="row">
			<div class="col-md-4 offset-4">
				<div class=" card paint-card">
					<div class="card-body">
						<p class="text-center fs-3 text-success">Add Doctor</p>
						
						
						<p class="text-center fs-3">${err }</p>


						<form action="../adddoctor" method="post">

							<div class="form-group mt-2">
								<label for="name">Full name </label> <input type="text"
									class="form-control" id="name" name="name">
							</div>

							<div class="form-group mt-2">
								<label for="name">DOB </label> <input type="date"
									class="form-control" id="date" name="date">
							</div>

							<div class="form-group mt-2">
								<label for="email">Email </label> <input type="email"
									class="form-control" id="email" name="email">
							</div>

							<div class="form-group mt-2">
								<label for="qual">Qualification </label> <input type="text"
									class="form-control" id="qual" name="qual">
							</div>
							<div class="form-group mt-2">
								<label for="name">Specialist </label> <select name="spec"
									class="form-control">
									<option>Select Option</option>
									<%
									specialistDao dao = new specialistDao();
									List<Specalist> list = dao.getAllSpecialist();
									for (Specalist s : list) {
									%>
									<option><%=s.getSpecialistName()%></option>

									<%
									}
									%>

								</select>
							</div>
							<div class="form-group mt-2">
								<label for="mo">Mobile No </label> <input type="text"
									class="form-control" id="mo" name="mo">
							</div>
							<div class="form-group mt-2">
								<label for="pass">Password</label> <input type="password"
									class="form-control" id="pass" name="pass">
							</div>
							<div class="d-flex justify-content-center mt-3 mb-3 ">
								<button type="submit" class="btn btn-primary ">Submit</button>

							</div>



						</form>

					</div>

				</div>
			</div>



		</div>
	</div>
</body>
</html>