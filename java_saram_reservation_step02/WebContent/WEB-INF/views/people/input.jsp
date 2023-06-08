<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp" %>


	<h1>길동 반점 예약 접수</h1>
	<form action="" method="POST">
	<table class="table">
		<tr>
			<th>성명</th>
			<td><input type="text" name="name" value="홍길동" /> </td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="text" name="phone" value="010-2356-8749" /></td>
		</tr>
		<tr>
			<th>예약내용</th>
			<td>
				<select name="rno" id="rno">
					<c:forEach var="rowData" items="${productList }">
						<option value="${rowData.rno }">${rowData.rno }-${rowData.rtitle }-${rowData.rprice }원</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th>완납여부</th>
			<td>
				<input type="radio" name="rpay" value="T" />완납
				<input type="radio" name="rpay" value="F" checked />미납
			</td>
		</tr>
		<tr>
			<th colspan="2"><input type="submit" value="저장" /></th>
		</tr>
	</table>
	</form>

<%@ include file="/inc/bottom.jsp" %>