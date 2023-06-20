<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<style type="text/css">
div {
	border: 1px solid gray;
	/*margin: 3px;
   padding: 3px;*/
	border-radius: 7px;
	box-sizing: border-box;
}

#papg {
	width: 1000px;
}

#top {
	width: 100%;
	height: 150px;
}

#left {
	width: 20%;
}

#center {
	width: 80%
}

#left, #center {
	height: 300px;
	float: left;
}

#bottom {
	clear: both;
	height: 80px;
}

#topmenu>li {
	width: 150px;
	height: 40px;
	float: left;
}

#search {
	clear: both;
	display: flex;
	justify-content: center;
}
</style>
<%

String no="1";
if(request.getParameter("no")!=null){
	no= request.getParameter("no");
}
String main = "main" + no + ".jsp";
%>
	<div id="page">
		<div id="top">
			<jsp:include page="/inc/top.jsp"></jsp:include>
		</div>

		<div id="left">
			<jsp:include page="/inc/left.jsp"></jsp:include></div>

		<div id="center">
			<jsp:include page="<%=main %>"></jsp:include></div>

		<div id="bottom">
			<jsp:include page="/inc/bottom.jsp"></jsp:include></div>

	</div>

</body>
</html>