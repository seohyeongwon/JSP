<%@page import="org.comstudy21.travel.model.ReservationVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
	<h1>예약 내역 조회</h1>
	<table class="table">
		<tr style="background-color: orange;">
			<th>예약번호</th>
			<th>주민번호</th>
			<th>성명</th>
			<th>성별</th>
			<th>전화번호</th>
			<th>여행상품</th>
			<th>상태</th>
			<th>금액</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="rowData" items="${reservationList }">
		<tr>
			<td>${rowData.rno }</td>
			<td>${rowData.rjumin }</td>
			<td>${rowData.rname }</td>
			<td><%
				ReservationVO vo = (ReservationVO)pageContext.getAttribute("rowData");
				String jumin = vo.getRjumin();
				char genderCode = jumin.charAt(6);
				if(genderCode=='1' || genderCode=='3') {
					out.println("남");
				} else {
					out.println("여");
				}
			%></td>
			<td>${rowData.rphone1 }-${rowData.rphone2 }-${rowData.rphone3 }</td>
			<td>${rowData.travelVO }</td>
			<td>${rowData.rstat=="F"?"미납":"완납" }</td>
			<td>${rowData.travelVO.tmoney }</td>
			<td><a href="delete?rno=${rowData.rno}">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
	<p><a href="input">예약 등록</a> | <a href="<%=request.getContextPath()%>">Home</a></p>
</div>
</body>
</html>