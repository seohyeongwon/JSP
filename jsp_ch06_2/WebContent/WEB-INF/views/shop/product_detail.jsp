<%@page import="org.comstudy.myweb.shop.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Product product = (Product)request.getAttribute("product");
%>

<h1>제품 상세 보기</h1>
<%=product %>
<p>수량 : <input id="ea" type="number" name="ea" value="1"></p>
<hr/>
<script>
function addCart() {
	var inputEa = document.getElementById("ea");
	var sendUrl = 'cart_list.do?seq=<%=product.getSeq()%>&ea='+inputEa.value;
	console.log(sendUrl);
	location.href = sendUrl;
}
</script>

<a href="javascript:addCart()">장바구니 추가</a>
<a href="shop/cart_list.do">장바구니목록</a>
<a href="product_list.do">상품목록</a>

</body>
</html>