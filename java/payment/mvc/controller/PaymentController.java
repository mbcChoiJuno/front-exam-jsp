package payment.mvc.controller;

import java.io.IOException;

import cart.service.CartService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import payment.service.PaymentService;

@WebServlet("/payment/v1/*")
public class PaymentController extends HttpServlet {
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
			case "/decision.do" -> { // 결제화면 -> 결제
				int amount = Integer.parseInt(request.getParameter("amount"));
				var paymentService = PaymentService.getInstance();
				paymentService.performPayment(amount);
				
				// 장바구니 지우기
				var cartService = CartService.getInstance();
				cartService.removeAllProduct();

				RequestDispatcher rd = request.getRequestDispatcher("/thankCustomer.jsp");
				rd.forward(request, response);
			}
		}
	}

}
