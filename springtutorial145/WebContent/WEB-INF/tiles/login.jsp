<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script type="text/javascript">

	$(document).ready(function() {
		$(j_username).focus();
	});

</script>

	<div class="col-md-6 col-md-offset-3">
		<form class="form-horizontal"
			action="${pageContext.request.contextPath}/j_spring_security_check"
			method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>Login</legend>

				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="j_username">Username</label>
					<div class="controls">
						<input id="j_username" name="j_username" placeholder=""
							class="input-xlarge" type="text">

					</div>
				</div>

				<!-- Password input-->
				<div class="control-group">
					<label class="control-label" for="j_password">Password</label>
					<div class="controls">
						<input id="j_password" name="j_password" placeholder=""
							class="input-xlarge" type="password">

					</div>
				</div>
				
				<!-- Remember me checkbox-->
				<div class="control-group">
					<label class="control-label" for="j_password">Remember Me &nbsp;</label>
					
						<input id="_spring_security_remember_me" name="_spring_security_remember_me"
							checked="checked" type="checkbox">

					
				</div>
				
				<div class="alert-danger">
					<c:if test="${param.error != null}">
						Incorrect Username or Password provided
					</c:if>
					
				</div>

				<!-- Button -->
				<div class="control-group">
					<label class="control-label" for="submit"></label>
					<div class="controls">
						<button id="submit" name="submit" class="btn btn-primary">Submit</button>
					</div>
				</div>

			</fieldset>
		</form>
		
		<p><a href="<c:url value='/newaccount' />">Create new account</a></p>

	</div>
