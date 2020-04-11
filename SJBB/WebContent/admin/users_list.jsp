<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage User- Boat Administration</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<br>
	<br>
	<div align="center">
		<h2>User Management</h2>
		<h3>
			<a href="user_form.jsp">Create New User</a>
		</h3>
	</div>
	<c:if test="${message !=null }">
	<div align="center">
		<h4><i>${message}</i></h4>
	</div>
	</c:if>
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Email</th>
				<th>Full name</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="user" items="${listUsers }" varStatus="status">
				<tr>
					<td>${status.index +1}</td>
					<td>${user.idCust}</td>
					<td>${user.email}</td>
					<td>${user.nameCust}</td>
					<td><a href="edit_user?id=${user.idCust}">Edit</a>&nbsp; 
					<a href="javascript:confirmDelete(${user.idCust })">Delete</a></td>


				</tr>

			</c:forEach>


		</table>

	</div>
	<div align="center"></div>


	<br>
	<br>
	<jsp:directive.include file="footer.jsp" />
	<script>
		function confirmDelete(idCust){
			if(confirm('Are you sure to delete the profile with ID'+ idCust +'?')){
				window.location='delete_user?id=' + idCust;
			}
		}
	
	</script>
</body>
</html>