package cart.service;

import java.util.ArrayList;

import cart.mvc.model.CartDTO;
import cart.repository.CartRepository;
import dvd.mvc.model.DvdDTO;
import session.SessionHandler;

public class CartService {
	private static CartService instance = new CartService();

	public static CartService getInstance() {
		return instance;
	}

	//------------------------------------------

	private CartRepository cartRepository = new CartRepository();

	/**
	 * 장바구니 목록 조회하기
	 * @return
	 */
	public ArrayList<CartDTO> getCartList() {
		var currentUser = SessionHandler.getInstance().getCurrentUser();

		if (currentUser == null)
			return new ArrayList<>();

		return cartRepository.findAll(currentUser.getUser_id());
	}

	/**
	 * 장바구니 비우기
	 */
	public void removeAllProduct() {
		cartRepository.deleteAll();
	}
	
	/**
	 * 장바구니 상품 삭제
	 * @param dvdId
	 */
	public void removeProduct(String dvdId) {
		cartRepository.delete(dvdId);
	}
	
	/**
	 * 상품 더하기
	 * @param dvdDTO
	 */
	public void addProduct(String dvdId) {
		var currentUser = SessionHandler.getInstance().getCurrentUser();
		
		String userId = currentUser.getUser_id();
		
		var cart = cartRepository.findById(dvdId);
		
		if (cart == null) { 
			// 장바구니에 상품 없는경우 POST
			System.out.println("cart == null");
			
			cart = new CartDTO();
			cart.setUser_id(userId);
			cart.setDvd_id(dvdId);
			cartRepository.post(cart);
			
		} else { 
			// 장바구니에 상품 있는경우 카운트 update
			System.out.println("cart != null");
			
			cartRepository.updateAddCount(userId, dvdId);
		}
	}

}
