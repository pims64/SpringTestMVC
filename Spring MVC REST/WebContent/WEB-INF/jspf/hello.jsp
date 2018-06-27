<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="hello.title"/></title>
<link href="<c:url value="/static/css/styles.css" />" rel="stylesheet">
</head>
<body>
	<img alt="Spring logo" src="<c:url value="/static/images/spring.png" />" />
	<h2><c:out value="${message}" /></h2>
</body>
</html>