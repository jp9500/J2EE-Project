<%@page import="java.util.Base64"%>
<%@page import="dto.Productdto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
</head>
<style>
	*{
		padding: 0px;
		margin: 0px;
	}
	.flex{
		display: flex;
		justify-content: center;
	}
    table{
    	position : relative;
    	top : 80px;
    }
     th,td{
     	padding : 10px 10px;
        text-align: center;
    }
    table,td,th{
        border: 1px solid black; 
        border-collapse: collapse;
    }
    img{
    	height: 150px;
        width: 250px;
    }
    a{
    	text-decoration: none;
    }
    #del{
    	color: red;
	}
	button{
		background-color: black;
		padding: 15px 30px;
		position: relative;
		left : 550px;
		top: 50px;
		border: none;
	}
	#hr{
		color: white;
	}
	#col{
		color: red;
	}
	th{
		background-color: grey;
		color: black;
	}
	#lo{
		color: white;
	}
</style>
<body>
	<% HttpSession ses=request.getSession(); %>
	<% ses.setMaxInactiveInterval(30); %>
<div class="flex">
	<div>
		<div>
			<% String message = (String)request.getAttribute("msg"); %>
			<%if(message != null){ %>
			<h4><%= message %></h4>
			<% } %>
		</div>
		
		<button><a href="Addproduct.jsp" id="hr">Add Product</a></button>
		<button><a href="logout" id="lo">Logout</a></button>
		
		<table>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>PRICE</th>
				<th>BRAND</th>
				<th>DISCOUNT</th>
				<th>IMAGE</th>
				<th>DELETE</th>
				<th>UPDATE</th>
			</tr>
				<% List<Productdto> products=(List)request.getAttribute("products");%>
				<%for(Productdto p : products) { %>
				<tr>
					<td><%= p.getId() %></td>
					<td><%= p.getName() %></td>
					<td><%= p.getPrice()%></td>
					<td><%= p.getBrand() %></td>
					<td><%= p.getDiscount() %></td>
					
					<%String img = new String(Base64.getEncoder().encode(p.getImg())); %>
					<td><img src="data:image/jpeg;base64, <%= img %>"></td>
					
					<td><a href="delete?id=<%= p.getId() %>" id="col">Delete</a></td>
					<td><a href="update?id=<%= p.getId() %>">Update</a></td>
					
				</tr>
				<%}%>
		</table>
	</div>
</div>
</body>
</html>