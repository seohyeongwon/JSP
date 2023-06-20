<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="<%=request.getContextPath() %>">BOOK 24</a></h1>
	<ul id="topmenu">
		<li><a href="index.jsp?no=1">도서목록</a></li>
		<li><a href="index.jsp?no=2">베스트셀러</a></li>
		<li><a href="index.jsp?no=3">신간도서</a></li>
		<li><a href="index.jsp?no=4">회원리뷰</a></li>
		<li><a href="index.jsp?no=5">독자추천게시판</a></li>
	</ul>
	<div id="search">
		<form>
			<select>
				<option>전체</option>
				<option>문학</option>
				<option>사회</option>
			</select> <select>
				<option>제목</option>
				<option>저자</option>
				<option>출판사</option>
			</select> <input type="" name="" id="" /> <input type="button" value="검색" />
		</form>
	</div>

</body>
</html>