
<%@page import="com.entity.User"%>
<%@page import="com.entity.Doctor"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.DoctorDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Appointment</title>
<%@include file="componant/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 3);
}
</style>
</head>
<body>
	<%@include file="usernav.jsp"%>



	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-6">
				<img alt="dr_img" src="img/dr7.jpg " height="500px">
			</div>

			<div class="col-md-6">
				<div class="card paint-card">
					<div class="card-body">
						<h1 class="text-center text-success">User Appointment</h1>
						<h3 class="text-center text-success">${success }</h3>
						<h3 class="text-center text-success">${failed }</h3>
						<form class="row g-3" action="addappointment" method="post">
		
						
							<input type="hidden" name="uid" value="${user.id }">
							<div class="col-md-6">
								<label for="name">FullName </label> <input type="text"
									class="form-control" id="name" name="name">
							</div>
							<div class="col-md-6">
								<label>Gender</label> <select class="form-control" name="gender">
									<option value="male">Male</option>
									<option value="female">Female</option>
								</select>

							</div>

							<div class="col-md-6">
								<label for="age">Age </label> <input type="text"
									class="form-control" id="age" name="age">
							</div>

							<div class="col-md-6">
								<label for="date">Appointment Date </label> <input type="date"
									class="form-control" id="date" name="date">
							</div>

							<div class="col-md-6">
								<label for="email">Email </label> <input type="email"
									class="form-control" id="email" name="email">
							</div>

							<div class="col-md-6">
								<label for="phone">Phone </label> <input type="text"
									class="form-control" id="phone" name="phone">
							</div>
							<div class="col-md-6">
								<label for="diseases">Diseases</label> <input required
									type="text" class="form-control" id="diseases" name="diseases">
							</div>

							<div class="col-md-6">
								<label for="inputPassword4">Doctor</label> <select required
									class="form-control" name="doct">
									<option value="">--select--</option>
									<%
									DoctorDao dao = new DoctorDao();
									List<Doctor> list = dao.getAllDoctor();
									for (Doctor d : list) {
									%>


									<option value="<%=d.getId()%>"><%=d.getName()%>(<%=d.getSpecialist()%>)
									</option>



									<%
									}
									%>
								</select>
							</div>
							<div class="col-md-12">
								<label>Full Address</label>
								<textarea required name="address" class="form-control" rows="3"
									cols=""></textarea>
							</div>
							
								<%
								 User user=(User)session.getAttribute("user"); 
								 if(user==null){%>
									 <a href="User_login.jsp" class="btn btn-primary"> submit</a>
								<% }else{ %>
								<button class="btn btn-primary col-12">submit</button>
							<%} %>
						</form>
					</div>

				</div>
			</div>
		</div>


	</div>
</body>
</html>