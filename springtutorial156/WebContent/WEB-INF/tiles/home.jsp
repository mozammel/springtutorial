<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<div class="col-md-6 col-md-offset-3">
	<table class="table table-striped">
		<tr>
			<th>id</th>
			<th>Name</th>
			<th>Contact</th>
			<th>Notice</th>
		</tr>
		<c:forEach var="notice" items="${notices}">
			<tr>
				<td><c:out value="${notice.id}"></c:out></td>
				<td><c:out value="${notice.user.name}"></c:out></td>
				<td><a href="<c:url value='/message?uid=${notice.username}' />">
						contact
				</a></td>
				<td><c:out value="${notice.text}"></c:out></td>
			</tr>


		</c:forEach>
	</table>




	<c:choose>
		<c:when test="${hasNotice}">
			<a href="<c:url value='/createnotice' />">Edit or delete your
				current notice</a>
		</c:when>
		<c:otherwise>
			<a href="<c:url value='/createnotice' />">Add a new notice</a>
		</c:otherwise>
	</c:choose>


	<sec:authorize access="!isAuthenticated()">
		<p>
			<a href="<c:url value='/login' />">Log in</a>
		</p>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<p>
			<a href="<c:url value='/j_spring_security_logout' />">Log out</a>
		</p>
	</sec:authorize>

	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<p>
			<a href="<c:url value='/admin' />">Admin page</a>
		</p>
	</sec:authorize>

</div>

