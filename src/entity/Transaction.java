package entity;

public class Transaction {
	private String errorCode;
	private String cardNumber;
	private int transaction_id;
	private int total;
	private String createdAt;
	private int bike_id;
	private String holder_name;
	private int downPayment;
	private int refund;
	private int paymentMethod;
	
	public Transaction(String errorCode,String cardNumber,int transaction_id,int total,String createdAt,int bike_id, int refund, int downPayment, String holder_name, int paymentMethod) {
		super();
		this.errorCode = errorCode;
		this.cardNumber = cardNumber;
		this.transaction_id = transaction_id;
		this.total = total;
		this.createdAt = createdAt;
		this.bike_id=bike_id;
		this.holder_name = holder_name;
		this.downPayment = downPayment;
		this.refund = refund;
		this.paymentMethod = paymentMethod;
	}
	
	public String getTransaction() {
		
		return errorCode;
	}

	public int getPaymentMethod() {
		return paymentMethod;
	}

	public int getRefund() {
		return refund;
	}

	public int getDownPayment() {
		return downPayment;
	}

	public int getBike_id() {
		return bike_id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public int getTotal() {
		return total;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public String getHolder_name() {
		return holder_name;
	}

	public String getCardNumber() {
		return cardNumber;
	}	
}
