<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify</title>
</head>
<body>

	<form method="post" action="modify.do">
		<input type="hidden" size="50" maxlength="100" name="num"
			value="${board.num }">
		<table>

			<tr>
				<td width="100" align="right">작성자 :&nbsp;</td>
				<td><input type="text" size="20" maxlength="100" name="author"
					value="${board.author }" disabled></input></td>
			</tr>

			<tr>
				<td width="100" align="right">전자메일 :&nbsp;</td>
				<td><input type="text" size="30" maxlength="200" name="email"
					value="${board.email }" disabled></input></td>
			</tr>

			<tr>
				<td width="100" align="right">제목 :&nbsp;</td>
				<td><input type="text" size="67" maxlength="500" name="title"
					value="${board.title }"></input></td>
			</tr>

			<tr>
				<td width="100" align="right">내용 :&nbsp;</td>
				<td><textarea rows="10" cols="65" maxlength="4000"
						name="content">할말은??</textarea></td>
			</tr>
			
			<tr>
				<td width="100" align="right">&nbsp;</td>
				<td><input type="submit" value="저장" />
					<button>
						<a href="list.do" style="text-decoration: none">취소</a>
					</button></td>
			</tr>
		</table>
	</form>
</body>
</html>