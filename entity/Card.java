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



public class Card extends BaseEntity{
	public Card() throws SQLException {
		super();
	}
	
	/**
	 * Create Card
	 * @param card_number
	 * @param holderName
	 * @param secretCode
	 * @param expireDate
	 * @throws SQLException
	 */
	public Card(String card_number, String holderName, String secretCode, String expireDate) throws SQLException {
		super();
		this.card_number = card_number;
		this.holderName = holderName;
		this.secretCode = secretCode;
		this.expireDate = expireDate;
		this.balance = 0;
	}
	
	public Card(String card_number, String holderName, String secretCode, String expireDate, int balance) throws SQLException {
		super();
		this.card_number = card_number;
		this.holderName = holderName;
		this.secretCode = secretCode;
		this.expireDate = expireDate;
		this.balance = balance;
	}
	
	
	private String card_number;
	private String holderName;
	private String secretCode;
	private String expireDate;
	private int balance;
	
	
	
}
