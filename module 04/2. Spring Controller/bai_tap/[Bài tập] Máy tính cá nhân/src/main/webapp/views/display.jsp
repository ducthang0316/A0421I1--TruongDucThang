<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Duc Thang
  Date: 12/2/2021
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator</h1>

<form action="calculate" method="post">
    <input type="text" name="first" placeholder="Enter the first number">

    <select name="operator">
        <option value="+">Addition (+)</option>
        <option value="-">Subtract (-)</option>
        <option value="*">Multiply (*)</option>
        <option value="/">Division (/)</option>
    </select>

    <input type="text" name="second" placeholder="Enter the second number">

    <input type="submit" value="Calculate">
</form>
<h4 style="color: red">
    <c:if test="${mess != null}">
        <c:out value="${mess}"></c:out>
    </c:if>
</h4>
<h3>Result: ${result}</h3>
</body>
</html>
