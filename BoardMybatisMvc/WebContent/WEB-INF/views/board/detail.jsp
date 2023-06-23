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
				<td width="100" align="right">작성자 :&nbsp;</td>
				<td><input type="text" size="20" maxlength="100" name="author"
					value="${board.author }" disabled></td>
			</tr>

			<tr>
				<td width="100" align="right">전자메일 :&nbsp;</td>
				<td><input type="text" size="30" maxlength="200" name="email"
					value="${board.email }" disabled></td>
			</tr>

			<tr>
				<td width="100" align="right">제목 :&nbsp;</td>
				<td><input type="text" size="67" maxlength="500" name="title"
					value="${board.title }" disabled></td>
			</tr>

			<tr>
				<td width="100" align="right">내용 :&nbsp;</td>
				<td><textarea rows="10" cols="65" maxlength="4000"
						name="content" value="${board.content }" disabled>${board.content }</textarea></td>
			</tr>
	
	
	</table>
			<p><a href="modify.do?num=${board.num}">수정</a> <a href="delete.do?num=${board.num}">삭제</a></p>
</body>
</html>