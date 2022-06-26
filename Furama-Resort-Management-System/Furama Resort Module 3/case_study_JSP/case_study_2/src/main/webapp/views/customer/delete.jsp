<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 13/11/2021
  Time: 4:43 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Customer</title>
    <link rel="stylesheet" type="text/css" href="/template/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/template/css/style.css">
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
<%--                &lt;%&ndash;                <ul class="sub-catalog">&ndash;%&gt;--%>
<%--                &lt;%&ndash;                    <li><a href="#">Villa</a></li>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                    <li><a href="#">House</a></li>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                    <li><a href="#">Room</a></li>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                </ul>&ndash;%&gt;--%>
<%--            </li>--%>
<%--            <li><a href="#">Attach Service</a>--%>
<%--                &lt;%&ndash;                <ul class="sub-catalog">&ndash;%&gt;--%>
<%--                &lt;%&ndash;                    <li><a href="#">pass</a></li>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                    <li><a href="#">pass</a></li>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                    <li><a href="#">pass</a></li>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                </ul>&ndash;%&gt;--%>
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
        <form action="/customer?action=delete" method="post">
            <div>
                <h3 style="font-family: sans-serif; text-align: center;">Delete Customer</h3>
            </div>
            <input name="customer_id" type="hidden" value="${customer.customer_id}">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label>Name</label>
                    <input type="text" class="form-control" name="customer_name" value="${customer.customer_name}" readonly>
                </div>
                <div class="form-group col-md-3">
                    <label>Gender</label>
                    <input type="text" class="form-control" name="customer_gender" value="${customer.customer_gender}" readonly>
                </div>
                <div class="form-group col-md-3">
                    <label>Customer Type</label>
                    <input type="text" class="form-control" name="customer_type_id" value="${customer.customer_type_id}" readonly>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label>Birthday</label>
                    <input type="text" class="form-control" name="customer_birthday"
                    value="${customer.customer_birthday}" readonly>
                </div>
                <div class="form-group col-md-6">
                    <label>Identity Card</label>
                    <input type="text" class="form-control" name="customer_id_card"
                           value="${customer.customer_id_card}" readonly>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label>Phone</label>
                    <input type="text" class="form-control" name="customer_phone" value="${customer.customer_phone}" readonly>
                </div>
                <div class="form-group col-md-6">
                    <label>Email</label>
                    <input type="text" class="form-control" name="customer_email" value="${customer.customer_email}" readonly>
                </div>
            </div>
            <div class="form-group">
                <label>Address</label>
                <input type="text" class="form-control" name="customer_address" value="${customer.customer_address}" readonly>
            </div>
<%--            <button type="submit" style="background-color: #046056; color: #fff;" class="btn">Delete</button>--%>
            <button type="button" style="background-color: #046056; color: #fff;" class="btn" onclick="putDataToModal('${customer.customer_id}')"
                    data-toggle="modal" data-target="#modal-delete">
                Delete
            </button>
        </form>
    </div>
</div>
<%--Modal--%>
<div class="modal fade" id="modal-delete">
    <div class="modal-dialog">
        <form action="/customer?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Delete</h4>
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input id="customer_id" hidden name="customer_id">
                    <input id="nameCustomer" hidden>
                    <span>Are you sure to delete this customer</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-success">OK</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function putDataToModal(id, name) {
        document.getElementById("nameCustomer").innerText = name;
        document.getElementById("customer_id").value = id;
    }
</script>
<%--Modal--%>

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
