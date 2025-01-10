<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login Page</title>
<%@include file="componant/allcss.jsp"%>

<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 3);
}
</style>

</head>
<body>
	<%@include file="componant/navbar.jsp"%>

	<!-- Admin Login Form  -->
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4 mt-4">
				<div class="card paint-card">
					<div class="card-body">
						<h1 class="fs-4 text-center">Admin Login</h1>
						<p class="fs-4 text-center text-danger">${alog }</p>
						<p class="fs-4 text-center text-danger">${logout }</p>

						<form action="admin" method="post">

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


						</form>



					</div>


				</div>


			</div>


		</div>


	</div>


</body>
</html>