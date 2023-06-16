<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    String user= request.getParameter("user"); 
    String msg= request.getParameter("msg");
    
    %>
    {"user":"<%=user %>", "msg":"<%=msg%>"}