<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIT218 Secure Coding => Servlet Example</title>

<!-- Inline CSS -->
<style type ="text/css">.error {color:red}>
</style>

</head>
<body>

<form:form action="${pageContext.request.contextPath}/question-answer/processForm" modelAttribute="question">
	Question(*):<form:input path="question"/>
	<form:errors path="question" cssClass="error"/>
	<br><br>
	Answer(*):<form:input path="answer"/>
	<form:errors path="answer" cssClass="error"/>
	<br><br>
	Area(*):<form:input path="area"/>
	<form:errors path="area" cssClass="error"/>
	<br><br>	
	<input type="submit" value="Submit"/>
</form:form>

</body>
</html>