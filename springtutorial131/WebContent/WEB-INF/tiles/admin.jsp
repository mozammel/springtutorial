<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    

<h3>Authorized users only</h3>
	<div class="col-md-6 col-md-offset-3">
		<table class="table table-striped">
			<tr>
				<th>Username</th>
				<th>Email</th>
				<th>Authority</th>
				<th>Enabled</th>
			</tr>
			<c:forEach var="user" items="${users}">
				<tr>
					<td><c:out value="${user.username}"></c:out></td>
					<td><c:out value="${user.email}"></c:out></td>
					<td><c:out value="${user.authority}"></c:out></td>
					<td><c:out value="${user.enabled}"></c:out></td>
				</tr>


			</c:forEach>
		</table>
	</div>

