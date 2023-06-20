<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Welcome to my page
<%
String name = request.getParameter("userName");
if(name==null || name.length()==0) {
%>
<jsp:forward page="handeit.jsp">
   <jsp:param value='<%=URLEncoder.encode("다시 입력하세요!", "UTF-8") %>' name="msg" />
</jsp:forward>
<%-- <jsp:include page="handeit.jsp"></jsp:include> --%>
<%
} // end of if
%>
<p>Hello <%=name %>!!!</p>
</body>
</html>