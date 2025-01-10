<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.User"%>
<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.AppointmentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Appointment</title>
<%@include file="componant/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 3);
}
</style>
</head>
<body>
	<%@include file="usernav.jsp"%>
	
	<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>

	<div class="container p-3">
		<div class="row">

			<div class="col-md-9">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text-success">Appointment
							List</p>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appoint Date</th>
									<th scope="col">Diseases</th>
									<th scope="col">Doctor Name</th>
									<th scope="col">Status</th>
								</tr>
							</thead>
							<tbody>
								<%
								User user = (User) session.getAttribute("user");
								AppointmentDao dao = new AppointmentDao();
								DoctorDao dao2 = new DoctorDao();
								List<Appointment> list = dao.getAllAppointment(user.getId());

								out.println("Appointments fetched: " + list.size()); // DEBUG: Print count of fetched appointments  

								for (Appointment a : list) {
									Doctor doc = dao2.getDoctorById(a.getDoctorId());
								%>
								<tr>
									<td><%=a.getName()%></td>
									<td><%=a.getGender()%></td>
									<td><%=a.getAge()%></td>
									<td><%=a.getAppoinDate()%></td>
									<td><%=a.getDiseases()%></td>
									<td><%=doc.getName()%></td>
									<td>
										<%
										if ("pending".equals(a.getStatus())) {
										%> <a href="#" class="btn btn-warning">pending</a> <%
 } else {
 %> <%=a.getStatus()%> <%
 }
 %>
									</td>
								</tr>
								<%
								}
								%>




							</tbody>
						</table>

					</div>
				</div>
			</div>

			<div class="col-md-3">
				<img alt="" src="img/dr7.jpg" height="300px" width="350">
			</div>

		</div>
	</div>

</body>
</html>