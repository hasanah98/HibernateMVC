<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new user</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<br>
	<br>
	<div align="center">
		<h2>
			<c:if test="${user != null}">
				Edit your profile.
			</c:if>
			<c:if test="${user == null }">
			
			    Create your profile.
			</c:if>
		</h2>
	</div>

	<div align="center">

		<c:if test="${user != null}">
			<form action="update_user" method="post"
				onsubmit="return validateFormInput()">
				
				<input type="hidden" name="idCust" value="${user.idCust }">
		</c:if>

		<c:if test="${user == null}">
			<form action="create_user" method="post"
				onsubmit="return validateFormInput()">
		</c:if>


		<table>
			<tr>
				<td align="right">Email:</td>
				<td align="left"><input type="text" name="txtemail" id="email"
					size="20" value="${user.email }" /></td>
			</tr>

			<tr>
				<td align="right">Full name:</td>
				<td align="left"><input type="text" name="txtname"
					id="fullname" size="20" value="${user.nameCust}" /></td>
			</tr>

			<tr>
				<td align="right">Password:</td>
				<td align="left"><input type="password" name="pass" id="pass"
					size="20" value="${user.password }" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="Save"> 
				<input type="button" value="Cancel" onclick="javascript:history.go(-1);">
				</td>
			</tr>
		</table>

		</form>
	</div>
	<div align="center"></div>


	<br>
	<br>
	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">
	function validateFormInput() {
		var fieldEmail = document.getElementById("email");
		var fieldFullname = document.getElementById("fullname");
		var fieldPass = document.getElementById("pass");

		if (fieldEmail.value.length == 0) {
			alert("Email is required");
			fieldEmail.focus();
			return false;
		}
		if (fieldFullname.value.length == 0) {
			alert("Name is required");
			fieldFullname.focus();
			return false;
		}
		if (fieldPass.value.length == 0) {
			alert("Password is required");
			fieldPass.focus();
			return false;
		}
		return true;
	}
</script>
</html>