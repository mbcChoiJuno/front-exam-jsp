package cart.mvc.controller;

import java.io.IOException;

import cart.service.CartService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cart/v1/*")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();

		var sp = (RequestURI.substring(contextPath.length())).split("/");

		if (sp.length > 4)
			return;

		String controller = sp[1];
		String version = sp[2];
		String command = "/" + sp[3];
		
		System.out.println("command:" + command);

		switch (command) {
		
			case "/dvdcart.do" -> { // 메뉴 -> 장바구니
				var cartService = CartService.getInstance();
				var cartList = cartService.getCartList();

				if (cartList.size() == 0) {
					RequestDispatcher rd = request.getRequestDispatcher("/cart/view/cartListNullPage.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/cart/view/cartList.jsp");
					rd.forward(request, response);
				}
			}
			
			case "/delete.do" -> { // 장바구니 -> 삭제하기
				var cartService = CartService.getInstance();
				cartService.removeAllProduct();
				
				RequestDispatcher rd = request.getRequestDispatcher("/cart/view/cartListNullPage.jsp");
				rd.forward(request, response);
			}
			
			case "/payment.do" -> { // 장바구니 -> 결제하기
//				RequestDispatcher rd = request.getRequestDispatcher("/cart/view/shippingInfo.jsp?amount=" + request.getParameter("amount"));
				RequestDispatcher rd = request.getRequestDispatcher("/payment/view/paymentNull.jsp");
				rd.forward(request, response);
			}
			
			case "/remove.do" -> { // 장바구니 -> 아이템 지우기
				String id = request.getParameter("id");
				System.out.println("remove.do in.  id:"+id);
				
				var cartService = CartService.getInstance();
				cartService.removeProduct(id);

				var cartList = cartService.getCartList();

				if (cartList.size() == 0) {
					RequestDispatcher rd = request.getRequestDispatcher("/cart/view/cartListNullPage.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/cart/view/cartList.jsp");
					rd.forward(request, response);
				}
			}
			
			case "/onAddProductEvent.do" -> { // DVD 상세정보 -> 장바구니 담기
				String id = request.getParameter("id");

				CartService cartService = CartService.getInstance();

				cartService.addProduct(id);

				RequestDispatcher rd = request.getRequestDispatcher("/cart/view/onAdd.jsp?id=" + id);
				rd.forward(request, response);
			}
		}
	}

}
