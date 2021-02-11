	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agile Dashboard</title>
	<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="manager/css/style.css">
	<link rel="stylesheet" type="text/css" href="css/enableDisable.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" integrity="sha512-1PKOgIY59xJ8Co8+NE6FZ+LOAZKjy+KY8iq0G4B3CyeY6wYHN3yt9PW0XpSriVlkMXe40PTKnXrLnZ9+fkDaog==" crossorigin="anonymous" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>	
	
</head>
<body>

	<div class="wrapper d-flex align-items-stretch">
		<nav id="sidebar" class="active">
			<h2><a href="#" class="logo">.A.D.</a></h2>
			<ul class="list-unstyled components mb-5">
				<li class="active"> <a href="showLogs"><span class="fas fa-history fa-2x"></span> History</a> </li>
				
			</ul>
			
		</nav>
		<!-- Page Content  -->
		<div id="content" class="p-4 p-md-5">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">
					<button type="button" id="sidebarCollapse" class="btn btn-primary"> <i class="fa fa-bars"></i> <span class="sr-only">Toggle Menu</span> </button>
					<button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <i class="fa fa-bars"></i> </button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="nav navbar-nav ml-auto">
							<li class="nav-item active"> <a class="nav-link" href="home.jsp">Home</a> </li>
							<li class="nav-item"> <a class="nav-link" href="managerController?">Dashboard</a> </li>
							<li class="nav-item"> <a class="nav-link" href="#">Portfolio</a> </li>
							<li class="nav-item"> <a class="nav-link" href="#">Contact</a> </li>
						</ul>
					</div>
				</div>
			</nav>
			<h2 class="mb-4">History Details</h2>
			
			<table id="myTable" class="table table-hover">
			
		<tbody>
			<tr>
			<th> ID </th>
			<th> Task Name </th>
			<th> Assigned_To </th>
			<th> Deleted At</th>
					
			</tr>
			
			<c:forEach var = "log" items = "${logItems}">
			<tr>
			 	<td> <c:out value= "${log.idLog}" /></td>
			 	<td> <c:out value= "${log.task_name}" /></td>
			 	<td> <c:out value= "${log.assigned_to}" /></td>
			 	<td> <c:out value= "${log.deleted_at}" /></td>
			 </tr>
			 </c:forEach>
					
		</tbody>
		
	
	</table>
	
		</div>
		
	</div>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="manager/js/jquery.min.js"></script>
	<script src="manager/js/popper.js"></script>
	<script src="manager/js/bootstrap.min.js"></script>
	<script src="manager/js/main.js"></script>
</body>

</html>