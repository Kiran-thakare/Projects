<%@page import="com.entity.Specalist"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.specialistDao"%>
<%@page import="com.entity.Doctor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EditProfile</title>

<%@include file="../componant/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 3);
}
</style>
</head>
<body>

	<%
	Doctor d = (Doctor) session.getAttribute("doc");

	if (d == null) {
		response.sendRedirect("../Doctor_login.jsp");

	}
	%>
	<%@include file="doctornavbar.jsp"%>


	<div class="container p-4">
		<div class="row">
			<div class="col-md-4 ">
				<div class="card paint-card">
					<p class="text-center fs-3">Change Password</p>
					<div class="card-body">
						<form action="../doctorChangePassword" method="post">
							<%
							String pass = (String) session.getAttribute("passcorrect");
							String incorrect = (String) session.getAttribute("incorrect");
							if (pass != null) {
							%>
							<h3 class="text-center text-success"><%=pass%></h3>
							<%
							} else if (incorrect != null) {
							%>

							<h3 class="text-center text-success"><%=incorrect%></h3>
							<%
							}
							%>

							<div class="mb-3">
								<label>Enter New Password</label> <input type="text"
									name="newPassword" class="form-control" required>
							</div>

							<div class="mb-3">
								<label>Enter Old Password</label> <input type="text"
									name="oldPassword" class="form-control" required>
							</div>
							<input type="hidden" value="${doc.id }" name="uid">
							<button class="btn btn-success col-md-12">Change
								Password</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-8">
				<div class="card paint-card">
					<div class="card-body">

						<p class="text-center fs-3 text-success">Edit Profile</p>

						<%
						String successmessage = (String) session.getAttribute("successmessage");
						if (successmessage != null) {
						%>
						<h3 class="text-center text-success"><%=successmessage%></h3>
						<%
						}
						%>



						<form action="../doctorupdateProfile" method="post">

							<input type="hidden" name="id" value="${doc.id }">
							<div class="form-group mt-1">
								<label for="name">Full name </label> <input type="text"
									class="form-control" id="name" name="name" value="${doc.name }">
							</div>

							<div class="form-group mt-1">
								<label for="name">DOB </label> <input type="date"
									class="form-control" id="date" name="date" value="${doc.dob }">
							</div>

							<div class="form-group mt-1">
								<label for="email">Email </label> <input type="email"
									class="form-control" id="email" name="email"
									readonly="readonly" value="${doc.email }">
							</div>

							<div class="form-group mt-1">
								<label for="qual">Qualification </label> <input type="text"
									class="form-control" id="qual" name="qual"
									value="${doc.qualification }">
							</div>
							<div class="form-group mt-1">
								<label for="name">Specialist </label> <select name="spec"
									class="form-control">
									<option>${doc.specialist}</option>
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
							<div class="form-group mt-1">
								<label for="mo">Mobile No </label> <input type="text"
									class="form-control" id="mo" name="mo" value="${doc.mobNo }">
							</div>

							<div class="d-flex justify-content-center mt-2 mb-3 ">
								<button type="submit" class="btn btn-primary ">Update</button>

							</div>



						</form>










					</div>


				</div>



			</div>
		</div>
	</div>
</body>
</html>