<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="sumError.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int max = Integer.parseInt(request.getParameter("max"));
int sum = 0;
for(int i=1; i<=max; i++) {
   sum += i;
}
%>
<h2>합계출력</h2>
<h3>1부터 <%=max %>까지의 합은 <%=sum %>입니다.</h3>
</body>
</html>