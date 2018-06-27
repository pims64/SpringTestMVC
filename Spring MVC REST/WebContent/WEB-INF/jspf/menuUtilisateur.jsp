<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="menu.title" /></title>
<link href="<c:url value="/static/css/styles.css" />" rel="stylesheet">
</head>
<body>
	<h2>
		<spring:message code="menu.header" />&nbsp;<sec:authentication property="principal.authorities"/>
	</h2>
	<div>
		<ul>
		<li><a href="<c:url value="/utilisateurcontroller/goToCreer" />"><spring:message code="menu.creer" /></a></li>
		<li><a href="<c:url value="/utilisateurcontroller/afficherListe" />"><spring:message code="menu.lister" /></a></li>
		</ul>
	</div>
	<div><a href="<c:url value="/logout" />"><spring:message code="menu.logout" /></a></div>
</body>
</html>