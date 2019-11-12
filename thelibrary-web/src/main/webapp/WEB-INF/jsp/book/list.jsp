<%@page import="com.benfante.javacourse.thelibrary.core.model.Book"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="/WEB-INF/jsp/template/header.jsp"%>

<h1>Books</h1>
<c:if test="${!empty books}">
	<div id="books" col="row">
		<c:forEach var="book" items="${books}" varStatus="status">
			<div class="media my-3">
				<c:catch var="imgExists">
					<c:import url="/img/${book.id}.jpg" var="imgContent"/>
				</c:catch>
				<c:choose>
					<c:when test="${empty imgExists}">
						<c:url value="/img/${book.id}.jpg" var="imgUrl"/>
					</c:when>
					<c:otherwise>
						<c:url value="/img/library1.jpg" var="imgUrl"/>
					</c:otherwise>
				</c:choose>
				<img src="${imgUrl}" class="bookCover align-self-start mr-3"
					alt="${book.title}">
				<div class="media-body">
					<h5 class="mt-0">${book.title}</h5>
					<c:choose>
						<c:when test="${not empty book.authors}">
							<ul class="list-group list-group-horizontal">
								<c:forEach var="author" items="${book.authors}">
									<li class="list-group-item">${author.firstName} ${author.lastName}</li>
								</c:forEach>
							</ul>
						</c:when>
						<c:otherwise>
							<div>No authors</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</c:forEach>
	</div>
</c:if>

<%@include file="/WEB-INF/jsp/template/footer.jsp"%>
