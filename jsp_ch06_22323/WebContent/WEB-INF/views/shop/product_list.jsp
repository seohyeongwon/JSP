<%@page import="org.comstudy.myweb.shop.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product</title>
</head>
<body>

<h1>상품 목록</h1>
<table border="1" width="100%">
	<tr>
		<th>SEQ</th>
		<th>상품명</th>
		<th>가격</th>
		<th>상세보기</th>
	</tr>
<%
List<Product> pList = (List<Product>)request.getAttribute("productList");
if(pList != null) {
	for(int i=0; i<pList.size(); i++) {
		Product product = pList.get(i);
%>
	<tr>
		<td><%=product.getSeq() %></td>
		<td><%=product.getpName() %></td>
		<td><%=product.getPrice() %></td>
		<td><a href="product_detail.do?seq=<%=product.getSeq() %>">상세보기</a></td>
	</tr>
<%	
	}
}
%>
</table>
</body>
</html>