<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>signup</title>
</head>
 <link rel="stylesheet" href="style.css">
<body>
	<div id="bg">
		<div id="form">
			<div><h1>SIGN UP</h1></div>
			<div id="table">
				<form action="signup" method="post">
					<table>
					 	<tr>
			                <td>ID</td>
			                <td><input type="text" name="id"></td>
			            </tr>
			            <tr>
			                <td>NAME</td>
			                <td><input type="text" name="name"></td>
			            </tr>
			            <tr>
			                <td>CONTACT</td>
			                <td><input type="text" name="con"></td>
			            </tr>
			            <tr>
			                <td>EMAIL</td>
			                <td><input type="text" name="email"></td>
			            </tr>
			            <tr>
			                <td>PASSWORD</td>
			                <td><input type="text" name="pass"></td>
			            </tr>
			            <tr>
			            	<td ><input type="submit" id="sub"></td>
			            </tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>