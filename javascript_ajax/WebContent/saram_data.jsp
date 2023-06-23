<%@page import="org.comstudy.SaramDAO"%>
<%@page import="org.json.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.comstudy.SaramData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SaramDAO dao = new SaramDAO();
	List<SaramData> list = dao.selectAll();
	
	JSONArray jsonArr = new JSONArray(list);
	out.print(jsonArr.toString(2));
%>
