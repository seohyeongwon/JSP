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
	<h1>예약 등록</h1>
	<form action="input" method="POST">
		<table class="table"  style="width:550px;">
			<tr>
				<th>예약번호</th>
				<td><input type="text"  name="rno" value="20190001" /></td>
			</tr>
			<tr>
				<th>상품코드</th>
				<td><select name="tcode">
					<c:forEach var="rowData" items="${travelList }">
						<option value="${rowData.tcode }">${rowData.tcode } ${rowData.tarea } ${rowData.tdate } 출발</option>
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>주민번호</th>
				<td><input type="text" name="rjumin1" value="990101"/>-<input type="text" name="rjumin2" value="2000001"/></td>
			</tr>
			<tr>
				<th>예약자성명</th>
				<td><input type="text" name="rname" value="김고객2" /></td>
			</tr>
			<tr>
				<th>예약자전화</th>
				<td><input type="text" name="rphone1" size="4" value="010"/>-
				<input type="text" name="rphone2" size="4" value="1111"/>-
				<input type="text" name="rphone3" size="4" value="2221"/></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text"  name="remail" value="AA@hrd.co..kr"/></td>
			</tr>
			<tr>
				<th>결제상태</th>
				<td><input type="radio" name="rstat" value="F" />미납 <input type="radio" name="rstat" value="T" checked />완납</td>
			</tr>
			<tr>
				<th colspan="2" style="text-align:center;"><input type="submit" value="예약" /></th>
			</tr>
		</table>
	</form>
</div>
</body>
</html>