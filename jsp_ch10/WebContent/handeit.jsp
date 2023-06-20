<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String msg = request.getParameter("msg");
if(msg != null) {
%>
   <p>경고한다이 : <%=URLDecoder.decode(msg, "UTF-8") %></p>
<%
}
%>
<p>죄송합니다. 로그인 하세요!</p>
<form action="hello.jsp" method="get">
   Name: <input type="text" name="userName"/>
   <input type="submit" value="submit" />
</form>
</body>
</html>