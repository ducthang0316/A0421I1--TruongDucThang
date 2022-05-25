<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/11/2021
  Time: 10:23 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
          integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/template/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/template/css/style.css">
    <link rel="stylesheet" type="text/css" href="/template/datatables/css/dataTables.bootstrap4.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</head>
<body>
<%---------------------------------%>
<%------------Header---------------%>
<%---------------------------------%>
<div class="header-top row">
    <div class="logo col-lg-6">
        <img src="template/img/logo.png">
    </div>
    <div class="personal col-lg-6">
        <p>Tran Van Minh Nhat</p>
    </div>
</div>
<nav class="navbar navbar-expand-lg navbar-light header-navbar">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" style="color: #fff" href="/home">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" style="color: #fff" href="/employee">Employee</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" style="color: #fff" href="/customer">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" style="color: #fff" href="/service">Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" style="color: #fff" href="/contract">Contract</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" style="color: #fff" href="/contractDetail">Contract Detail</a>
            </li>
        </ul>
    </div>
    <form class="form-inline my-4 my-lg-2" style="margin-right: 30px">
        <input class="form-control mr-sm-4" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
</nav>
<%---------------------------------%>
<%------------Header---------------%>
<%---------------------------------%>


<%---------------------------------%>
<%------------content---------------%>
<%---------------------------------%>
<div class="content">
    <div class="sidebar">
        <div style="margin-left: 40px; margin-top: 40px;" class="card" style="width: 18rem;">
            <img src="/template/img/img1.jpg" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Furama resort</h5>
                <p class="card-text">Khu nghỉ dưỡng có 196 phòng được thiết kế theo phong cách truyền thống Việt Nam kết
                    hợp với phong cách Pháp, 2 tòa nhà 4 tầng có hướng nhìn ra biển, nhìn ra hồ bơi trong xanh và những
                    khu vườn nhiệt đới xanh tươi mát.</p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item"><a href="/customerUseService?action=list" style="text-decoration: none; cursor: pointer;"><h5
                        style="margin: 10px 3px">Customers use the service</h5></a></li>
                <li class="list-group-item"><a style="text-decoration: none; cursor: pointer;"><h5
                        style="margin: 10px 3px">List of attach services</h5></a></li>
            </ul>
            <div class="card-body">
                <a href="#" class="card-link">Card link</a>
                <a href="#" class="card-link">Another link</a>
            </div>
        </div>
    </div>
<%--    <div class="sidebar">--%>
<%--        <ul>--%>
<%--            <li><a href="#">Service</a>--%>
<%--&lt;%&ndash;                <ul class="sub-catalog">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <li><a href="#">Villa</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <li><a href="#">House</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <li><a href="#">Room</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </ul>&ndash;%&gt;--%>
<%--            </li>--%>
<%--            <li><a href="#">Attach Service</a>--%>
<%--&lt;%&ndash;                <ul class="sub-catalog">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <li><a href="#">pass</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <li><a href="#">pass</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <li><a href="#">pass</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </ul>&ndash;%&gt;--%>
<%--            </li>--%>
<%--            <li><a href="#">Pass</a></li>--%>
<%--            <li><a href="#">Pass</a></li>--%>
<%--            <li><a href="#">Pass</a></li>--%>
<%--            <li><a href="#">Pass</a></li>--%>
<%--            <li><a href="#">Pass</a></li>--%>
<%--            <li><a href="#">Pass</a></li>--%>
<%--            <li><a href="#">Pass</a></li>--%>
<%--            <li><a href="#">Pass</a></li>--%>
<%--            <li><a href="#">Pass</a></li>--%>
<%--        </ul>--%>
<%--    </div>--%>
    <div class="main-content">
        <table id="customerTable" class="table table-striped table-bordered table-hover table-responsive-md">
            <thead>
            <tr>
                <th colspan="8"><h3 style="font-family: sans-serif; text-align: center;">Customer List</h3></th>
            </tr>
            <tr style="background-color: #046056; color: #fff">
                <th>Name</th>
                <th>Birthday</th>
                <th>Gender</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th class="text-center">
                    <a href="/customer?action=create" style="color: #fff;"><i class="far fa-plus-square"></i></a>
                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${customerList}" var="customer">
                <tr>
                    <td>${customer.customer_name}</td>
                    <td>${customer.customer_birthday}</td>
                    <c:choose>
                        <c:when test="${customer.customer_gender == 0}">
                            <td>Male</td>
                        </c:when>
                        <c:when test="${customer.customer_gender == 1}">
                            <td>Female</td>
                        </c:when>
                    </c:choose>
                    <td>${customer.customer_phone}</td>
                    <td>${customer.customer_email}</td>
                    <td>${customer.customer_address}</td>
                    <td class="text-center">
                        <a href="/customer?action=update&id=${customer.customer_id}" style="color: #fff;"><i class="fas fa-edit text-primary"></i></a>
                        <a href="/customer?action=delete&id=${customer.customer_id}"><i class="far fa-trash-alt text-danger"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <form class="form-inline" action="/customer?action=search" method="post">
            <div class="form-group mx-sm-3 mb-2">
                <label class="sr-only">Customer name</label>
                <input type="text" name="customerName" class="form-control" placeholder="Customer name">
            </div>
            <div class="form-group mx-sm-3 mb-2">
                <label class="sr-only">Customer address</label>
                <input type="text" name="customerAddress" class="form-control" placeholder="Customer address">
            </div>
            <button type="submit" class="btn btn-primary mb-2" style="background-color: 046056;">Search</button>
        </form>
    </div>
</div>
<script src="/template/datatables/js/jquery.dataTables.min.js"></script>
<script src="/template/datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function() {
        $('#customerTable').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 10
        } );
    } );
</script>
<%---------------------------------%>
<%------------Content---------------%>
<%---------------------------------%>

<%---------------------------------%>
<%------------Footer---------------%>
<%---------------------------------%>
<footer class="text-center text-white" style="background-color: #caced1;">
    <!-- Grid container -->
    <div class="container p-4">
        <!-- Section: Images -->
        <section class="">
            <div class="row">
                <div class="col-lg-2 col-md-12 mb-4 mb-md-0">
                    <div
                            class="bg-image hover-overlay ripple shadow-1-strong rounded"
                            data-ripple-color="light"
                    >
                        <img
                                src="https://mdbootstrap.com/img/new/fluid/city/113.jpg"
                                class="w-100"
                        />
                        <a href="#!">
                            <div
                                    class="mask"
                                    style="background-color: rgba(251, 251, 251, 0.2);"
                            ></div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-2 col-md-12 mb-4 mb-md-0">
                    <div
                            class="bg-image hover-overlay ripple shadow-1-strong rounded"
                            data-ripple-color="light"
                    >
                        <img
                                src="https://mdbootstrap.com/img/new/fluid/city/111.jpg"
                                class="w-100"
                        />
                        <a href="#!">
                            <div
                                    class="mask"
                                    style="background-color: rgba(251, 251, 251, 0.2);"
                            ></div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-2 col-md-12 mb-4 mb-md-0">
                    <div
                            class="bg-image hover-overlay ripple shadow-1-strong rounded"
                            data-ripple-color="light"
                    >
                        <img
                                src="https://mdbootstrap.com/img/new/fluid/city/112.jpg"
                                class="w-100"
                        />
                        <a href="#!">
                            <div
                                    class="mask"
                                    style="background-color: rgba(251, 251, 251, 0.2);"
                            ></div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-2 col-md-12 mb-4 mb-md-0">
                    <div
                            class="bg-image hover-overlay ripple shadow-1-strong rounded"
                            data-ripple-color="light"
                    >
                        <img
                                src="https://mdbootstrap.com/img/new/fluid/city/114.jpg"
                                class="w-100"
                        />
                        <a href="#!">
                            <div
                                    class="mask"
                                    style="background-color: rgba(251, 251, 251, 0.2);"
                            ></div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-2 col-md-12 mb-4 mb-md-0">
                    <div
                            class="bg-image hover-overlay ripple shadow-1-strong rounded"
                            data-ripple-color="light"
                    >
                        <img
                                src="https://mdbootstrap.com/img/new/fluid/city/115.jpg"
                                class="w-100"
                        />
                        <a href="#!">
                            <div
                                    class="mask"
                                    style="background-color: rgba(251, 251, 251, 0.2);"
                            ></div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-2 col-md-12 mb-4 mb-md-0">
                    <div
                            class="bg-image hover-overlay ripple shadow-1-strong rounded"
                            data-ripple-color="light"
                    >
                        <img
                                src="https://mdbootstrap.com/img/new/fluid/city/116.jpg"
                                class="w-100"
                        />
                        <a href="#!">
                            <div
                                    class="mask"
                                    style="background-color: rgba(251, 251, 251, 0.2);"
                            ></div>
                        </a>
                    </div>
                </div>
            </div>
        </section>
        <!-- Section: Images -->
    </div>
    <!-- Grid container -->

    <!-- Copyright -->
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
        © 2020 Copyright:
        <a class="text-white" href="https://mdbootstrap.com/">MDBootstrap.com</a>
    </div>
    <!-- Copyright -->
</footer>
<%---------------------------------%>
<%------------Footer---------------%>
<%---------------------------------%>
</body>
</html>
