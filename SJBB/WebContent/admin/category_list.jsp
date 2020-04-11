<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category List- Boat Administration</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<br>
	<br>
	<div align="center">
		<h2>Category Management</h2>
		<h3>
			<a href="category_form.jsp">Create New Category</a>
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
				<th>Category</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="category" items="${listCategory }" varStatus="status">
				<tr>
					<td>${status.index +1}</td>
					<td>${category.idCategory}</td>
					<td>${category.nameCategory}</td>
					
					<td><a href="edit_user?id=${category.idCategory}">Edit</a>&nbsp; 
					<a href="javascript:confirmDelete(${category.idCategory })">Delete</a></td>


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