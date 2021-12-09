<%--
  Created by IntelliJ IDEA.
  User: Duc Thang
  Date: 11/20/2021
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Create Customer</title>
</head>
<body>
<div class="container-fluid">
    <%--      header--%>
    <div class="row">
        <header>
            <nav class="navbar navbar-light bg-light">
                <a class="navbar-brand" href="#">
                    <img src="/img/img_4.jpg" width="70" height="70" alt="logo"/>
                </a>

                <p>Nguyen van A</p>
            </nav>
        </header>
    </div>

    <%--navigation--%>
    <ul class="nav nav-pills nav-fill">
        <li class="nav-item">
            <a class="nav-link " href="/index.jsp">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Employee</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="customerList.jsp">Customer</a>
        </li>
        <li class="nav-item">
            <a class="nav-link " href="#">Service</a>
        </li>
        <li class="nav-item">
            <a class="nav-link " href="#">Contract</a>
        </li>
        <li class="nav-item">
            <form class="form-inline ">
                <input type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-primary" type="submit">Search</button>
            </form>
        </li>
    </ul>


    <%--      page content--%>

    <%--  side bar--%>
    <div class="container-fluid bg-light">
        <div class="row content">

            <div class="col-sm-3 sidebar ">
                <ul class="list-group ">
                    <li class="list-group-item"><a href="#home">Home</a></li>
                    <li class="list-group-item"><a href="#news">News</a></li>
                    <li class="list-group-item"><a href="#contact">Contact</a></li>
                    <li class="list-group-item"><a href="#about">About</a></li>
                </ul>
            </div>

            <%--main content --%>
            <div class="col-sm-9">
                <c:if test="${message != null}">
                    <strong style="color: red">${message}</strong>
                </c:if>
                <h4>Create New Customer</h4>
                <form action="/customer?action=add" method="post">

                    <div class="form-group">
                        <label>ID</label>
                        <input type="text" class="form-control" name="id" value="${oldCustomerData.id}" placeholder="Enter customer ID">
                    </div>

                    <div class="form-group">
                        <label>Customer type</label>
                        <select class="form-control" name="customerType">
                            <option value="1">Diamond</option>
                            <option value="2">Platinum</option>
                            <option value="3">Gold</option>
                            <option value="4">Silver</option>
                            <option value="5">Member</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" name="name" value="${oldCustomerData.name}" placeholder="Enter customer name">
                    </div>

                    <div class="form-group">
                        <label>Birthday</label>
                        <input type="date" class="form-control" name="birthday" value="${oldCustomerData.birthday}" placeholder="Enter customer birthday">
                        <span style="color: red">${birthdayMess}</span>
                    </div>

                    <div class="form-group">
                        <label>Gender</label>
                        <select class="form-control" name="gender">
                            <option value="0">Female</option>
                            <option value="1">Male</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>ID Card </label>
                        <input type="text" class="form-control" name="idCard" value="${oldCustomerData.idCard}" placeholder="Enter customer ID card">
                        <span style="color: red">${idCardMess}</span>
                    </div>

                    <div class="form-group">
                        <label>Phone number</label>
                        <input type="text" class="form-control" name="phone" value="${oldCustomerData.phone}" placeholder="Enter customer phone number">
                        <span style="color: red">${phoneMess}</span>
                    </div>

                    <div class="form-group">
                        <label>Email</label>
                        <input type="text" class="form-control" name="email" value="${oldCustomerData.email}" placeholder="Enter customer email">
                        <span style="color: red">${emailMess}</span>
                    </div>

                    <div class="form-group">
                        <label>Address</label>
                        <input type="text" class="form-control" name="address" value="${oldCustomerData.address}" placeholder="Enter customer address">
                    </div>
                    <br>
                    <button type="submit" class="btn btn-primary">Create</button>
                </form>
            </div>
        </div>
        <%--      footer--%>
        <footer>
            <div class="footer-copyright text-center text-black-50 py-3">
                <p class="dark-grey-text"> Furama Resort</p>
                <p>103 - 105 Vo Nguyen Giap Street, Khue My Ward, Ngu Hanh Son District, Danang City, Vietnam</p>
            </div>
        </footer>
    </div>
</body>
</html>
