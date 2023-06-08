<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>사람 정보 입력</h1>
	<form action="info.jsp">
		<table>
			<tr>
				<th>성명</th>
				<td><input name="name" value="qwe"></td>

			</tr>

			<tr>
				<th>주소</th>
				<td><input name="addr" value="대구"></td>

			</tr>

			<tr>
				<th>나이</th>
				<td><input name="age" value="16"></td>

			</tr>

			<tr>
				<th>직업</th>
				<td><input name="job" value="도둑"></td>

			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="전송"></td>
			</tr>
			
			
		</table>
	</form>



</body>
</html>