<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@	taglib prefix="spring"	uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<link rel="shortcut icon" href="<c:url value="/resources/images/favicon.ico" />" />
		<link href="<c:url value ="/resources/css/main.css" />" rel="stylesheet" type="text/css">
		<%-- <link href="<c:url value ="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css">
		<link href="<c:url value ="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet" type="text/css"> --%>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
		<title><tiles:insertAttribute name="title" /></title>
	</head>
	<body>
		<div id="wrapper">
			<div id="topBar">
				<tiles:insertAttribute name="topBar" />
			</div>
			<div id="header">
				<tiles:insertAttribute name="header" />
			</div>
			<div id="mainContent">
				<div id="topBanners">
					<div id="topLeftBanner">
						<tiles:insertAttribute name="topLeftBanner" />
					</div>
					<div id="topRightBanner">
						<tiles:insertAttribute name="topRightBanner" />
					</div>
				</div>
				<div id="content">
					<tiles:insertAttribute name="mainContent" />
				</div>
			</div>
			<div id="footer">
				<tiles:insertAttribute name="footer" />
			</div>
		</div>
		<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<%-- <script src="<c:url value ="/resources/js/jquery-1.11.3.js" />" ></script>
		<script src="<c:url value ="/resources/js/bootstrap.min.js" />" ></script> --%>
	</body>
</html>