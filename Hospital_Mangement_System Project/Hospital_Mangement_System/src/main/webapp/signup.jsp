<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Register</title>
<%@include file="componant/allcss.jsp"%>

<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 3);
}
</style>
</head>
<body>
<%@include file="componant/navbar.jsp"%>


<!-- User Register Form  -->
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4 mt-4">
				<div class="card paint-card">
					<div class="card-body">
						<h1 class="fs-4 text-center">User Login</h1>
						<span class=" text-danger text-center">${msg }</span>
						<span class=" text-danger text-center">${err }</span>

						<form action="userregister" method="post">
						    
						    <div class="form-group mt-2">
								<label for="name">Full name </label> <input type="text"
									class="form-control" id="name" name="name">
							</div>
						
						
							<div class="form-group mt-2">
								<label for="email">Email </label> <input type="email"
									class="form-control" id="email" name="email">
							</div>
							<div class="form-group mt-2">
								<label for="pass">Password</label> <input type="password"
									class="form-control" id="pass" name="pass">
							</div>
							<div class="d-flex justify-content-center mt-3 mb-3 ">
								<button type="submit" class="btn btn-primary ">Submit</button>

							</div>
							<p>Already Registered?<a href="User_login.jsp" class="text-decoration-none">Login</a></p>

						</form>



					</div>


				</div>


			</div>


		</div>


	</div>


</body>
</html>