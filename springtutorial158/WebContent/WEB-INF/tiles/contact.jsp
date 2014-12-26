<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



	<div class="col-md-6 col-md-offset-3">
		<sf:form method="post" class="form-horizontal"
			commandName="message">
			<fieldset>
			
		
				<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
				<input type="hidden" name="_eventId" value="send" />

				<!-- Form Name -->
				<legend>Send Message</legend>

				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="name">Your Name</label>
					<div class="controls">
						<sf:input id="name" path="name" name="name"
							placeholder="enter name" class="input-xlarge" type="text" value="${fromName}" />
						<sf:errors path="name" cssClass="alert-danger"></sf:errors>
					</div>

				</div>
				
				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="email">Your Email</label>
					<div class="controls">
						<sf:input id="email" path="email" name="email"
							placeholder="enter email" class="input-xlarge" type="text"  value="${fromEmail}"/>
						<sf:errors path="email" cssClass="alert-danger"></sf:errors>
					</div>

				</div>
				
				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="subject">Subject</label>
					<div class="controls">
						<sf:input id="subject" path="subject" name="subject"
							placeholder="enter subject" class="input-xlarge" type="text" />
						<sf:errors path="subject" cssClass="alert-danger"></sf:errors>
					</div>

				</div>
				
				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="content">Content</label>
					<div class="controls">
						<sf:textarea id="content" path="content" name="content"
							placeholder="enter content" class="input-xlarge" type="text" />
						<sf:errors path="content" cssClass="alert-danger"></sf:errors>
					</div>

				</div>

		

				<!-- Button -->
				<div class="control-group">
					<label class="control-label" for="submit"></label>
					<div class="controls">
						<button id="submit" name="submit" class="btn btn-primary">Send</button>
					</div>
				</div>

			</fieldset>
		</sf:form>
	</div>

	