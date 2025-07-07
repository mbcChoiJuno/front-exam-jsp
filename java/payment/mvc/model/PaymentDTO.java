package payment.mvc.model;

public class PaymentDTO {

	private int payment_num;
	private String user_id;
	private int amount;

	public PaymentDTO() {}

	public PaymentDTO(int payment_num, String user_id, int amount) {
		super();
		this.payment_num = payment_num;
		this.user_id = user_id;
		this.amount = amount;
	}

	public int getPayment_num() {
		return payment_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setPayment_num(int payment_num) {
		this.payment_num = payment_num;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}