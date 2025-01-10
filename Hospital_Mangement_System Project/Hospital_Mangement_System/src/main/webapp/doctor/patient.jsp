<%@page import="com.dao.AppointmentDao"%>
<%@page import="com.entity.Appointment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.Doctor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient</title>
<%@include file="../componant/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 3);
}
</style>
</head>
<body>
	<%@include file="doctornavbar.jsp"%>

	<!-- Patient Table -->

	<div class="container p-3">
		<div class="row">

			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text-success">Appointment
							List</p>
						<h3 class="text-center text-primary">${Csuccess }</h3>
						<h3 class="text-center text-primary">${PFailed }</h3>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appoint Date</th>
									<th scope="col">Email</th>
									<th scope="col">Mobile No</th>
									<th scope="col">Diseases</th>
									<th scope="col">Status</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								Doctor dr = (Doctor) session.getAttribute("doc");
								AppointmentDao dao = new AppointmentDao();

								ArrayList<Appointment> list = dao.getAppointmentDr(dr.getId());

								out.println("Appointments fetched: " + list.size()); // DEBUG: Print count of fetched appointments  

								for (Appointment a : list) {
								%>
								<tr>
									<td><%=a.getName()%></td>
									<td><%=a.getGender()%></td>
									<td><%=a.getAge()%></td>
									<td><%=a.getAppoinDate()%></td>
									<td><%=a.getEmail()%></td>
									<td><%=a.getPhNo()%></td>
									<td><%=a.getDiseases()%></td>
									<td><%=a.getStatus()%></td>
									<td><a href="comment.jsp?id=<%=a.getId()%>"
										class="btn btn-success btn-sm">Comment</a></td>
								</tr>
								<%
								}
								%>




							</tbody>
						</table>

					</div>
				</div>
			</div>



		</div>
	</div>
</body>
</html>