<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Doctor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor DashBoard</title>
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


	<div class="container">

		<p class="text-center fs-3 mt-2">Doctor Dashboard</p>

		<p class="text-center text-success fs-3 mt-2">${succ }</p>

		<div class="row">
			<%
			DoctorDao dao = new DoctorDao();
			
			%>
			
		
			<div class="col-md-4 offset-2 mt-2">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fas fa-user-md fa-3x"></i><br>
						<p class="fs-4 text-center">
							Doctor<br><%=dao.countDoctor()%>
						</p>
					</div>

				</div>

			</div>

			<div class="col-md-4 mt-2">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fas fa-user-md fa-3x"></i><br>
						<p class="fs-4 text-center">
							Total Appointment<br><%=dao.countAppointmentByDrId(d.getId())%>
						</p>
					</div>

				</div>

			</div>




		</div>
	</div>

</body>
</html>