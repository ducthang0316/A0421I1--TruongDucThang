<%--
  Created by IntelliJ IDEA.
  User: Duc Thang
  Date: 10/29/2021
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  </head>
  <body>
<%--  <c:redirect url = "/index.jsp"></c:redirect>--%>
  <h1>Danh sach khach hang </h1> <br>


<table class="table table-bordered">
  <tr>
    <th>ID</th>
    <th >Ten</th>
    <th>Ngay sinh</th>
    <th >Dia chi</th>
    <th>Anh</th>
  </tr>

  <c:forEach items="${customerList}" var="customer">
    <tr>
      <td>${customer.id}</td>
      <td>${customer.name}</td>
      <td>${customer.birthDate}</td>
      <td>${customer.address}</td>

      <c:choose>
        <c:when test="${customer.id == '1'}">
          <td><img src="https://demo.codegym.vn/web/15/gallery/img_fjords.jpg" alt="img" height="50px" width="50px"></td>
        </c:when>
        <c:when test="${customer.id == '2'}">
          <td><img src="https://demo.codegym.vn/web/15/gallery/img_forest.jpg" alt="img" height="50px" width="50px"></td>
        </c:when>
        <c:when test="${customer.id == '3'}">
          <td><img src="https://demo.codegym.vn/web/15/gallery/img_lights.jpg" alt="img" height="50px" width="50px"></td>
        </c:when>
        <c:when test="${customer.id == '4'}">
          <td><img src="https://demo.codegym.vn/web/15/gallery/img_mountains.jpg" alt="img" height="50px" width="50px"></td>
        </c:when>
        <c:when test="${customer.id == '5'}">
          <td><img src="https://demo.codegym.vn/web/15/gallery/img_fjords.jpg" alt="img" height="50px" width="50px"></td>
        </c:when>
        <c:otherwise>
          <td>img</td>
        </c:otherwise>
      </c:choose>
    </tr>
  </c:forEach>
</table>

  </body>
</html>
