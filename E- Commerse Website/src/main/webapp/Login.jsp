<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
	<link rel="stylesheet" href="style1.css">
</style>
<body>
	<div class="bg">
        <div id="form">
	            <section id="head"><h1>	Login</h1></section>
	            <section id="content">
		            <form action="login" method="post">
		                <table>
		                    <tr>
		                        <td>E-mail</td>
		                        <td><input type="text" name="email"></td>
		                    </tr>
		                    <tr>
		                        <td>Password</td>
		                        <td><input type="password" name="pass"></td>
		                    </tr>
		                    <tr >
			                    <% String message = (String)request.getAttribute("msg"); %>
								<%if(message != null){ %>
								<h4><%= message %></h4>
								<% } %>
							</tr>
		                	<tr>
		                    	<td>
		                    		<input type="submit" id="sub">
		                    	</td>
		                    </tr>
		                 </table>
		            </form>
	        	</section>
        </div>
    </div>
</body>
</html>