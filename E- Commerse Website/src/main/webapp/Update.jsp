<%@page import="java.util.Base64"%>
<%@page import="dto.Productdto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<link rel="stylesheet" href="style2.css">
<style>
 img{
    	height: 150px;
        width: 250px;
    }
</style>
<body>
	
	<div id="bg">
		<div id="form">
			<div><h1>Update Product</h1></div>
			<div id="table">
				<form action="update1" method="post" enctype="multipart/form-data">
					<table>
					
						<% Productdto products =(Productdto)request.getAttribute("products"); %>
					 	<tr>
			                <td>ID</td>
			                <td><input type="text" name="id" readonly="readonly" value="<%= products.getId() %>"></td>
			            </tr>
			            <tr>
			                <td>NAME</td>
			                <td><input type="text" name="name"  value="<%= products.getName() %>"></td>
			            </tr>
			            <tr>
			                <td>PRICE</td>
			                <td><input type="text" name="price"  value="<%= products.getPrice() %>"></td>
			            </tr>
			            <tr>
			                <td>BRAND</td>
			                <td><input type="text" name="brand"  value="<%= products.getBrand() %>"></td>
			            </tr>
			            <tr>
			                <td>DISCOUNT</td>
			                <td><input type="text" name="dis"  value="<%= products.getDiscount() %>"></td>
			            </tr>
			             <tr>
			                <td>IMAGE</td>
			                <td><input type="file" name="img"></td>
			            </tr>
			            <tr>
			             	<%String img = new String(Base64.getEncoder().encode(products.getImg())); %>
							<img src="data:image/jpeg;base64, <%= img %>">
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