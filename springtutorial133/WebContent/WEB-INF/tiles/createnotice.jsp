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

				<sf:input type="hidden" name="id" path="id"/>

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
						<button id="submit" name="submit" class="btn btn-primary">Save
							Notice</button>
					</div>
				</div>

			</fieldset>
		</sf:form>
	</div>
