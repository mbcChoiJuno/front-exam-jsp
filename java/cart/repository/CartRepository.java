package cart.repository;

import java.util.ArrayList;

import cart.mvc.model.CartDAO;
import cart.mvc.model.CartDTO;
import session.SessionHandler;

public class CartRepository implements IRepository <CartDTO, String> {

	private CartDAO cartDao = new CartDAO();

	@Override
	public void post(CartDTO cart) {
		var user = SessionHandler.getInstance().getCurrentUser();
		cartDao.insert(cart.getUser_id(), cart.getDvd_id());
	}

	@Override
	public CartDTO findById(String id) {
		var user = SessionHandler.getInstance().getCurrentUser();
		return cartDao.findById(user.getUser_id(), id);
	}

	@Override
	public ArrayList<CartDTO> findAll() {
		return null;
	}
	public ArrayList<CartDTO> findAll(String userId) {
		return cartDao.findAll(userId);
	}

	@Override
	public void update(String id, CartDTO dto) {
	}
	
	public void updateAddCount(String userId, String dvdId) {
		cartDao.update(userId, dvdId, 1);
	}
	
	public void updateSubCount(String userId, String dvdId) {
		cartDao.update(userId, dvdId, -1);
	}

	@Override
	public void delete(String dvdId) {
		var user = SessionHandler.getInstance().getCurrentUser();
		cartDao.delete(user.getUser_id(), dvdId);
	}

	public void deleteAll() {
		var user = SessionHandler.getInstance().getCurrentUser();
		cartDao.deleteAll(user.getUser_id());
	}
}
