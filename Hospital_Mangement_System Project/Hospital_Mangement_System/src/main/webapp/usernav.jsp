

<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	<div class="container-fluid">
		<a class="navbar-brand" href="Index.jsp"><i
			class="fa-solid fa-house-medical"></i> MEDI-HOME</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">


			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">

				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="user_appointment.jsp">APPOINTMENT</a></li>

				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="viewappointment.jsp">VIEW APPOINTMENT</a></li>

				<li class="nav-item"><form class="d-flex">
						<div class="dropdown">
							<button class="btn btn-light dropdown-toggle" type="button"
								id="dropdownMenuButton1" data-bs-toggle="dropdown"
								aria-expanded="false">
								<i class="fa-solid fa-user"></i> ${user.name }</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
								<li><a class="dropdown-item" href="changepassword.jsp">Change Password</a></li>
								<li><a class="dropdown-item" href="ulogout">Logout</a></li>
							</ul>
						</div>
					</form></li>




			</ul>

		</div>
	</div>
</nav>