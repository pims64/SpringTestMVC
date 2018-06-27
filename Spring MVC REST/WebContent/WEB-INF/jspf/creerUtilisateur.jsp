<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="utilisateur.title" /></title>
<link href="<c:url value="/static/css/styles.css" />" rel="stylesheet">
</head>
<body>
	<h2>
		<spring:message code="utilisateur.header" />
	</h2>
	<form method="POST" action="creer" modelAttribute="usr">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<form:label path="usr.civilite.id"><spring:message code="utilisateur.civilite" /></form:label>
		<form:select path="usr.civilite.id">
			<form:option value="" label="" />
			<form:options items="${civilites}" itemValue="id" itemLabel="abbreviation" />
		</form:select>
		<br>
		<form:label path="usr.nom"><spring:message code="utilisateur.nom" /><span class="required">*</span></form:label>
		<form:input path="usr.nom" />&nbsp;<form:errors path="usr.nom" cssClass="errors" />
		<br>
		<form:label path="usr.prenom"><spring:message code="utilisateur.prenom" /><span class="required">*</span></form:label>
		<form:input path="usr.prenom" />&nbsp;<form:errors path="usr.prenom" cssClass="errors" />
		<br>
		<form:label path="usr.email"><spring:message code="utilisateur.email" /><span class="required">*</span></form:label>
		<form:input path="usr.email" />&nbsp;<form:errors path="usr.email" cssClass="errors" />
		<br>
		<form:label path="usr.motDePasse"><spring:message code="utilisateur.motDePasse" /><span class="required">*</span></form:label>
		<form:password path="usr.motDePasse" />&nbsp;<form:errors path="usr.motDePasse" cssClass="errors" />
		<br>
		<form:label path="usr.role"><spring:message code="utilisateur.role" /></form:label>
		<form:select path="usr.role">
			<form:option value="" label="" />
			<form:options items="${roles}" itemValue="name" itemLabel="name" />
		</form:select>&nbsp;<form:errors path="usr.role" cssClass="errors" />
		<br>
		<form:label path="usr.adresse.rue"><spring:message code="adresse.rue" /></form:label>
		<form:input path="usr.adresse.rue" />
		<br>
		<form:label path="usr.adresse.codePostal"><spring:message code="adresse.codePostal" /><span class="required">*</span></form:label>
		<form:input path="usr.adresse.codePostal" />&nbsp;<form:errors path="usr.adresse.codePostal" cssClass="errors" />
		<br>
		<form:label path="usr.adresse.ville"><spring:message code="adresse.ville" /><span class="required">*</span></form:label>
		<form:input path="usr.adresse.ville" />&nbsp;<form:errors path="usr.adresse.ville" cssClass="errors" />
		<br>
		<input type="submit" value="<spring:message code="utilisateur.creer.submit" />" />
	</form>
	<h3><a href="<c:url value="/utilisateurcontroller/goToMenu" />"><spring:message code="menu.retour" /></a></h3>
</body>
</html>