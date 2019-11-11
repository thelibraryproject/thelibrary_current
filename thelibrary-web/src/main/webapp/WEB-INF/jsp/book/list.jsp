<%@page import="com.benfante.javacourse.thelibrary.core.model.Book"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Library Books</title>
</head>
<body>
	<h1>Books</h1>
	<div>
		<ol>
			<c:forEach var="book" items="${books}">
				<li>${book.title}</li>
			</c:forEach>
		</ol>
	</div>
</body>
</html>