<%--
  Created by IntelliJ IDEA.
  User: Duc Thang
  Date: 10/29/2021
  Time: 5:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Calculator</h2>
  <form action="/calculate" method="post">
    <input type="text" name="firstOperator" placeholder="enter first operator">
    <select name="operator" >
      <option value="+"> + </option>
      <option value="-"> - </option>
      <option value="*"> * </option>
      <option value="/"> / </option>
    </select>
    <input type="text" name="secondOperator" placeholder="enter second operator"> <br>
    <input type="submit" value="Calculate">
  </form>
  </body>
</html>
