<%@page import="user.service.UserService"%>
<%@page import="user.mvc.model.UserDTO"%>
<%@page import="session.SessionHandler"%>
<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<title>결제 화면</title>
</head>
<body>
<div class="container py-4">
   <%@ include file="/menu.jsp"%>	

   <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold">결제 정보 입력</h1>
        <p class="col-md-8 fs-4">Shipping Info</p>      
      </div>
    </div>
  	
	 <div class="row align-items-md-stretch ">	 	 

	<%
		String amount = request.getParameter("amount");
	
		String userId = SessionHandler.getInstance().getCurrentUser().getUser_id();
		
		UserDTO user = UserService.getInstance().getUserDetail(userId);
	%>
	
	<c:url var="performPayment" value="/payment/v1/decision.do?amount=${amount}" />
	
	<form action="performPayment" method="post" >
	<%-- <form action="${pageContext.request.contextPath}/cart/process/processShippingInfo.jsp" method="post" > --%>
		<input type="hidden" name="cartId" value="<%=userId%>">
			
			<div class="mb-3 row">
				<label class="col-sm-2">성명</label>
				<div class="col-sm-3">
					<input type="text" name="name" class="form-control"
					value='<%=user.getUser_name() %>' readonly>
				</div>
			</div>
			
			<div class="mb-3 row">
				<label class="col-sm-2">배송일 지정</label>
				<div class="col-sm-3">
					<input type="text" name="shippingDate" class="form-control" >(yyyy/mm/dd)
				</div>
			</div>		
			
				<div class="mb-3 row">
				<label class="col-sm-2">국가명</label>
				<div class="col-sm-3">
					<input type="text" name="country" class="form-control" value="대한민국" readonly>
				</div>
			</div>
				<div class="mb-3 row">
				<label class="col-sm-2">우편번호</label>
				<div class="col-sm-3">
					<input type="text" name="zipCode" class="form-control" >
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2">주소</label>
				<div class="col-sm-5">
					<input type="text" name="addressName" class="form-control" value='<%=user.getUser_address() %>' readonly>
				</div>
			</div>
			
			<div class="mb-3 row">
				<div class="col-sm-offset-2 col-sm-10 ">
				
					<a href="<c:url value="/cart/v1/dvdcart.do"/>" class="btn btn-secondary" 
					role="button"> 이전화면으로 </a> 
					
					<input type="submit" class="btn btn-primary" value="결제" /> 
					
					<%-- 
					<a href="${pageContext.request.contextPath}/cart/view/checkOutCancelled.jsp" class="btn btn-secondary" 
					role="button"> 취소 </a>
					 --%>
					<%-- 
				<!-- TODO: controller로 페이지 가리기 -->
					<a href="./cart.jsp?cartId=<%=request.getParameter("cartId")%>" class="btn btn-secondary" role="button"> 이전 </a> 
					<input type="submit" class="btn btn-primary" value="등록" /> 
				<!-- TODO: controller로 페이지 가리기 -->
					<a href="${pageContext.request.contextPath}/cart/view/checkOutCancelled.jsp" class="btn btn-secondary" role="button"> 취소 </a>
					 --%>
				</div>
			</div>

		</form>
	</div>
<jsp:include page="/footer.jsp" />
</div>	
</body>
</html>
