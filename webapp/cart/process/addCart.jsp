<%@page import="cart.service.CartService"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.Book"%>
<%@ page import="dao.BookRepository"%>
<%@ include file="/dbconn.jsp" %>
<%

/* book -> 상품추가 */
/* cart에 추가 부분 */

	String id = request.getParameter("id");

	if (id == null || id.trim().equals("")) {
		response.sendRedirect("books.jsp");
		return;
	}

	CartService cartService = CartService.getInstance();

	cartService.addProduct(id);

	/* response.sendRedirect(request.getContextPath() + "/book.jsp?id=" + id); */
	response.sendRedirect(request.getContextPath() + "/cart/v1/onAddProduct.do?id=" + id);

	
%>
	
	


/* 

	String id = request.getParameter("id");
	if (id == null || id.trim().equals("")) {
		response.sendRedirect("books.jsp");
		return;
	}

	BookRepository dao = BookRepository.getInstance(); 
	
	Book book= dao.getBookById(id); // 전달온 파라미터 값으로 객체를 찾아옴.
	
	if (book== null) {
		response.sendRedirect("exceptionNoBookId.jsp");
	}

	ArrayList<Book> goodsList = dao.getAllBooks();
	Book goods = new Book();
	for (int i = 0; i < goodsList.size(); i++) {
		goods = goodsList.get(i);
		if (goods.getBookId().equals(id)) { 			
			break;
		}
	}
	
	ArrayList<Book> list = (ArrayList<Book>) session.getAttribute("cartlist");
	if (list == null) { 
		list = new ArrayList<Book>();
		session.setAttribute("cartlist", list);
	}

	int cnt = 0;
	Book goodsQnt = new Book();
	for (int i = 0; i < list.size(); i++) {
		goodsQnt = list.get(i);
		if (goodsQnt.getBookId().equals(id)) {
			cnt++;
			int orderQuantity = goodsQnt.getQuantity() + 1;
			goodsQnt.setQuantity(orderQuantity);
		}
	}

	if (cnt == 0) { 
		goods.setQuantity(1);
		list.add(goods);
	}
	 
	response.sendRedirect(request.getContextPath() + "/book.jsp?id=" + id);
	 */