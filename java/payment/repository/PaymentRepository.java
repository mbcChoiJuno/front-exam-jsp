package payment.repository;

import java.util.ArrayList;

import cart.mvc.model.CartDAO;
import cart.mvc.model.CartDTO;
import payment.mvc.model.PaymentDAO;
import payment.mvc.model.PaymentDTO;
import session.SessionHandler;

public class PaymentRepository implements IRepository <PaymentDTO, String> {

	private PaymentDAO payDao = new PaymentDAO();

	@Override
	public void post(PaymentDTO payment) {
		payDao.insert(payment.getUser_id(), payment.getAmount());
	}

	@Override
	public PaymentDTO findById(String id) {
		var user = SessionHandler.getInstance().getCurrentUser();
		return payDao.findById(user.getUser_id(), id);
	}

	@Override
	public ArrayList<PaymentDTO> findAll() {
		return null;
	}
	public ArrayList<PaymentDTO> findAll(String userId) {
		return payDao.findAll(userId);
	}

	@Override
	public void update(String id, PaymentDTO payment) {
	}

	@Override
	public void delete(String dvdId) {
		payDao.delete(dvdId);
	}
}
