<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Here</title>
</head>

	<body align="center-left">
			<form action="registrationProcess" method="post">
				<div align="">

					<table>
					<tr><td>First Name :</td>
						<td><input type="text" name="first_name"></td>
					</tr>

					<tr><td>lastName :</td>
						<td><input type="text" name="last_name"></td>
					</tr>
					<tr>
						<td>Email :</td>
						<td><input type="text" name="email"></td>
					</tr>

					<tr>
						<td>Password :</td>
						<td><input type="password" name="passwrd"></td>
					</tr>
					
					</table><br>

					<input type="submit" value="submit">

				</div>
			</form>

	</body>

</html>