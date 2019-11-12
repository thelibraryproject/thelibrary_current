<%@page import="com.benfante.javacourse.thelibrary.core.model.Book"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="/WEB-INF/jsp/template/header.jsp" %>

	<h1>Books</h1>
	<div>
		<c:if test="${!empty books}">
			<ol>
				<c:forEach var="book" items="${books}" varStatus="status">
					<c:choose>
						<c:when test="${status.index % 2 == 0}">
							<c:set var="color" value="green"/>
						</c:when>
						<c:otherwise>
							<c:set var="color" value="red"/>
						</c:otherwise>
					</c:choose>
					<li style="color: ${color};">${book.title}(${status.index})</li>
				</c:forEach>
			</ol>
		</c:if>
	</div>

<%@include file="/WEB-INF/jsp/template/footer.jsp" %>
