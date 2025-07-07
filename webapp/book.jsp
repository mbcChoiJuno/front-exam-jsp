<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="dto.Book"%>
<%@ page import="dao.BookRepository"%>
<%@ page errorPage="exceptionNoBookId.jsp"%>
<%@ page import="java.sql.*"%>

<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<title>도서 정보</title>
<script type="text/javascript">
	function addToCart() {
		if (confirm("상품을 장바구니에 추가하시겠습니까?")) {
			document.addForm.submit();
		} else {
			document.addForm.reset();
		}
	}
</script>

</head>
<body>
	<div class="container py-4">
		<%@ include file="menu.jsp"%>

		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">DVD 정보</h1>
				<p class="col-md-8 fs-4">DVD Info</p>
			</div>
		</div>
		<%@ include file="dbconn.jsp"%>
		<%
		String dvdId = request.getParameter("id");

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from dvd_tbl where dvd_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dvdId);
		rs = pstmt.executeQuery();
		if (rs.next()) {
		%>
		<div class="row align-items-md-stretch">
			<div class="col-md-5">
				<img src="./resources/images/<%=rs.getString("dvd_thumbnailUrl")%>"
					style="width: 70%">
			</div>
			<div class="col-md-6">
				<h3>
					<b><%=rs.getString("dvd_name")%></b>
				</h3>
				<p><%=rs.getString("dvd_description")%>%>
				<p>
					<b>DVD 코드 : </b><span class="badge text-bg-danger"> <%=rs.getString("dvd_id")%></span>
				<p>
					<b>감독</b> :
					<%=rs.getString("dvd_author")%>
				<p>
					<b>배급사</b> :
					<%=rs.getString("dvd_publisher")%>
				<p>
					<b>개봉일</b> :
					<%=rs.getString("dvd_releaseDate")%>
				<p>
					<b>장르</b> :
					<%=rs.getString("dvd_category")%>
				<p>
					<b>남은 DVD 수</b> :
					<%=rs.getString("dvd_unitsInStock")%>
					<h4><%=rs.getString("dvd_unitPrice")%>원
				</h4>
				<p>
				<!-- TODO: cart controller로 교체-->
				<c:url var="onAddProductEvent" value="/cart/v1/onAddProductEvent.do"/> <!-- 장바구니에 추가 -->
				<c:url var="dvdcart" value="/cart/v1/dvdcart.do"/> <!-- 장바구니로 이동 -->
				
				<form name="addForm" action="${onAddProductEvent}?id=<%=rs.getString("dvd_id")%>" method="post">
					<a href="#" class="btn btn-info" onclick="addToCart()"> 장바구니에 추가&raquo;</a>
					<a href="${dvdcart}" class="btn btn-warning"> 장바구니로 이동&raquo;</a>
					<a href="${pageContext.request.contextPath}/books.jsp" class="btn btn-secondary"> 돌아가기&raquo;</a>
				</form>
			</div>
		</div>
		<%
		} // IF문 종료
		%>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
