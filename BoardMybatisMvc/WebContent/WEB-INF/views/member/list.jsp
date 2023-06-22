<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
	<h1>list</h1>

	<c:forEach var="board" items="${list }">
		<tr>
			<td>${member.num }</td>
			<td><a href="detail.do?num=${member.num }">${member.title }</a></td>
			<td>${member.author }</td>
			<td>${member.writeday }</td>
			<td>${member.readcnt }</td>
		</tr>
	</c:forEach>


</body>
</html>