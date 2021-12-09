<%--
  Created by IntelliJ IDEA.
  User: Duc Thang
  Date: 11/22/2021
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div >
    <c:if test="${message != null}">
        <strong style="color: red">${message}</strong>
    </c:if>

    <%--                Search --%>

    <form  action="/product?action=search" method="post">
        <div >
            <div >
                <label >Name</label>
                <input type="text" name="name" class="input-small" placeholder="Enter Name" >

                <button type="submit" class="btn btn-primary mb-2">Search</button>
            </div>
        </div>
    </form>
    <table class="table" >
        <thead class="thead-light">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Product Name</th>
            <th scope="col">Price</th>
            <th scope="col">Quantity</th>
            <th scope="col">Color</th>
            <th scope="col">Description</th>
            <th scope="col">Category</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="product" items="${productList}">
            <tr>
                <th ><c:out value="${product.id}"/></th>

                <td>
                    <c:out value="${product.name}"/>
                </td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.quantity}"/></td>
                <td>
                    <c:out value="${product.color}"/>
                </td>
                <td><c:out value="${product.description}"/></td>
                <td><c:out value="${product.idCategory}"/></td>
                <td>
                    <a href="/product?action=edit&id=${product.id}">Edit</a>
                </td>
                <td>

                    <a href="/product?action=delete&id=${product.id}"> Delete </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-primary" href="/product?action=add" role="button">Add new customer</a>



</div>
</body>
</html>
