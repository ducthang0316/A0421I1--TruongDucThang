<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Duc Thang
  Date: 11/5/2021
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product List</h1>

<form action="/products?action=search" method="post">
    <input type="text" name="name" placeholder="Enter product name">
    <input type="submit" value="Search">
</form>

<p>
    <a href="/products?action=create">Create new product</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>Status</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>

<c:forEach items='${requestScope["product"]}' var="product">
<tr>
    <td><a href="/products?action=view&id=${product.getId()}">${product.getName()} </a> </td>
    <td>${product.getPrice()}</td>
    <td>${product.getStatus()}</td>
    <td><a href="/products?action=edit&id=${product.getId()}">Edit</a></td>
    <td><a href="/products?action=delete&id=${product.getId()}">Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>
