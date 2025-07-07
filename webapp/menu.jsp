<%@page import="session.SessionHandler"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header class="pb-3 mb-4 border-bottom">
	<div class="container ">
		<div
			class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
			<a href="${pageContext.request.contextPath}/welcome.jsp"	class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
				<svg width="32" height="32" fill="currentColor"	class="bi bi-house-fill" viewBox="0 0 16 16">
		  			<path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z" />
  					<path d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z" />
				</svg>
				<span class="fs-4">Home</span>
			</a>


			<%
			boolean isAdmin = false;
			String sessionId = (String) session.getAttribute("sessionId");

			var currentUser = SessionHandler.getInstance().getCurrentUser();

			if (currentUser != null) {
				isAdmin = (currentUser.isAdmin() == 1);
			}

			request.setAttribute("isAdmin", isAdmin);
			%>

			<ul class="nav nav-pills">
			
				<c:choose>
					<c:when test="${empty sessionId}"> <!-- 로그아웃 상태 -->
						<li class="nav-item"><a class="nav-link"
							href="<c:url value="/member/loginMember.jsp"/>">로그인 </a></li>
						<li class="nav-item"><a class="nav-link"
							href='<c:url value="/member/addMember.jsp"/>'>회원 가입</a></li>
					</c:when>
											
					<c:otherwise> <!-- 로그인 상태 -->
						
						<c:if test="${isAdmin}"> <!-- 관리자 계정 -->

							<li style="padding-top: 7px"> [관리자모드 진입] </li>
							
							<li class="nav-item"><a
								href="<c:url value="/member/logoutMember.jsp"/>"
								class="nav-link">로그아웃 </a></li>

							<li class="nav-item"><a href="<c:url value="/addBook.jsp"/>"
								class="nav-link">DVD 등록</a></li>

							<li class="nav-item"><a
								href="<c:url value="/editBook.jsp?edit=update"/>"
								class="nav-link">DVD 수정</a></li>
								
							<li class="nav-item"><a
								href="<c:url value="/editBook.jsp?edit=delete"/>"
								class="nav-link">DVD 삭제</a></li>

						</c:if> 
						
						<c:if test="${!isAdmin}"> <!-- 일반 계정 -->

							<li style="padding-top: 7px"> [ <%=sessionId%>님 ] </li>

							<li class="nav-item"><a
								href="<c:url value="/member/logoutMember.jsp"/>"
								class="nav-link">로그아웃 </a></li>

							<li class="nav-item"><a
								href="<c:url value="/member/updateMember.jsp"/>"
								class="nav-link">회원 수정</a></li>

							<li class="nav-item"><a 
								href="<c:url value="/books.jsp"/>"
								class="nav-link">DVD 목록</a></li>

							<li class="nav-item"><a
								href="<c:url value="/cart/v1/dvdcart.do"/>" 
								class="nav-link">장바구니</a></li>

							<li class="nav-item"><a
								href="<c:url value="/payment/v1/history.do"/>" 
								class="nav-link">결제이력</a></li>

							<li class="nav-item"><a
								href="<c:url value="/BoardListAction.do?pageNum=1"/>"
								class="nav-link">게시판</a></li>
						</c:if>

					</c:otherwise>
				</c:choose>
			
			</ul>
		</div>
	</div>
</header>
