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

	<c:forEach var="gallery" items="${list }">
		<tr>
			<td>${gallery.num }</td>
			<td><a href="detail.do?num=${gallery.num }">${gallery.title }</a></td>
			<td>${gallery.author }</td>
			<td>${gallery.writeday }</td>
			<td>${gallery.readcnt }</td>
		</tr>
	</c:forEach>

</body>
</html>