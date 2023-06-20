<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello</title>
</head>
<body>

<!-- HTML 주석 -->
<%
/*
자바 주석
*/%>

<%--
jsp주석
 --%>
 

<table>
<tr>
<td>Hello World!</td>
</tr>

</table>

<%
out.println(getServletContext().getRealPath("./"));

%>

</body>
</html>