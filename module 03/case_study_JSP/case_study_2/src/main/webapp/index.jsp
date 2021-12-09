<%--
  Created by IntelliJ IDEA.
  User: Duc Thang
  Date: 11/15/2021
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css\index_style.css">
    <title>Home</title>
  </head>
  <body>
  <div class="container-fluid">
<%--      header--%>
      <div class="row">
        <header>
          <nav class="navbar navbar-light bg-light">
            <a class="navbar-brand" href="#">
              <img src="img/img_4.jpg" width="70" height="70" alt="logo"/>
            </a>

            <p>Nguyen van A</p>
          </nav>
        </header>
      </div>

<%--navigation--%>
  <ul class="nav nav-pills nav-fill">
    <li class="nav-item">
      <a class="nav-link " href="#">Home</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Employee</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/customer">Customer</a>
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
           <li class="list-group-item"> <a href="#home">Home</a></li>
           <li class="list-group-item"><a href="#news">News</a></li>
           <li class="list-group-item"><a href="#contact">Contact</a></li>
           <li class="list-group-item"><a href="#about">About</a></li>
         </ul>
        </div>

<%--main content --%>

      <div class="col-sm-9">
        <h4><small>RECENT POSTS</small></h4>
        <hr>
        <h2>Tourism news</h2>
        <h5><span class="glyphicon glyphicon-time"></span> Post by Jane Dane, Nov 17, 2021.</h5>
        <h5><span class="label label-primary">Ipsum</span></h5><br>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
        <br><br>

        <h4><small>RECENT POSTS</small></h4>
        <hr>
        <h2>Booking guidance</h2>
        <h5><span class="glyphicon glyphicon-time"></span> Post by John Doe, Nov 17, 2021.</h5>
        <h5><span class="label label-primary">Lorem</span></h5><br>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
        <hr>

        <h4>Leave a Comment:</h4>
        <form role="form">
          <div class="form-group">
            <textarea class="form-control" rows="3" required></textarea>
          </div>
          <button type="submit" class="btn btn-success">Submit</button>
        </form>
        <br><br>
          </div>
        </div>
      </div>




<%--      footer--%>
  <footer>
    <div class="footer-copyright text-center text-black-50 py-3">
      <p class="dark-grey-text" > Furama Resort</p>
      <p>103 - 105 Vo Nguyen Giap Street, Khue My Ward, Ngu Hanh Son District, Danang City, Vietnam</p>
    </div>
  </footer>

  </div>
  </body>
</html>
