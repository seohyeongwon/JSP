<%@page import="org.comstudy.myweb.dbcp.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.*"%>
<%@page import="javax.naming.*"%>
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
// Context initCtx = new InitialContext();
//Context envCtx = (Context) initCtx.lookup("java:comp/env");
// DataSource ds = (DataSource) envCtx.lookup("jdbc/BoardDB");

// Connection conn = ds.getConnection();

Connection conn = JdbcUtil.getConnection();

out.println(conn);

conn.close();
%>

</body>
</html>