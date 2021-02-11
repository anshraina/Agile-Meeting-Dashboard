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
				<li> <a href="userDetails"><span class="fa fa-user"></span> User Details</a> </li>
				<li> <a href="EmailReaderServlet"><span class="fa fa-sticky-note"></span> Capture Notes</a> </li>
				
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
							<li class="nav-item"> <a class="nav-link" href="#">About</a> </li>
							<li class="nav-item"> <a class="nav-link" href="#">Portfolio</a> </li>
							<li class="nav-item"> <a class="nav-link" href="#">Contact</a> </li>
						</ul>
					</div>
				</div>
			</nav>
			<h2 class="mb-4">List of Tasks</h2>
			
			<table id="myTable" class="table table-hover">
			
		<tbody>
			<tr>
			<th> ID </th>
			<th> Task Name </th>
			<th> Issued Date </th>
			<th> Last Date </th>
			<th> Issued To </th>
			<th> Status </th>
			<th> Action </th>			
			</tr>
			
			<c:forEach var = "task" items = "${listTasks}">
			<tr>
			 	<td> <c:out value= "${task.id}" /></td>
			 	<td> <c:out value= "${task.name}" /></td>
			 	<td> <c:out value= "${task.issuedDate}" /></td>
			 	<td> <c:out value= "${task.lastDate}" /></td>
			 	<!-- <td> <c:out value= "${task.description}" /></td> -->
			 	<c:if test = "${task.assignedTo == 0}">
			 		<td> Not assigned </td>
			 	</c:if>
			 	<c:if test = "${task.assignedTo !=0 }">
			 		<td> <c:out value= "${task.assignedTo}" />
			 	</c:if>
			 	
			 	<!-- <td> <c:out value= "${task.assignedTo}" /></td> -->
			 	<c:if test = "${task.status == 'n' }">
			 		<td>Not completed</td>
			 	</c:if>
			 	<c:if test = "${task.status == 'c' }" >
			 		<td>Completed</td>
			 		</c:if>
			 	<td>
			 	
			 	<a class="btn btn-outline-success btn-sm" href = "edit?id=<c:out value ='${task.id}'/>" >Edit</a>
			 	&nbsp; &nbsp; &nbsp;
			 	<a class="btn btn-outline-danger btn-sm" href = "delete?id=<c:out value = '${task.id}'/>" >Delete</a>
			 	&nbsp; &nbsp; &nbsp;
			 	<c:if test = "${task.assignedTo == 0}">
			 	<button class = "btn btn-outline-primary btn-sm" value ="${task.id}" id="assign-btn" data-target="#assignModal" name = "assignButton"  data-toggle="modal" onclick = "myFunction(event)" > Assign task</button>
			 	</c:if>
			 	<c:if test = "${task.assignedTo != 0}">
			 	<span data-toggle="tooltip" data-placement="top" title="Task Already Assigned!">
			 	<button class = "btn btn-outline-primary btn-sm" value ="${task.id}" id="assign-btn" data-target="#assignModal" name = "assignButton"  data-toggle="modal" onclick = "myFunction(event)" disabled> Task Assigned</button>
			 	</span>
			 	</c:if>
			 </td>
			 </tr>
			 </c:forEach>
					
		</tbody>
		
	
	</table>

			
			
			
		</div>
		
	</div>
	
	<div class="modal fade" id = "assignModal">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="text-primary">Assign Task</h3>
					<button type = "button" class="close" data-dismiss="modal"> &times;</button>
				
				</div>
				<div class="modal-body">
					<form action ="assignTask" method="post">
						<div class="form-group">
							<label>Select Assignee: </label>
							<select name="members" >
							
								<c:forEach var = "member" items="${listMember}">
								<option
								value="${member.members_id}"> ${member.members_name}
								
					
								</option>
								
								</c:forEach>
													
							</select>
						<input type = "hidden" name = "taskId" id = "taskIdField">
						</div>
						<input type = "submit" value = "submit"/>
					</form>
				</div>
				
				<div class="modal-footer justify-content-center">
					<button class="btn btn-danger" data-dismiss="modal"> Close </button>
				
				</div>
			</div>
		
		</div>
	
	</div>

	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script>


function myFunction(event){
	
	var val = "";
	val = event.target.value;
	document.getElementById("taskIdField").value = val;
	
	//var name = document.getElementById("assign-btn").getAttribute("href");
	
}
$(document).ready(function () {
	console.log("buibj,nsdjlfnlksd");
    $("#myTable td:nth-child(6)").each(function () {
        if ($(this).text() == "Completed") {
            $(this).css("background-color", "#84ec84");
        }
        if ($(this).text() == "Not completed") {
            $(this).css("background-color", "#ff6838");
        }
    });
});
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="manager/js/jquery.min.js"></script>
	<script src="manager/js/popper.js"></script>
	<script src="manager/js/bootstrap.min.js"></script>
	<script src="manager/js/main.js"></script>
</body>

</html>