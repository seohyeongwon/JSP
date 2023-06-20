<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>현재 문서에 외부 파일 내용이 아래와 같이 삽입</p>

<br>
<%@ include file="inc/incl.jsp" %>
<br>
<jsp:include page="inc/incl.jsp"></jsp:include>


</body>
</html>