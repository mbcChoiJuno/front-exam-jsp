<%@ page contentType="text/html; charset=utf-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<%@page import="dto.Book"%>
<%@page import="java.util.ArrayList"%>

<div class="row align-items-md-stretch ">
			<div class="row">
				<table width="100%">
					<tr>
						<td align="left"><a
							href="./deleteCart.jsp?cartId=<%=cartId%>" class="btn btn-danger">삭제하기</a></td>
						<td align="right"><a
							href="./shippingInfo.jsp?cartId=<%=cartId%>"
							class="btn btn-success">주문하기</a></td>
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
					int sum = 0;
					
					for (int i = 0; i < cartList.size(); i++) { // 상품리스트 하나씩 출력하기
						Book book = cartList.get(i);
						int total = book.getUnitPrice() * book.getQuantity();
						sum = sum + total;
					%>
					<tr>
						<td><%=book.getBookId()%> - <%=book.getName()%></td>
						<td><%=book.getUnitPrice()%></td>
						<td><%=book.getQuantity()%></td>
						<td><%=total%></td>
						<td><a href="./removeCart.jsp?id=<%=book.getBookId()%>"
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
				<a href="./books.jsp" class="btn btn-secondary"> &laquo; 쇼핑 계속하기</a>
			</div>
		</div>
