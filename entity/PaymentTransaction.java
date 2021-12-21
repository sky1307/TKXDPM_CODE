package entity;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entity.db.EcoBikeDB;
import utils.Utils;
import entity.Home;
/**
 * 
 * @author sky
 *
 */
public class PaymentTransaction extends BaseEntity {
	public PaymentTransaction() throws SQLException {
		super();
	}
	
	public PaymentTransaction(String erroCode, String cardNumber, String id_transaction, String total, String createdAt, 
							int bike_id, String station_id, String holder_name, int downPayment, int refund, int paymentMethod) 
		throws SQLException {
		super();
		this.errorCode = erroCode;
		this.cardNumber = cardNumber;
		this.id_transaction = id_transaction;
		this.total = total;
		this.createdAt = createdAt;
		this.bike_id = bike_id;
		this.station_id = station_id;
		this.holder_name = holder_name;
		this.downPayment = downPayment;
		this.refund = refund;
		this.paymentMethod = paymentMethod;
	}
	
	
	private String errorCode;
	private String cardNumber ;
	private String id_transaction;
	private String total;
	private String createdAt;
	private int bike_id;
	private String station_id;
	private String holder_name;
	private int downPayment;
	private int refund;
	private int paymentMethod;
}
