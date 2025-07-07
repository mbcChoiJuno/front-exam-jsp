<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.Book"%>
<%@ page import="dao.BookRepository"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />

<%
	String cartId = session.getId();
%>

<title>장바구니</title>
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

		<div class="row align-items-md-stretch   text-center">
			<div class="col-md-12">
				<div class="h-100 p-5">
					<h3>장바구니가 비었습니다.</h3>
				</div>
			</div>
		</div>

		<jsp:include page="/footer.jsp" />
	</div>
</body>
</html>
