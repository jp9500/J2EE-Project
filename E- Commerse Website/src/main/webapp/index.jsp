<html>

<style>

body,#flex
{
	background-color: azure;
	display: flex;
	justify-content: center;
	align-items: center;
	gap: 50px;
}

button 
{
	padding: 15px 20px;
	font-size: x-large;
	border-radius: 5px;
	background-color: black;
	border: none;
}
a
{
	text-decoration: none;
	color: white;
}
#display{
	padding: 50px;
	color: red;
	text-align: center;
}
h1{
	font-family: sans-serif;
	padding: 20px;
}


</style>

<body>
	<div>
		<div><h1>Welcome to my Website</h1></div>
		<div id="flex">
			<button><a href="Login.jsp">Login</a></button>
			<button><a href="signUp.jsp">SignUp</a></button>
		</div>
		<div id="display">
			<% String message = (String)request.getAttribute("msg"); %>
			<%if(message != null){ %>
			<h4><%= message %></h4>
			<% } %>
		</div>
	</div>
</body>
</html>