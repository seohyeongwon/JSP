<%@page import="org.comstudy.member.model.MemberDAO"%>
<%@page import="org.comstudy.member.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>멤버 상세 보기</h1>
<%
MemberDTO member = (MemberDTO)request.getAttribute("member");
%>

<p><%=member.toString() %></p>
<hr />
<p>수정 | 삭제</p>
</body>
</html>