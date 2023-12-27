<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>addproduct</title>
<link rel="stylesheet" href="style2.css">
</head>
<body>
	<div id="bg">
		<div id="form">
			<div><h1>Add Product</h1></div>
			<div id="table">
				<form action="ap" method="post" enctype="multipart/form-data">
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
			                <td>PRICE</td>
			                <td><input type="text" name="price"></td>
			            </tr>
			            <tr>
			                <td>BRAND</td>
			                <td><input type="text" name="brand"></td>
			            </tr>
			            <tr>
			                <td>DISCOUNT</td>
			                <td><input type="text" name="dis"></td>
			            </tr>
			            <tr>
			                <td>IMAGE</td>
			                <td><input type="file" name="img"></td>
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