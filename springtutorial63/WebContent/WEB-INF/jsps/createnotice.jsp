<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="get" action="${pageContext.request.contextPath}/docreate">

	<table>
		<tr><td>Name:</td><td><input name="name" type="text" /></td></tr>
		<tr><td>Email:</td><td><input name="email" type="text" /></td></tr>
		<tr><td>Notice:</td><td><textarea rows="10" cols="10" name="text"></textarea> </td></tr>
		<tr><td>&nbsp;</td><td><input name="Create Notice" type="Submit"></td></tr>
	
	</table>


</form>
	
</body>
</html>