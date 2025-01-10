<%@page import="com.entity.Appointment"%>
<%@page import="com.dao.AppointmentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Comment Page</title>
<%@include file="../componant/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 3);
}
</style>
</head>
<body>
	<%@include file="doctornavbar.jsp"%>

	<div class="container p-3 mt-2">
		<div class="row">
			<div class="col-md-6 offset-3">
			

				<div class="card paint-card">

					<div class="card-body">
					<%
					int id=Integer.parseInt(request.getParameter("id"));
					AppointmentDao dao=new AppointmentDao();
					Appointment a=dao.getAppointmentById(id);
					request.setAttribute("appointment", a); 
					%>
					

						<form class="row" action="../updatestatus" method="post">
							<div class="form-group col-6">
								<label for="pname">Patient name</label> <input type="text"
									name=pname id="pname" value="${appointment.getName() }" class="form-control">
							</div>

							<div class="form-group col-6">
								<label for="age">Age</label> <input type="text" name=age
									id="age"  value="${appointment.getAge() }" class="form-control">
							</div>

							<div class="form-group col-6">
								<label for="pho">Mobile No</label> <input type="text" name=pho
									id="pho"  value="${appointment.getPhNo() }" class="form-control">
							</div>

							<div class="form-group col-6">
								<label for="dis">Diseases</label> <input type="text" name=dis
									id="dis"  value="${appointment.getDiseases() }" class="form-control">
							</div>

							<div class="form-group col-12">
								<label for="comment">Comment</label>
								<textarea rows="3" cols="" class="form-control" id="comment"name="comment"></textarea>
							</div>

							<input type="hidden" name="id" value="${appointment.getId() }"> <input type="hidden"
								name="did" value="${appointment.getDoctorId() }">
							<button class="btn btn-primary col-12 mt-2">Submit</button>
						</form>
					</div>
				</div>

			</div>


		</div>



	</div>
</body>
</html>