package user.repository;

import java.util.ArrayList;

import user.mvc.model.UserDAO;
import user.mvc.model.UserDTO;

public class UserRepository implements IRepository <UserDTO, String> {

	private UserDAO userDao = new UserDAO();

	@Override
	public void post(UserDTO dto) {
		userDao.insert(dto);
	}

	@Override
	public UserDTO findById(String id) {
		return userDao.findById(id);
	}

	@Override
	public ArrayList<UserDTO> findAll() {
		return null;
	}

	@Override
	public void update(String id, UserDTO dto) {
		//cartDao.update(id, dto);
		userDao.update(id, dto);
	}

	@Override
	public void delete(String id) {
		//cartDao.delete(id);
		userDao.delete(id);
	}

}
