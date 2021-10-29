<%--
  Created by IntelliJ IDEA.
  User: Duc Thang
  Date: 10/29/2021
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Product Discount Calculator</h2>
  <form action="/calculate" method="post">
    <label> Product Description </label> <br>
    <input type="text" name="product" placeholder="Enter product name"> <br>
    <label> List Price </label><br>
    <input type="text" name="price" placeholder="Enter product price"><br>
    <label>Discount Percent</label><br>
    <input type="text" name="percent" placeholder="Enter discount percent"><br>
    <input type="submit" id="submit" value="Calculate">
  </form>
  </body>
</html>
