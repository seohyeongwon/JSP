<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="test.web.BoardTO"%>
<%@ page import="java.sql.Timestamp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
<%
	ArrayList<BoardTO> list = (ArrayList<BoardTO>) request.getAttribute("list");
%>
	<table border=1>

		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>이메일</td>
			<td>날짜</td>
		</tr>
		<%
			for (int i = 1; i < list.size(); i++) {
			BoardTO data = (BoardTO) list.get(i);
			String num = data.getNum();
			String title = data.getTitle();
			String author = data.getAuthor();
			String email = data.getEmail();
			int writeday = data.getWriteday();
		%>
		<tr>
			<td><%=num%></td>
			<td><a href="${pageContext.request.contextPath }/detail.jsp"><%=title%></a></td>
			<td><%=author%></td>
			<td><%=email%></td>
			<td><%=writeday%></td>
		</tr>

		<%
			}
		%>
		
		

	</table>

</body>
</html>