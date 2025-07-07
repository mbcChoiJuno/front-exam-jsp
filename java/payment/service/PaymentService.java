package payment.service;

import java.util.ArrayList;

import cart.mvc.model.CartDTO;
import cart.repository.CartRepository;
import dvd.mvc.model.DvdDTO;
import payment.mvc.model.PaymentDAO;
import payment.mvc.model.PaymentDTO;
import payment.repository.PaymentRepository;
import session.SessionHandler;

public class PaymentService {
	private static PaymentService instance = new PaymentService();

	public static PaymentService getInstance() {
		return instance;
	}

	//------------------------------------------

	private PaymentRepository paymentRepository = new PaymentRepository();

	/**
	 * 결제
	 * @param amount
	 */
	public void performPayment(int amount) {
		var currentUser = SessionHandler.getInstance().getCurrentUser();
		String userId = currentUser.getUser_id();
		
		var payment = new PaymentDTO();
		payment.setUser_id(userId);
		payment.setAmount(amount);
		
		paymentRepository.post(payment);
	}

}
