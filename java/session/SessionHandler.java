package session;
import user.mvc.model.UserDTO;

public class SessionHandler {
	private static SessionHandler instance = new SessionHandler();

	public static SessionHandler getInstance() {
		return instance;
	}
	// ----------------------------------

	private SessionHandler() {}

	private UserDTO currentUser;

	public UserDTO getCurrentUser() {
		return currentUser;
	}

	public void onLoginEvent(UserDTO logonUser) {
		currentUser = logonUser;
	}

	public void onLogoutEvent() {
		currentUser = null;
	}
}
