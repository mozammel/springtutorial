<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>



	<div class="col-md-6 col-md-offset-3">
		<sf:form method="post" class="form-horizontal"
			action="${pageContext.request.contextPath}/docreate"
			commandName="notice">
			<fieldset>

				<!-- Form Name -->
				<legend>Create Notice</legend>

				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="name">Name</label>
					<div class="controls">
						<sf:input id="name" path="name" name="name"
							placeholder="enter name" class="input-xlarge" type="text" />
						<sf:errors path="name" cssClass="alert-danger"></sf:errors>
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

				<!-- Textarea -->
				<div class="control-group">
					<label class="control-label" for="text">Notice</label>
					<div class="controls">
						<sf:textarea id="text" path="text" name="text"></sf:textarea>
						<sf:errors path="text" cssClass="alert-danger"></sf:errors>

					</div>
				</div>

				<!-- Button -->
				<div class="control-group">
					<label class="control-label" for="submit"></label>
					<div class="controls">
						<button id="submit" name="submit" class="btn btn-primary">Create
							Notice</button>
					</div>
				</div>

			</fieldset>
		</sf:form>
	</div>
