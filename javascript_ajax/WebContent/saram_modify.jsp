<%@page import="org.comstudy.SaramData"%>
<%@page import="org.comstudy.SaramDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int seq = Integer.parseInt(request.getParameter("seq") );
String id = request.getParameter("id");
String name = request.getParameter("name");
int age = Integer.parseInt(request.getParameter("age") );

SaramDAO dao = new SaramDAO();
dao.update(new SaramData(seq, id, name, age));

response.sendRedirect("saram_data.jsp");
%>