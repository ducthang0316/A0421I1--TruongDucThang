<%--
  Created by IntelliJ IDEA.
  User: Duc Thang
  Date: 11/29/2021
  Time: 5:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Exchange Money</h1>
<form action="exchange" method="post">
    <h4>USD</h4>
    <input type="text" name="usd" placeholder="Enter Usd">
    <input type="submit" value="Exchange" >
    <h4>Result</h4>
    <input type="text" name="result" value="${result}">

</form>
</body>
</html>
