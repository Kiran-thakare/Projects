<%@page
	import="jakarta.security.auth.message.callback.PrivateKeyCallback.Request"%>
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

	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class=" card paint-card">
					<div class="card-body">
						<p class="text-center fs-3 text-success">Edit Doctor Details</p>

						<%
						int id = Integer.parseInt(request.getParameter("uid"));
						DoctorDao dao2 = new DoctorDao();
						Doctor dr = dao2.getDoctorById(id);
						%>



						<form action="../updatedoctor" method="post">

							<input type="hidden" name="id" value="<%=dr.getId()%>">

							<div class="form-group mt-2">
								<label for="name">Full name </label> <input type="text"
									class="form-control" id="name" name="name"
									value="<%=dr.getName()%>">
							</div>

							<div class="form-group mt-2">
								<label for="name">DOB </label> <input type="date"
									class="form-control" id="date" name="date"
									value="<%=dr.getDob()%>">
							</div>

							<div class="form-group mt-2">
								<label for="email">Email </label> <input type="email"
									class="form-control" id="email" name="email"
									value="<%=dr.getEmail()%>">
							</div>

							<div class="form-group mt-2">
								<label for="qual">Qualification </label> <input type="text"
									class="form-control" id="qual" name="qual"
									value="<%=dr.getQualification()%>">
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
									class="form-control" id="mo" name="mo"
									value="<%=dr.getMobNo()%>">
							</div>
							<div class="form-group mt-2">
								<label for="pass">Password</label> <input type="text"
									class="form-control" id="pass" name="pass"
									value="<%=dr.getPass()%>">
							</div>
							<div class="d-flex justify-content-center mt-3 mb-3 ">
								<button type="submit" class="btn btn-primary col-12 ">Update</button>

							</div>



						</form>

					</div>

				</div>
			</div>

		</div>
	</div>
</body>
</html>