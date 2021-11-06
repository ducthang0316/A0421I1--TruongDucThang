<%--
  Created by IntelliJ IDEA.
  User: Duc Thang
  Date: 11/5/2021
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search result</title>
</head>
<body>
<h1>Search result</h1>
<h5>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</h5>
<c:if test='${requestScope["product"] != null}'>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Status</th>
        </tr>

        <tr>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getStatus()}</td>
        </tr>
    </table>
</c:if>

<a href="/products">Back to product list</a>
</body>
</html>
