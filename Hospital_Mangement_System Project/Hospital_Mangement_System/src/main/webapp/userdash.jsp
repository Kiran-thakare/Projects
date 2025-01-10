<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dash</title>
<%@include file="componant/allcss.jsp"%>
</head>
<body>
	<%@include file="usernav.jsp"%>


	<!-- Carousel add  -->



	<div id="carouselExample" class="carousel slide">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/img1.jpg" class="d-block w-100" alt="imgnotfound"
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/img3.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/img4.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExample" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExample" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

	<div class="container">
		<p class="text-center fs-2 mt-2">Key Features of Our Hospital</p>
		<div class="row">
			<div class="col-md-8 p-5 ">
				<div class="row">
					<div class="col-md-6">
						<div class="card paint-card">
							<div class="card-body">

								<p class="fs-5">100% Saftey</p>
								<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
									Nemo eius deserunt</p>
							</div>

						</div>
					</div>

					<div class="col-md-6">
						<div class="card paint-card">
							<div class="card-body">

								<p class="fs-5">Clean Environment</p>
								<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
									Nemo eius deserunt</p>
							</div>

						</div>
					</div>

					<div class="col-md-6 mt-2">
						<div class="card paint-card">
							<div class="card-body">

								<p class="fs-5">Friendly Doctors</p>
								<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
									Nemo eius deserunt</p>
							</div>

						</div>
					</div>
					<div class="col-md-6 mt-2">
						<div class="card paint-card">
							<div class="card-body">

								<p class="fs-5">Medical Reasearch</p>
								<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
									Nemo eius deserunt ?</p>
							</div>

						</div>
					</div>

				</div>
			</div>

			<div class="col-md-4 mt-5 ">
				<img alt="" src="img/img6.jpg" height="300px">
			</div>

		</div>
	</div>

	<hr>

	<div class="container p-2">
		<p class="text-center fs-2">Our Team</p>

		<div class="row">

			<div class="col-md-3">

				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/dr1.jpg" width="230px" height="300px">
						<p class="fw-bold fs-5">Dr.Ramkrushan</p>
						<p class="fs-7">(CEO & Chairman)</p>
					</div>

				</div>


			</div>

			<div class="col-md-3">

				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/dr4.jpg" width="230px" height="300px">
						<p class="fw-bold fs-5">Dr.Sakshi</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>

				</div>


			</div>


			<div class="col-md-3">

				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/d5.jpg" width="230px" height="300px">
						<p class="fw-bold fs-5">Dr.Sujata</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>

				</div>


			</div>

			<div class="col-md-3">

				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/dr2.jpg" width="230px" height="300px">
						<p class="fw-bold fs-5">Dr.Lalit</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>

				</div>


			</div>



		</div>

	</div>
	<%@include file="componant/footer.jsp"%>
</body>
</html>