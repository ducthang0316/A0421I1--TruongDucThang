<%--
  Created by IntelliJ IDEA.
  User: Duc Thang
  Date: 12/4/2021
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>
<h2>Settings</h2>

    <table border="1">
        <tr>
            <td>Languages</td>
            <td>Page size</td>
            <td>Spam filter</td>
            <td>Signature</td>
        </tr>

        <c:forEach items="${result}" var="set">
            <tr>
                <td>${set.language}</td>
                <td>${set.size}</td>
                <td>
                    <c:if test="${set.filter == true}">
                        <c:out value="Enable"></c:out>
                    </c:if>
                    <c:if test="${set.filter == false}">
                        <c:out value="Disable"></c:out>
                    </c:if>
                </td>
                <td>${set.signature}</td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>
