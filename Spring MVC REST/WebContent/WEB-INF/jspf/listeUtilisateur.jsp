<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="utilisateur.title" /></title>
<link href="<c:url value="/static/css/styles.css" />" rel="stylesheet">
</head>
<body>
	<h2>
		<spring:message code="utilisateur.liste.header" />
	</h2>
	<ul>
		<c:forEach items="${utilisateurs}" var="utilisateur">
			<li><c:out value="${utilisateur.civilite.abbreviation}" />&nbsp;<c:out value="${utilisateur.nom}" />&nbsp;
			<c:out value="${utilisateur.prenom}" />&nbsp;
			<a href="<c:url value="/utilisateurcontroller/goToModifier/${utilisateur.id}" />"><spring:message code="utilisateur.modifier" /></a>&nbsp;
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a href="<c:url value="/utilisateurcontroller/supprimer/${utilisateur.id}" />"><spring:message code="utilisateur.supprimer" /></a></li>
			</sec:authorize>
		</c:forEach>
	</ul>
	<h3>
		<a href="<c:url value="/utilisateurcontroller/goToMenu" />"><spring:message code="menu.retour" /></a>
	</h3>
</body>
</html>