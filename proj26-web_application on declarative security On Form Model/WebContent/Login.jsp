<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<title>Security web application page</title>
</head>
<body bgcolor="#cccc">
	<blockquote>
		<h2>please enter your username and password</h2>
		<p>
		<form method="post" action="j_security_check">
			<table border="1" align="center">
				<tr>
					<td>USERNAME::</td>
					<td><input type="text" name="j_username"
						placeholder="username"></td>
				</tr>
				<tr>
					<td>PASSWORD ::</td>
					<td><input type="text" name="j_password"
						placeholder="username"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</blockquote>
</body>
</html>