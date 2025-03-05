<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap 5</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/style.css">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img src="images/logo1.png"
				height="50px">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#"
						style="color: white; font-size: 17px;">Add Course</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="view.html"
						style="color: white; font-size: 17px;">View Course</a></li>
				</ul>

			</div>
		</div>
	</nav>



	<h4>Course Management</h4>
	<form method="post" action="CourseServlet"> 
		<div class="container forn-dlt">
			<div class="row g-3 align-items-center">
				<div class="col-auto col-lg-4">
					<label for="inputPassword6" class="col-form-label">Course
						Name :</label>
				</div>
				<div class="col-auto col-lg-8">
					<input type="text" id="inputPassord6" class="form-control"
						aria-describedby="passwordHelpInline" name="coursename">
				</div>
			</div>

			<div class="row g-3 align-items-center">
				<div class="col-auto col-lg-4">
					<label for="inputPassword6" class="col-form-label">Course
						Duration :</label>
				</div>
				<div class="col-auto col-lg-8">
					<input type="text" id="inputPassword6" class="form-control"
						aria-describedby="passwordHelpInline" name="duration">
				</div>
			</div>

			<div class="row g-3 align-items-center">
				<div class="col-auto col-lg-4">
					<label for="inputPassword6" class="col-form-label">Category
						:</label>
				</div>
				<div class="col-auto col-lg-8">
					<select class="form-select" aria-label="Default select example" name="category">
						<option selected>Select Category</option>
						<option value="1">One</option>
						<option value="2">Two</option>
						<option value="3">Three</option>
					</select>
				</div>
			</div>


			<div class="row g-3 align-items-center">
				<div class="col-auto col-lg-4">
					<label for="inputPassword6" class="col-form-label">Course
						Fee :</label>
				</div>
				<div class="col-auto col-lg-8">
					<input type="text" id="inputPassword6" class="form-control"
						aria-describedby="passwordHelpInline" name = "fees">
				</div>
			</div>


			<div class="row g-3 align-items-centerr">
				<div class="col-auto col-lg-4">
					<label for="inputPassword6" class="col-form-label"></label>
				</div>
				<div class="col-auto col-lg-8">
					<input type="submit" value="Add Course" name="">
				</div>
			</div>

		</div>
	</form>
</body>
</html>