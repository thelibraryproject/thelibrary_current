<%@page import="com.benfante.javacourse.thelibrary.core.model.Book"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="/WEB-INF/jsp/template/header.jsp"%>

<c:url value="/author" var="newAuthorUrl"/>

<h1>Authors</h1>
<div class="m-3">
	<a href="${newAuthorUrl}" class="btn btn-primary" role="button">New author</a>
</div>
<c:if test="${!empty authors}">
	<div id="authors" col="row">

		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">First name</th>
					<th scope="col">Last name</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="author" items="${authors}" varStatus="status">
					<c:url value="/author" var="editAuthorUrl">
						<c:param name="id" value="${author.id}"/>
					</c:url>
					<tr>
						<th scope="row">${status.count}</th>
						<td>${author.firstName}</td>
						<td>${author.lastName}</td>
						<td><a href="${editAuthorUrl}" class="btn btn-primary" role="button">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</c:if>

<%@include file="/WEB-INF/jsp/template/footer.jsp"%>
