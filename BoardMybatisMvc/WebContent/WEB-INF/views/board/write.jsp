<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
</head>
<body>

	<h1>글쓰기</h1>

	<form method="post" action="write.do">
		<table>
			<tr>
				<td width="100" align="right">작성자 :&nbsp;</td>
				<td><input type="text" size="20" maxlength="100" name="author"
					value="author"></input></td>
			</tr>

			<tr>
				<td width="100" align="right">전자메일 :&nbsp;</td>
				<td><input type="text" size="30" maxlength="200" name="email"
					value="email"></input></td>
			</tr>

			<tr>
				<td width="100" align="right">제목 :&nbsp;</td>
				<td><input type="text" size="67" maxlength="500" name="title"
					value="title"></input></td>
			</tr>

			<tr>
				<td width="100" align="right">비번 :&nbsp;</td>
				<td><input type="password" size="67" maxlength="500"
					name="password" value="1234"></input></td>
			</tr>

			<tr>
				<td width="100" align="right">내용 :&nbsp;</td>
				<td><textarea rows="10" cols="65" maxlength="4000"
						name="content">할말은??</textarea></td>
			</tr>

			<tr>
				<td width="50" align="right">&nbsp;</td>
				<td><input type="submit" value="저장" />
					<button>
						<a href="list.do" style="text-decoration: none">취소</a>
					</button></td>

			</tr>
		</table>

	</form>

</body>
</html>