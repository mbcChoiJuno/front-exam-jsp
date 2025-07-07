package cart.mvc.model;

public class CartDTO {

	private String user_id;
	private String dvd_id;
	private int dvd_count;

	public CartDTO() {}

	public CartDTO(String user_id, String dvd_id, int dvd_count) {
		this.user_id = user_id;
		this.dvd_id = dvd_id;
		this.dvd_count = dvd_count;
	}

	public String getUser_id() {
		return user_id;
	}
	public String getDvd_id() {
		return dvd_id;
	}
	public int getDvd_count() {
		return dvd_count;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setDvd_id(String dvd_id) {
		this.dvd_id = dvd_id;
	}
	public void setDvd_count(int dvd_count) {
		this.dvd_count = dvd_count;
	}

}