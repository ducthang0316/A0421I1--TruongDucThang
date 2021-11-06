<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Duc Thang
  Date: 11/5/2021
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new product</title>
</head>
<body>
<h5>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message"> ${requestScope["message"]}</span>
    </c:if>
</h5>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
 <fieldset>
     <legend>Product information</legend>
     <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
         <tr>
             <td>Price</td>
             <td><input type="text" name="price" id="price"></td>
         </tr>
         <tr>
             <td>Status</td>
             <td><input type="text" name="status" id="status"></td>
         </tr>
         <tr>
             <td></td>
             <td><input type="submit" value="Create new product"></td>
         </tr>
     </table>
 </fieldset>
</form>
</body>
</html>
