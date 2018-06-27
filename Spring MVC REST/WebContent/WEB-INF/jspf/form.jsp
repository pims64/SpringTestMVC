<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title><c:out value="${pageTitle}" /></title>
<link href="<c:url value="/static/css/styles.css" />" rel="stylesheet">
</head>
<body>
	<h2><c:out value="${message}" /></h2>
	<form method="POST" action="bet" modelAttribute="bet">
		<form:label path="bet.scoreFrance">Score pour la France</form:label>
		<form:input path="bet.scoreFrance"/>
		<br>
		<form:label path="bet.scorePerou">Score pour le Pérou</form:label>
		<form:input path="bet.scorePerou"/>
		<br>
		<input type="submit" value="Bet!" />
	</form>
</body>
</html>