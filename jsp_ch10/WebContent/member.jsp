<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
private String name;
private String age;
private String weight;
private String height;
private String sex;

%>
<%
request.setCharacterEncoding("UTF-8");
name= request.getParameter("name");
age= request.getParameter("age");
weight= request.getParameter("weight");
height= request.getParameter("height");
sex= request.getParameter("sex");

%>

name = <%=name %><br>
age = <%=age %><br>
weight = <%=weight %><br>
height = <%=height %><br>
sex = <%=sex %><br>

</body>
</html>