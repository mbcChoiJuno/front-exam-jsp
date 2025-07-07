package user.mvc.model;

import java.sql.Date;

public class UserDTO {
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_gender;
	private Date user_birth;
	private String user_email;
	private String user_phone;
	private String user_address;
	private Date user_registdate;
	private int is_admin; // 0: 일반 1: 관리자
	private String auth_token;

	public UserDTO() {}

	public UserDTO(String user_id, String user_pw, String user_name, String user_gender, Date user_birth,
			String user_email, String user_phone, String user_address, Date user_registdate) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_gender = user_gender;
		this.user_birth = user_birth;
		this.user_email = user_email;
		this.user_phone = user_phone;
		this.user_address = user_address;
		this.user_registdate = user_registdate;
	}

	public String getUser_id() {
		return user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public Date getUser_birth() {
		return user_birth;
	}
	public String getUser_email() {
		return user_email;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public String getUser_address() {
		return user_address;
	}
	public Date getUser_registdate() {
		return user_registdate;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public void setUser_birth(Date user_birth) {
		this.user_birth = user_birth;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public void setUser_registdate(Date user_registdate) {
		this.user_registdate = user_registdate;
	}

	public int isAdmin() {
		return is_admin;
	}

	public String getAuth_token() {
		return auth_token;
	}

	public void setIs_admin(int is_admin) {
		this.is_admin = is_admin;
	}

	public void setAuth_token(String auth_token) {
		this.auth_token = auth_token;
	}
	
}