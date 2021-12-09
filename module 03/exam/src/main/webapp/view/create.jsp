<%--
  Created by IntelliJ IDEA.
  User: Duc Thang
  Date: 11/22/2021
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
<div class=>
    <c:if test="${mess != null}">
        <strong style="color: red">${mess}</strong>
    </c:if>
    <h4>Create New Product</h4>
    <form action="/product?action=add" method="post">

        <div class="form-group">
            <label>ID</label>
            <input type="text" class="form-control" name="id"  placeholder="Enter ID">
        </div>

        <div class="form-group">
            <label>Name</label>
            <input type="text" class="form-control" name="name" placeholder="Enter name">
        </div>

        <div class="form-group">
            <label>Price</label>
            <input type="text" class="form-control" name="price"  placeholder="Enter price">
        </div>

        <div class="form-group">
            <label>Quantity</label>
            <input type="text" class="form-control" name="quantity"  placeholder="Enter quantity">
        </div>

        <div class="form-group">
            <label>Color </label>
            <input type="text" class="form-control" name="color"  placeholder="Enter color">

        </div>

        <div class="form-group">
            <label>Description</label>
            <input type="text" class="form-control" name="description"  placeholder="Enter description">

        </div>

        <div class="form-group">
            <label>Category</label>
            <input type="text" class="form-control" name="idCategory"  placeholder="Enter category">

        </div>

        <br>
        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>
</div>
</body>
</html>
