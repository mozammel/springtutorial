<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><tiles:getAsString name="title"></tiles:getAsString></title>

    <!-- Bootstrap core CSS -->
    
    <link href="<c:url value='/static/lib/bootstrap/css/bootstrap.min.css' />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value='/static/css/notices-main.css' />" rel="stylesheet">

    <script src="<c:url value='/static/js/jquery.min.js' />"></script>
    <script src="<c:url value='/static/lib/bootstrap/js/bootstrap.min.js' />"></script>
 
  </head>
<body>
	<div>
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>
	<div class="container">
		<tiles:insertAttribute name="content"></tiles:insertAttribute>
	</div>
	<div>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>

</body>
</html>