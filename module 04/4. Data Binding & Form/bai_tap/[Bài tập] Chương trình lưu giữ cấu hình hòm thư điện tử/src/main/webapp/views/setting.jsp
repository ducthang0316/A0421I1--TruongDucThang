<%--
  Created by IntelliJ IDEA.
  User: Duc Thang
  Date: 12/3/2021
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>
<h2>Settings</h2>
<form:form action="set" method="post" modelAttribute="setting">
    <table>
        <tr>
            <td><form:label path="language">Languages</form:label></td>
            <td>
                <form:select path="languge">
                    <form:option value="English">English</form:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                    <form:option value="Japanese">Japanese</form:option>
                    <form:option value="Chinese">Chinese</form:option>
                </form:select>
            </td>
        </tr>

        <tr>
            <td><form:label path="size">Page size</form:label></td>
            <td> Show <form:select path="size">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="25">25</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="100">100</form:option>
                </form:select> emails per page
            </td>
        </tr>

        <tr>
            <td><form:label path="filter">Spam filter</form:label></td>
            <td><form:checkbox path="filter"/> Enable spams filter </td>
        </tr>

        <tr>
            <td><form:label path="signature">Signature</form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>

        <tr>
            <td></td>
            <td>
                <input type="submit" value="Update">
<%--                <input type="submit" value="Cancel">--%>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
