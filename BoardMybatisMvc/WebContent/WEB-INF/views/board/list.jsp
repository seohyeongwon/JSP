<%@page import="org.comstudy.myweb.board.BoardDTO"%>
<%@page import="java.util.List"%>
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
	<h1>자유 게시판</h1>
	<table width="100%" border="1">
		
		<tr>
			<th width="5%">num</th>
			<th width="50%">title</th>
			<th width="18%">author</th>
			<th width="20%">writeday</th>
			<th width="7%">readcnt</th>
		</tr>
		
		<c:forEach var="board" items="${list }">
			<tr>
				<td>${board.num }</td>
				<td><a href="detail.do?num=${board.num }">${board.title }</a></td>
				<td>${board.author }</td>
				<td>${board.writeday }</td>
				<td>${board.readcnt }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="write.do">글쓰기</a>
</body>
</html>