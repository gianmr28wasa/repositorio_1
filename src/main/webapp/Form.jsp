<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>I don't want</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
	integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</head>
<body>

	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Dropdown </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link disabled"
						aria-disabled="true">Disabled</a></li>
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>

	<h2>Form</h2>
	<form action="Servlet" name="form" method="post" actionresult="">
		<label>Nombre:</label> <input type="text" required
			placeholder="Nombre" name="nombre" id="nombre"><br> <br>
		<label>Apellido:</label> <input type="text" required
			placeholder="Apellido" name="apellido" id="apellido"><br>
		<br> <label>Edad:</label> <input type="number" required min="0"
			max="100" placeholder="Edad" name="edad" id="edad"><br>
		<br> <label>Oficio:</label> <input type="text" required
			placeholder="Oficio" name="oficio" id="oficio"><br> <br>
		<input type="button" onclick="registrar()">
	</form>

	<script type="text/javascript">
		function registrar() {
			let nombre = $("#nombre").val();
			let apellido = $("#apellido").val();
			let edad = $("#edad").val();
			let oficio = $("#oficio").val();

			let datos = {
				"nombre" : nombre,
				"apellido" : apellido,
				"edad" : edad,
				"oficio" : oficio
			}
			console.log(datos);
			$.post({
				type : "POST",
				url : 'Servlet',
				contentType : 'application/json; charset=UTF-8',
				dataType : "json",
				data : JSON.stringify(datos),
			}).done(function(data) {
				console.log(data);
				if (data.estado === "OK") {
					Swal.fire({
						  title: data.mensaje,
						  icon: "success"
						}).then((result) => {
							  console.log(result);
							  if (result.isConfirmed) {
							    location.reload()
							  }
							});
					console.log(data.mensaje);
				} else if (data.estado === "ERROR") {
					Swal.fire({
						  title: data.mensaje,
						  icon: "error"
						});
					console.log(data.mensaje);
				}
			}).fail(function() {
				console.log("error");
			});
		}
	</script>
</body>
</html>