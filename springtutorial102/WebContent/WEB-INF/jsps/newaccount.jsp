<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create new account</title>

<link
	href="${pageContext.request.contextPath}/static/lib/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css" />

</head>
<body>

	<div class="col-md-6 col-md-offset-3">
		<sf:form method="post" class="form-horizontal"
			action="${pageContext.request.contextPath}/createaccount"
			commandName="user">
			<fieldset>

				<!-- Form Name -->
				<legend>Create User</legend>

				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="name">Username</label>
					<div class="controls">
						<sf:input id="username" path="username" name="username"
							placeholder="enter name" class="input-xlarge" type="text" />
						<sf:errors path="username" cssClass="alert-danger"></sf:errors>
					</div>

				</div>

				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="email">Email</label>
					<div class="controls">
						<sf:input id="email" path="email" name="email"
							placeholder="enter valid email" class="input-xlarge" type="text" />
						<sf:errors path="email" cssClass="alert-danger"></sf:errors>

					</div>
				</div>

				<!-- Password input-->
				<div class="control-group">
					<label class="control-label" for="password">Password</label>
					<div class="controls">
						<sf:input id="password" path="password" name="password"
							class="input-xlarge" type="text" />
						<sf:errors path="password" cssClass="alert-danger"></sf:errors>

					</div>
				</div>

				<!-- Confirm Password input-->
				<div class="control-group">
					<label class="control-label" for="confirmpassword">Confirm
						Password</label>
					<div class="controls">
						<input id="confirmpassword" name="confirmpassword"
							class="input-xlarge" type="text" />
					</div>
				</div>

				<!-- Button -->
				<div class="control-group">
					<label class="control-label" for="submit"></label>
					<div class="controls">
						<button id="submit" name="submit" class="btn btn-primary">Create
							User</button>
					</div>
				</div>

			</fieldset>
		</sf:form>
	</div>

	<script>
		var password1 = document.getElementById('password');
		var password2 = document.getElementById('confirmpassword');

		var checkPasswordValidity = function() {
			if (password1.value != password2.value) {
				password1.setCustomValidity('Passwords must match.');
			} else {
				password1.setCustomValidity('');
			}
		};

		password1.addEventListener('change', checkPasswordValidity, false);
		password2.addEventListener('change', checkPasswordValidity, false);

		var form = document.getElementById('user');
		form.addEventListener('submit', function() {
			checkPasswordValidity();
			if (!this.checkValidity()) {
				event.preventDefault();
				//Implement you own means of displaying error messages to the user here.
				password1.focus();
			}
		}, false);
	</script>
</body>
</html>