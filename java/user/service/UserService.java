package user.service;

import java.util.ArrayList;

import cart.mvc.model.CartDTO;
import cart.repository.CartRepository;
import session.SessionHandler;
import user.mvc.model.UserDTO;
import user.repository.UserRepository;

public class UserService {
	private static UserService instance = new UserService();

	public static UserService getInstance() {
		return instance;
	}

	//------------------------------------------

	private UserRepository userRepository = new UserRepository();

	/**
	 * 유저 상세정보 조회
	 * @param userId
	 * @return
	 */
	public UserDTO getUserDetail(String userId) {
		var user = userRepository.findById(userId);
		return user;
	}


}
