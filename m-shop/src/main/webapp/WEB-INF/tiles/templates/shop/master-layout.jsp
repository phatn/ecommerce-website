<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@	taglib prefix="spring"	uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="m-shop - e-commerce site">
    <meta name="author" content="Phat Nguyen | phatnguyentanit@gmail.com">
    <meta name="keywords" content="">

    <title><tiles:insertAttribute name="title" /></title>

    <meta name="keywords" content="">

    <link href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100' rel='stylesheet' type='text/css'>

    <!-- styles -->
    <link href="<c:url value='/resources/css/font-awesome.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/animate.min.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/owl.carousel.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/owl.theme.css' />" rel="stylesheet">

    <!-- theme stylesheet -->
    <link href="<c:url value='/resources/css/style.default.css' />" rel="stylesheet" id="theme-stylesheet">

    <!-- your stylesheet with modifications -->
    <link href="<c:url value='/resources/css/custom.css' />" rel="stylesheet">

    <script src="<c:url value='/resources/js/respond.min.js' />" ></script>

    <link rel="shortcut icon" href="favicon.png">


</head>

<body>

    <!-- *** TOPBAR ***
 _________________________________________________________ -->
    <div id="top">
		<tiles:insertAttribute name="top-bar"/>
    </div>
    <!-- *** TOP BAR END *** -->


    <!-- *** NAVBAR ***
 _________________________________________________________ -->
	<div class="navbar navbar-default yamm" role="navigation" id="navbar">
		<tiles:insertAttribute name="nav-bar"/>
	</div>
    <!-- *** NAVBAR END *** -->
	<!-- /#navbar -->


    <div id="all">

        <div id="content">
			<tiles:insertAttribute name="content"/>
        </div>
        <!-- /#content -->



        <!-- *** FOOTER ***
 _________________________________________________________ -->
        <div id="footer" data-animate="fadeInUp">
			<tiles:insertAttribute name="footer"/>
		</div>
		<!-- /#footer -->
        <!-- *** FOOTER END *** -->
		
		
        <!-- *** COPYRIGHT ***
 _________________________________________________________ -->
        <div id="copyright">
			<tiles:insertAttribute name="copyright"/>
        </div>
        <!-- *** COPYRIGHT END *** -->

    </div>
    <!-- /#all -->


    <!-- *** SCRIPTS TO INCLUDE ***
 _________________________________________________________ -->
    <script src="<c:url value='/resources/js/jquery-1.11.0.min.js' />" ></script>
    <script src="<c:url value='/resources/js/bootstrap.min.js' />" ></script>
    <script src="<c:url value='/resources/js/jquery.cookie.js' />" ></script>
    <script src="<c:url value='/resources/js/waypoints.min.js' />" ></script>
    <script src="<c:url value='/resources/js/modernizr.js' />" ></script>
    <script src="<c:url value='/resources/js/bootstrap-hover-dropdown.js' />" ></script>
    <script src="<c:url value='/resources/js/owl.carousel.min.js' />" ></script>
    <script src="<c:url value='/resources/js/front.js' />" ></script>

</body>

</html>