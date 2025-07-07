<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="dto.Book"%>
<%@ page import="dao.BookRepository"%>
<%
/* 카트에서 삭제 부분 */

	String id = request.getParameter("cartId");
	if (id == null || id.trim().equals("")) {
		response.sendRedirect("cart.jsp");
		return;
	}

	session.invalidate();
	response.sendRedirect("cart.jsp");
%>
