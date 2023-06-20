<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
String user = "HONG";
request.setAttribute("user2", user);

%>
<jsp:useBean id="m" class="test.web.MemberBean" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="m"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- pageContext, request,session, application 등에 바인딩 된 데이터 사용 -->
<p>사용자 이름: ${m.name }</p>
<p>사용자 이름: <%=m.getName() %></p>
<p>user: ${user2 }</p>
<p>나이: ${m.age }</p>
<p>몸무게: ${m.weight }</p>
<p>키: ${m.height }</p>
<p>성별: ${m.sex }</p>

</body>
</html>