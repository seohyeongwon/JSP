<%@page import="org.comstudy.SaramData"%>
<%@page import="org.comstudy.SaramDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int seq = Integer.parseInt(request.getParameter("seq") );

SaramDAO dao = new SaramDAO();
dao.delete(new SaramData(seq, null, null, 0));

response.sendRedirect("saram_data.jsp");
%>