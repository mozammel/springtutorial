<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



	<p><a href="${pageContext.request.contextPath}/notices">Show current notices</a></p>	
	<p><a href="${pageContext.request.contextPath}/createnotice">Create Notice</a></p>	

	<sec:authorize access="!isAuthenticated()">
		<p><a href="<c:url value='/login' />">Log in</a></p>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
		<p><a href="<c:url value='/j_spring_security_logout' />">Log out</a></p>
	</sec:authorize>
	
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<p><a href="<c:url value='/admin' />">Admin page</a></p>
	</sec:authorize>



