<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="/WEB-INF/jsp/template/header.jsp"%>

<c:url value="/author" var="submitUrl" />

<c:choose>
	<c:when test="${not empty author}">
		<c:set var="authorId" value="${author.id}" />
		<c:set var="firstName" value="${author.firstName}" />
		<c:set var="lastName" value="${author.lastName}" />
	</c:when>
	<c:otherwise>
		<c:set var="authorId" value="${param.id}" />
		<c:set var="firstName" value="${param.firstName}" />
		<c:set var="lastName" value="${param.lastName}" />
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${empty authorId}">
		<h1>New Author</h1>
	</c:when>
	<c:otherwise>
		<h1>Edit Author</h1>
	</c:otherwise>
</c:choose>

<form action="${submitUrl}" method="post" class="m-3">
	<input name="id" value="${authorId}" type="hidden">
	<div class="form-group">
		<label for="firstNameField">First name:</label> <input
			id="firstNameField" type="text" name="firstName" value="${firstName}"
			class="form-control">
	</div>
	<div class="form-group">
		<label for="lastNameField">Last name:</label> <input
			id="lastNameField" type="text" name="lastName" value="${lastName}"
			class="form-control">
	</div>
	<div class="form-group">
		<input type="submit" value="Save" class="btn btn-primary" />
	</div>
</form>


<%@include file="/WEB-INF/jsp/template/footer.jsp"%>
