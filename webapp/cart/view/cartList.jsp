<%@page import="dvd.mvc.model.DvdDTO"%>
<%@page import="dvd.service.DvdService"%>
<%@page import="cart.mvc.model.CartDTO"%>
<%@page import="cart.service.CartService"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.Book"%>
<%@ page import="dao.BookRepository"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />

<title>장바구니 화면</title>
</head>
<body>

	<div class="container py-4">
		<%@ include file="/menu.jsp"%>

		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">장바구니</h1>
				<p class="col-md-8 fs-4">Cart</p>
			</div>
		</div>

		<%
			int sum = 0;
		
			var cartList = CartService.getInstance().getCartList();
		
			if (cartList == null)
				cartList = new ArrayList<CartDTO>();
		%>
		
		<div class="row align-items-md-stretch ">
			<div class="row">
				<table width="100%">
					<tr>
					
						<td align="left"><a href="<c:url value="/cart/v1/delete.do"/>" 
							class="btn btn-danger">장바구니 비우기</a></td>
							
						<c:url var="paymentView" value="/cart/v1/payment.do">
							<c:param name="amount" value="${sum}" />
						</c:url>
						
						<td align="right"><a href="${paymentView}" 
							class="btn btn-danger">결제화면으로 이동</a></td>

					</tr>
				</table>
			</div>
			<div style="padding-top: 50px">
				<table class="table table-hover">
					<tr>
						<th>상품</th>
						<th>가격</th>
						<th>수량</th>
						<th>소계</th>
						<th>비고</th>
					</tr>
					<%
					
					for (var cart : cartList) {
						DvdDTO dvd = DvdService.getInstance().getDvdDetail(cart.getDvd_id());
						
						int total = dvd.getDvd_unitPrice() * cart.getDvd_count();
						sum = sum + total;
					%>
					<tr>
						<td><%=dvd.getDvd_id()%> - <%=dvd.getDvd_name()%></td>
						<td><%=dvd.getDvd_unitPrice()%></td>
						<td><%=cart.getDvd_count()%></td>
						<td><%=total%></td>
						
						<c:url var="removeUrl" value="/cart/v1/remove.do">
						  <c:param name="id" value="<%=dvd.getDvd_id()%>" />
						</c:url>
						
						<td><a href="${removeUrl}"
							class="badge text-bg-danger">삭제</a></td>
					</tr>
					<%
					}
					%>
					
					<tr>
						<th></th>
						<th></th>
						<th>총액</th>
						<th><%=sum%></th>
						<th></th>
					</tr>
				</table>
				<a href="${pageContext.request.contextPath}/books.jsp" class="btn btn-secondary"> &laquo; 쇼핑 계속하기</a>
			</div>
		</div>
		
		<jsp:include page="/footer.jsp" />
	</div>
</body>
</html>
