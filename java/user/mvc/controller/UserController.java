package user.mvc.controller;

import java.io.IOException;

import cart.service.CartService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.model.BoardDAO;
import mvc.model.BoardDTO;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/user/v1/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();

		var sp = (RequestURI.substring(contextPath.length())).split("/");

		System.out.println(sp.length);

		for (var s : sp) {
			System.out.println(s);
		}

		if (sp.length > 4) {
			return;
		}

		String controller = sp[1];
		String version = sp[2];
		String command = "/" + sp[3];

		System.out.println("command:" + command);

		switch (command) {
			case "/dvdcart.do" -> { // 메뉴 -> 장바구니

				var cartService = CartService.getInstance();
				var cartList = cartService.getCartList();

				var projectPath = contextPath.split(";")[0];

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
				
				RequestDispatcher rd = request.getRequestDispatcher("/cart/view/cart.jsp");
				rd.forward(request, response);
			}
			case "/payment.do" -> { // 장바구니 -> 결제하기
				RequestDispatcher rd = request.getRequestDispatcher("/cart/view/shippingInfo.jsp");
				rd.forward(request, response);
			}
			case "/remove.do" -> { // 장바구니 -> 아이템 지우기
				
			}
			
			case "asd" -> { // 장바구니 -> 추가

				BoardDAO dao = BoardDAO.getInstance();

				BoardDTO board = new BoardDTO();
				board.setId(request.getParameter("id"));
				board.setName(request.getParameter("name"));
				board.setSubject(request.getParameter("subject"));
				board.setContent(request.getParameter("content"));

				System.out.println(request.getParameter("name"));
				System.out.println(request.getParameter("subject"));
				System.out.println(request.getParameter("content"));
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy/MM/dd(HH:mm:ss)");
				String regist_day = formatter.format(new java.util.Date());

				board.setHit(0);
				board.setRegist_day(regist_day);
				board.setIp(request.getRemoteAddr());

				dao.insertBoard(board);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
