<%@page import="java.io.IOException"%>
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
//선언부
//class의 메소드 or 필드 선언 부분
private String name ="qwe";
private void sayHello(JspWriter out) throws IOException{
	out.println(name+"'s hello");
}
%>

<%

//스크립트 릿
// _service() 메소드의 내부에 적용 되는 부분
// 메소드 내부이기 때문에 필드 선언 or 다른 메소드 선언불가능
out.println("<h1>hello world</h1>");
sayHello(out);



%>

<p>성명 : <%=name %></p>
<hr>
<%--
jsp 주석
쿼리스트링 형식으로 링크되는 페이지에 파라미터 전달
get,post, rest, pathparam...
-웹 프로그래밍 기술은 페이지와 페이지간에 데이터 전달이 중요!
forward
redirect

 --%>


<a href="info.jsp?name=<%=name%>&addr=seoul&age=36&job=asd">상세정보</a>

</body>
</html>