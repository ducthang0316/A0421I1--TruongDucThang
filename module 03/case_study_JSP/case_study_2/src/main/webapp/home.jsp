<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 21/11/2021
  Time: 11:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
    <link rel="stylesheet" type="text/css" href="template/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="template/css/style.css">
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
                <a class="nav-link active" aria-current="page" style="color: #fff" href="/contractDetail">Contract
                    Detail</a>
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
        <%--        <ul>--%>
        <%--            <li><a href="#">Service</a>--%>
        <%--                <ul class="sub-catalog">--%>
        <%--                    <li><a href="#">Villa</a></li>--%>
        <%--                    <li><a href="#">House</a></li>--%>
        <%--                    <li><a href="#">Room</a></li>--%>
        <%--                </ul>--%>
        <%--            </li>--%>
        <%--            <li><a href="#">Attach Service</a>--%>
        <%--                <ul class="sub-catalog">--%>
        <%--                    <li><a href="#">pass</a></li>--%>
        <%--                    <li><a href="#">pass</a></li>--%>
        <%--                    <li><a href="#">pass</a></li>--%>
        <%--                </ul>--%>
        <%--            </li>--%>
        <%--        </ul>--%>
    </div>
    <div class="main-content">
        <h4>Giới thiệu về khu nghĩ dưỡng Furama Đà Nẵng</h4>
        <p>Khu nghỉ dưỡng Furama, tọa lạc trên bãi biển Đà Nẵng, được coi là khu nghỉ dưỡng có uy tín nhất của Việt Nam,
            đã vinh dự đón tiếp những vị khách nổi tiếng của hoàng gia cũng như những chính trị gia. Khu nghỉ dưỡng là
            cửa ngỏ đi đến 3 Di sản thế giới được UNESCO công nhận: phố cổ Hội An, thánh địa Mỹ Sơn và cố đô Huế. Kiến
            trúc của Furama được pha trộn thiết kế truyền thống của Việt Nam và kiến trúc thời Pháp thuộc, được bố trí
            hài hòa với 198 phòng, mỗi dãy phòng là một thiên đường của sự sang trọng và khéo léo, từ những tông màu
            trang trí ấm áp và phòng tắm rộng bằng đá cẩm thạch với quạt trần và sàn gỗ đánh bóng.
        </p>
        <p>
            Furama được biết đến là nơi duy nhất cung cấp dịch vụ lặn biển tại Đà Nẵng, khu nghỉ dưỡng sẽ mang đến cho
            du khách thích khám phá vẻ đẹp của Đại Dương bằng việc lặn ở một trong các bãi biển sang trọng nhất thế
            giới, ngoài ra còn có các môn thể thao dưới nước khác như chèo thuyền, lướt sóng, trượt nước, mô tô nước và
            thuyền chuối. Một bể bơi nước ngọt khổng lồ được thiết kế ngay trung tâm của khu nghỉ dưỡng, biến khu nghỉ
            dưỡng nó trở thành một khu hoàn toàn tách biệt với thế giới bên ngoài, mang đến sự thư giãn trong bầu không
            khí thật dịu mát. Bên cạnh đó, dịch vụ spa của khu nghỉ dưỡng là nơi lý tưởng để cung cấp những phương pháp
            chăm sóc tốt nhất cho cơ thể và sắc đẹp của du khách hàng.
        </p>
        <p>
            Điểm nhấn của Café Indochine chính là sự đa dạng của các món ăn châu Á và sự độc đáo của các món ăn trên
            khắp thế giới, được trình bày vô cùng hấp dẫn bên trong thực đơn, nhà hàng Don Cipriani’s Italia với một sự
            lựa chọn khó bỏ qua của thực khách khi đến với các món ăn đậm nét truyền thống của Ý, nơi đây các món ăn
        </p>
        <p>
            Lluôn được chuẩn bị kỹ lưỡng cho thực khách và phong cách phục vụ hết sức chu đáo, cùng với đó….là thức uống
            được pha 1 cách công phu. Với không gian mở của quầy Bar và khu nhà hàng nằm cạnh hồ bơi đã tạo nên 1 trải
            nghiệm không nơi đâu có được. Nơi đây du khách sẽ có cảm nhận được sự ấm cúm của bầu không khí khi ngồi bên
            “ốc đảo xanh” đã được thiết kế để du khách có thể nhận ra sư lịch lãm, tiện nghi của khu nghỉ dưỡng khi
            thưởng thức các món ăn tại đây.
        </p>
        <p>
            Water Sport House ngay trong khuôn viên cung cấp các thiết bị lướt ván, chèo thuyền kayak trên biển và trượt
            nước. Resort cũng cung cấp các lớp học yoga và Thái Cực Quyền trên bãi biển. Những vị khách trẻ tuổi hơn có
            thể tận hưởng phòng chiếu phim và phòng trò chơi được trang bị máy Play Station 3.
        </p>
        <p>
            Café Indochine phục vụ một loạt các món ăn quốc tế và châu Á trong một khung cảnh thuộc địa Pháp. Ngoài ra
            còn có Don Cipriani, phục vụ các món ăn truyền thống của Ý. Hai Van Lounge là một trong 3 quán bar có buổi
            biểu diễn hàng đêm của các ban nhạc Philippines.
        </p>
    </div>
</div>
<%---------------------------------%>
<%------------content---------------%>
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
