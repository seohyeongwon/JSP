<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp" %>


	<h1>길동 반점 예약 리스트</h1>
	<table border="1"  class="table">
		<tr>
			<th>번호</th>
			<th>성명</th>
			<th>전화번호</th>
			<th>완납여부</th>
			<th>예약내용</th>
			<th>삭제</th>
		</tr>
	<c:forEach var="rowData" items="${list }">
		<tr>
			<td>${rowData.pno }</td>
			<td>${rowData.name }</td>
			<td>${rowData.phone }</td>
			<td>${rowData.rpay }</td>
			<td>${rowData.productVo.rtitle }-${rowData.productVo.rprice }원</td>
			<td><a href="delete?pno=${rowData.pno} ">삭제</a></td>
		</tr>
	</c:forEach>
	</table>

<%@ include file="/inc/bottom.jsp" %>