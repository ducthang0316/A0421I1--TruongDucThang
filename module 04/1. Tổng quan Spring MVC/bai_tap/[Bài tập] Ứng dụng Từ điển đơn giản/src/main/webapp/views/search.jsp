<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Duc Thang
  Date: 11/29/2021
  Time: 7:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h1>Dictionary</h1>
<form action="find" method="post">
    Enter a word: <input type="text" name="word">
    <input type="submit" value="Search"><br>
    Result: <strong>${result}</strong>
    <span><c:if test="${mess!= null}">
        <strong><c:out value="${mess}"></c:out></strong>
    </c:if></span>
</form>
</body>
</html>
