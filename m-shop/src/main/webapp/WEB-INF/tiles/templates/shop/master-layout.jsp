<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title><tiles:insertAttribute name="title" /></title>

    <meta name="keywords" content="">

    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,500,700,800' rel='stylesheet' type='text/css'>

    <!-- Bootstrap and Font Awesome css -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Css animations  -->
    <link href="<c:url value='/resources/css/animate.css'/> " rel="stylesheet">

    <!-- Theme stylesheet, if possible do not edit this stylesheet -->
    <link href="<c:url value='/resources/css/style.default.css'/> " rel="stylesheet" id="theme-stylesheet">

    <!-- Custom stylesheet - for your changes -->
    <link href="<c:url value='/resources/css/custom.css' /> " rel="stylesheet">

    <!-- Responsivity for older IE -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

    <!-- Favicon and apple touch icons-->
    <link rel="shortcut icon" href="<c:url value='/resources/img/favicon.ico' /> " type="image/x-icon" />
    <link rel="apple-touch-icon" href="<c:url value='/resources/img/apple-touch-icon.png' />" />
    <link rel="apple-touch-icon" sizes="57x57" href="<c:url value='/resources/img/apple-touch-icon-57x57.png' /> " />
    <link rel="apple-touch-icon" sizes="72x72" href="<c:url value='/resources/img/apple-touch-icon-72x72.png' /> " />
    <link rel="apple-touch-icon" sizes="76x76" href="<c:url value='/resources/img/apple-touch-icon-76x76.png' /> " />
    <link rel="apple-touch-icon" sizes="114x114" href="<c:url value='/resources/img/apple-touch-icon-114x114.png'/> " />
    <link rel="apple-touch-icon" sizes="120x120" href="<c:url value='/resources/img/apple-touch-icon-120x120.png' /> " />
    <link rel="apple-touch-icon" sizes="144x144" href="<c:url value='/resources/img/apple-touch-icon-144x144.png' /> " />
    <link rel="apple-touch-icon" sizes="152x152" href="<c:url value='/resources/img/apple-touch-icon-152x152.png' /> " />
    <!-- owl carousel css -->

    <link href="<c:url value='/resources/css/owl.carousel.css' /> " rel="stylesheet">
    <link href="<c:url value='/resources/css/owl.theme.css' /> " rel="stylesheet">
</head>

<body>

    <div id="all">

        <header>

            <!-- *** TOP ***
_________________________________________________________ -->
            <div id="top">
				<tiles:insertAttribute name="top-bar"/>
            </div>

            <!-- *** TOP END *** -->

            <!-- *** NAVBAR ***
    _________________________________________________________ -->

            <div class="navbar-affixed-top" data-spy="affix" data-offset-top="200">

                <div class="navbar navbar-default yamm" role="navigation" id="navbar">
					<tiles:insertAttribute name="nav-bar"/>
                </div>
                <!-- /#navbar -->

            </div>

            <!-- *** NAVBAR END *** -->

        </header>

        <!-- *** LOGIN MODAL ***
_________________________________________________________ -->

        <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
			<tiles:insertAttribute name="login-modal"/>
        </div>

        <!-- *** LOGIN MODAL END *** -->

        <section>
            <!-- *** HOMEPAGE CAROUSEL ***
 _________________________________________________________ -->

            <div class="home-carousel">

                <div class="dark-mask"></div>
				<tiles:insertAttribute name="home-carousel"/>

            </div>

            <!-- *** HOMEPAGE CAROUSEL END *** -->
        </section>
		
		<div id="content">
			<tiles:insertAttribute name="content" />
		</div>
		<!-- /#content -->
		

        <!-- *** FOOTER ***
_________________________________________________________ -->

        <footer id="footer">
			<tiles:insertAttribute name="footer"/>
            <!-- /.container -->
        </footer>
        <!-- /#footer -->

        <!-- *** FOOTER END *** -->

        <!-- *** COPYRIGHT ***
_________________________________________________________ -->

        <div id="copyright">
			<tiles:insertAttribute name="copyright"/>
        </div>
        <!-- /#copyright -->

        <!-- *** COPYRIGHT END *** -->



    </div>
    <!-- /#all -->

    <!-- #### JAVASCRIPT FILES ### -->

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script>
        window.jQuery || document.write('<script src="<c:url value="/resources/js/jquery-1.11.0.min.js" /> "><\/script>')
    </script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

    <script src="<c:url value='/resources/js/jquery.cookie.js' /> "></script>
    <script src="<c:url value='/resources/js/waypoints.min.js' /> "></script>
    <script src="<c:url value='/resources/js/jquery.counterup.min.js'/> "></script>
    <script src="<c:url value='/resources/js/jquery.parallax-1.1.3.js' /> "></script>
    <script src="<c:url value='/resources/js/front.js' /> "></script>

    

    <!-- owl carousel -->
    <script src="<c:url value='/resources/js/owl.carousel.min.js'/> "></script>



</body>

</html>