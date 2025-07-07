<%@page import="dvd.service.DvdService"%>
<%@page import="dvd.mvc.model.DvdDTO"%>
<%@ page contentType="text/html; charset=utf-8"%>

<%
	var id = request.getParameter("id");
	DvdDTO dvd = DvdService.getInstance().getDvdDetail(id);
%>

<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<title>장바구니에 추가</title>
</head>
<body>
	
<div class="container py-4">
   <%@ include file="/menu.jsp"%>	

   <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold">DVD 정보</h1>
        <p class="col-md-8 fs-4">DVD Info</p>      
      </div>
    </div>
  	
   <div class="row align-items-md-stretch ">
		<h2 class="alert alert-danger"><%=dvd.getDvd_name() %>(이)가 장바구니에 추가되었습니다.</h2>
			</div>
		<div class="container">

			<c:url var="dvdListView" value="/books.jsp" />
			<c:url var="cartListView" value="/cart/v1/dvdcart.do" />

			<p>
				<a href="${dvdListView}" class="btn btn-secondary"> &laquo;DVD 목록</a>
			
			<p>
				<a href="${cartListView}" class="btn btn-secondary"> &laquo;장바구니로 이동</a>
		</div>
	
	<%@ include file="/footer.jsp"%>
  </div>
</body>
</html>
