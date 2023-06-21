<%@page import="org.comstudy.myweb.board.BoardDAO_JDBC"%>
<%@page import="org.comstudy.myweb.board.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="org.comstudy.myweb.board.BoardDAO"%>
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
BoardDAO_JDBC boardDao = new BoardDAO_JDBC();
%>
<%
// insert 테스트
BoardDTO dto = new BoardDTO("Test01","Test01@aaa.com","test001","test001 content","1234");
boardDao.insert(dto);
%>

<%
// delete 테스트
//BoardDTO dto = new BoardDTO(6);
//boardDao.delete(dto);
%>

<%
//BoardDTO dto = new BoardDTO(3, "제목 수정", "내용 수정 테스트");
//boardDao.update(dto);
%>

<%
List<BoardDTO> list = boardDao.selectAll();
out.println(list);
%>
</body>
</html>