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

			<div class="col-md-12">
				<h1 class="text-center text-success mt-2">Doctor Details</h1>
				<hr>
				<p class="text-center fs-3">${msg }</p>
				<h3 class="text-center text-success">${update }</h3>
				<h3 class="text-center text-success">${del }</h3>
				<h3 class="text-center text-success">${err }</h3>
				<table class="table">

					<tr>

						<!--  <th>id</th>-->
						<th>Full name</th>
						<th>DOB</th>
						<th>email</th>
						<th>qualification</th>
						<th>specialist</th>
						<th>Mobile No</th>
						<th colspan="2">Action</th>


					</tr>

					<%
					DoctorDao dao2 = new DoctorDao();
					List<Doctor> list2 = dao2.getAllDoctor();
					for (Doctor d : list2) {
					%>
					<tr>

						<!-- <tdd.getId()d() %></td>-->
						<td><%=d.getName()%></td>
						<td><%=d.getDob()%></td>
						<td><%=d.getEmail()%></td>
						<td><%=d.getQualification()%></td>
						<td><%=d.getSpecialist()%></td>
						<td><%=d.getMobNo()%></td>
						<td><a href="edit_doctor.jsp?uid=<%=d.getId()%>"
							class="btn btn-warning">Edit</a></td>
						<td><a href="../deletedoctor?uid=<%=d.getId()%>"
							class="btn btn-success">Delete</a></td>





					</tr>

					<%
					}
					%>


				</table>



			</div>

		</div>
	</div>
</body>
</html>