<%@page import="org.comstudy.myweb.shop.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>

<h1>장바구니 목록</h1>
<table border="1" width="100%">
	<tr>
		<th>SEQ</th>
		<th>상품명</th>
		<th>가격</th>
		<th>수량</th>
		<th>합계</th>
		<th>제거</th>
	</tr>
<%
List<Product> pList = (List<Product>)request.getAttribute("cartList");
if(pList != null) {
	for(int i=0; i<pList.size(); i++) {
		Product product = pList.get(i);
		int total = product.getPrice() * product.getEa();
%>
	<tr>
		<td><%=product.getSeq() %></td>
		<td><%=product.getpName() %></td>
		<td><%=product.getPrice() %></td>
		<td><%=product.getEa() %></td>
		<td><%=total %></td>
		<td><a href="cart_delete.do?seq=<%=product.getSeq() %>">제거</a></td>
	</tr>
<%	
	}
}
%>

</table>
<a href="product_list.do">상품목록</a>
<tr>
	<td colspan="5" style="text-alige: right;">
	<p>총합 : <%=request.getAttribute("totalPrice") %></p>

	</td>
	</tr>
</body>
</html>