<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 목록</h1>
	<table border=1 width="100%">
		<tr>
			<th>이름</th>
			<th>나이</th>
			<th>몸무게</th>
			<th>키</th>
			<th>성별</th>
		</tr>
		<c:forEach var="mem" items="${requestScope.list }">
			<tr>
				<td><c:out value="${mem.name }"></c:out></td>
				<td><c:out value="${mem.age }"></c:out></td>
				<td><c:out value="${mem.weight }"></c:out></td>
				<td><c:out value="${mem.height }"></c:out></td>
				<td><c:out value="${mem.sex }"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>