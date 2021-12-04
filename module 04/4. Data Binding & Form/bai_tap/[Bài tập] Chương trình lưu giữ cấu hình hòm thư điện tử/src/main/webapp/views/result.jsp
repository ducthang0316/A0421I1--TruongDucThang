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
<form:form action="set" method="post" modelAttribute="result">
    <table>
        <tr>
            <td><form:label path="language">Languages</form:label></td>
            <td>
                ${laguage}
            </td>
        </tr>

        <tr>
            <td><form:label path="size">Page size</form:label></td>
            <td> Show ${size} emails per page
            </td>
        </tr>

        <tr>
            <td><form:label path="filter">Spam filter</form:label></td>
            <td>
                <c:if test="${filter == true}">
                <c:out value="Enable"></c:out>
                </c:if>
                <c:if test="${filter == false}">
                    <c:out value="Disable"></c:out>
                </c:if>
                spams filter
            </td>
        </tr>

        <tr>
            <td><form:label path="signature">Signature</form:label></td>
            <td>
                <c:out value="${signature}"></c:out>
            </td>
        </tr>

    </table>
</form:form>
</body>
</html>
