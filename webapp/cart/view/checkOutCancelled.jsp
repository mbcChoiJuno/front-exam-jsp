<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<title>주문 취소</title>
</head>
<body>
	
<div class="container py-4">
   <%@ include file="/menu.jsp"%>	

   <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
        <p class="col-md-8 fs-4">Order Cancellation</p>      
        <h1 class="display-5 fw-bold">주문 취소</h1>
      </div>
    </div>
  	
   <div class="row align-items-md-stretch ">
		<h2 class="alert alert-danger">주문이 취소되었습니다.</h2>
			</div>
		<div class="container">
		<p><a href="${pageContext.request.contextPath}/books.jsp" class="btn btn-secondary"> &laquo;도서 목록으로 이동</a>
		</div>
	
	<%@ include file="/footer.jsp"%>
  </div>
</body>
</html>
