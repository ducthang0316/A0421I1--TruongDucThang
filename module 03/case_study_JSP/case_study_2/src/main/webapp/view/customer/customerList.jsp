<%--
  Created by IntelliJ IDEA.
  User: Duc Thang
  Date: 11/17/2021
  Time: 4:45 PM
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

    <title>Customer</title>
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
                <input type="text" placeholder="Enter name" name="name" >
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

<%--                Search --%>

                <form class="form-horizontal" action="/customer?action=search" method="post">
                    <div class="control-group">
                        <div class="controls form-inline">
                            <label >Name</label>
                            <input type="text" name="name" class="input-small" placeholder="Enter Name" >

                            <label >Address</label>
                            <input type="text" name="address" class="input-small" placeholder="Enter address" >

                            <label >Type</label>
                            <select name="customerType">
                                <option selected value="">Choose...</option>
                                <c:forEach items="${typeList}" var="type">
                                    <option value="${type.id}">${type.typeName}</option>
                                </c:forEach>
                            </select>

                            <button type="submit" class="btn btn-primary mb-2">Search</button>
                        </div>
                    </div>
                </form>
                <table class="table">
                    <thead class="thead-light">
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Customer Type</th>
                        <th scope="col">Name</th>
                        <th scope="col">Birthday</th>
                        <th scope="col">Gender</th>
                        <th scope="col">Id Card</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Email</th>
                        <th scope="col">Address</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="customer1" items="${customerList}">
                        <tr>
                            <th scope="row"><c:out value="${customer1.id}"/></th>

                            <td>
                                <c:forEach items="${typeList}" var="type1">
                                    <c:if test="${ customer1.customerType == type1.id}">
                                      <span><c:out value="${type1.typeName}"/></span>
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td><c:out value="${customer1.name}"/></td>
                            <td><c:out value="${customer1.birthday}"/></td>
                            <td>
                                <c:if test="${customer1.gender == 0}">
                                    <c:out value="Nu"></c:out>
                                </c:if>
                                <c:if test="${customer1.gender == 1}">
                                    <c:out value="Nam"></c:out>
                                </c:if>
                            </td>
                            <td><c:out value="${customer1.idCard}"/></td>
                            <td><c:out value="${customer1.phone}"/></td>
                            <td><c:out value="${customer1.email}"/></td>
                            <td><c:out value="${customer1.address}"/></td>
                            <td>
                                <a href="/customer?action=edit&id=${customer1.id}">Edit</a>
                            </td>
                            <td>
<%--                                <button type="button"  class="btn btn-danger" onclick="duaDuLieuLenModal('${customer.id}','${customer.name}')"--%>
<%--                                        data-toggle="modal" data-target="#exampleModal">--%>
<%--                                    Delete--%>
<%--                                </button>--%>
                                <a href="/customer?action=delete&id=${customer1.id}"> Delete </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <a class="btn btn-primary" href="/customer?action=add" role="button">Add new customer</a>



            </div>

<%--            &lt;%&ndash;                modal delete&ndash;%&gt;--%>

<%--            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" >--%>
<%--                <div class="modal-dialog">--%>
<%--                    <form action="/customer?action=delete&id=${customer.id}" method="post">--%>
<%--                        <div class="modal-content">--%>
<%--                            <div class="modal-header">--%>
<%--                                <h5 class="modal-title" id="exampleModalLabel">Delete confirmation</h5>--%>
<%--                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                                    <span aria-hidden="true">&times;</span>--%>
<%--                                </button>--%>
<%--                            </div>--%>
<%--                            <div class="modal-body">--%>
<%--                                <input id="idCustomer" hidden name="id">--%>
<%--                                <span>Are you sure want to delete this customer: </span>--%>
<%--                                <span id="nameCustomer" >Name Customer </span>--%>
<%--                            </div>--%>
<%--                            <div class="modal-footer">--%>
<%--                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                                <button type="submit" class="btn btn-primary">OK</button>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </form>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <script>--%>
<%--                function duaDuLieuLenModal(id,name) {--%>
<%--                    document.getElementById("nameCustomer").innerText =name;--%>
<%--                    document.getElementById("idCustomer").value =id;--%>
<%--                }--%>
<%--            </script>--%>
<%--            &lt;%&ndash;                end modal&ndash;%&gt;--%>

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
