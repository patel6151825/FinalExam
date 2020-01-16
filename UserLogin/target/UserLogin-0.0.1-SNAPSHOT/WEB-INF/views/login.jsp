<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">

		<form:form action="login" method="post" modelAttribute="user">

			<table>
				<form:hidden path="id" />

				<tr>
					<td>email</td>
					<td><form:input path="email" /></td>
				</tr>

				<tr>
					<td>password</td>
					<td><form:input path="password" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Get Register"></td>
				</tr>

			</table>

		</form:form>

	</div>
</body>
</html>