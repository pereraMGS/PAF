<%@ page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
<%
	if (request.getParameter("productCode") != null)
	{
		Product productObj = new Product();
		String stsMsg = productObj.insertProduct(request.getParameter("productCode"),
		request.getParameter("productName"),
		request.getParameter("productPrice"),
		request.getParameter("productDesc"));
		
		session.setAttribute("statusMsg", stsMsg);
	}
%>


<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" href = "styles.css">
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<h1>Add Product</h1>
	
	<form method="post" action="Product.jsp">
  <div class="form-group">
    <label for="exampleInputProductCode">Product Code</label>
    <input type="text" class="form-control" id="exampleInputProductCode">
  </div>
  <div class="form-group">
    <label for="exampleInputProductName">Product Name</label>
    <input type="text" class="form-control" id="exampleInputProductName">
  </div>
  <div class="form-group">
    <label for="exampleInputProductPrice">Product Price</label>
    <input type="text" class="form-control" id="exampleInputProductPrice">
  </div>
  <div class="form-group">
    <label for="exampleInputproductDesc">Product Description</label>
    <input type="text" class="form-control" id="exampleInputproductDesc">
  </div>
  
    <button type="submit" class="btn btn-outline-success">ADD PRODUCT</button>
</form>

	<%
		out.print(session.getAttribute("statusMsg"));
	%>
	<br>
	<%
		Product productObj = new Product();
		out.print(productObj.readProduct()); 
	%>
</body>
</html>