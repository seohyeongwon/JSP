<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
</head>
<body>

	<h1>상세보기</h1>
	<table width="100%" border="1">
		<tr>
			<th width="5%">num</th>
			<th width="50%">title</th>
			<th width="18%">author</th>
			<th width="20%">writeday</th>
			<th width="7%">readcnt</th>
		</tr>
		
		<tr>
			<td>${member.num }</td>
			<td>${member.title }</td>
			<td>${member.author }</td>
			<td>${member.writeday }</td>
			<td>${member.readcnt }</td>
		</tr>
	
	
	</table>
			<p><a href="modify.do?num=${board.num}">수정</a> <a href="delete.do?num=${board.num}">삭제</a></p>
</body>
</html>