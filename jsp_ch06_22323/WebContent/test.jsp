<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>길동이의 홈페이지</h1>

<%
String user = application.getInitParameter("user");
%>

USER : <%=user %><br/>

<%
String realPath = application.getRealPath("./");
%>
realPath : <%=realPath %><br/>

</body>
</html>