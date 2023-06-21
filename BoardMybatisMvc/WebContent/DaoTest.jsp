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
BoardDAO boardDao = new BoardDAO();
%>
<%
// insert 테스트
BoardDTO dto = new BoardDTO("Test11","Test11@aaa.com","test011","test011 content","1234");
boardDao.insert(dto);
// 1. BoardMapper에 id 엘리먼트 추가
// 2. BoardDAO에 mybatis사용
%>

<%
// delete 테스트
//BoardDTO dto = new BoardDTO(3);
//boardDao.delete(dto);
%>

<%
//BoardDTO dto = new BoardDTO(1, "제목 수정", "내용 수정 테스트");
//boardDao.update(dto);
%>

<%
List<BoardDTO> list = boardDao.selectAll();
out.println(list);
%>

<%
//BoardDTO board = boardDao.selectOne(new BoardDTO(3));
//out.println(board);
%>
</body>
</html>