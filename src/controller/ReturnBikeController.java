package controller;

import java.sql.SQLException;

import entity.Bike;
import entity.Transaction;
import subsystem.InterbankInterface;
/**
 * This class control the flow of the return bike process in our AIMS Software.  
 * @author Dan
 *
 */
public class ReturnBikeController extends BaseController{
	/**
	 * Represent the Interbank subsystem
	 */
	private static InterbankInterface Interbank;
	
	/**
	 * Connect to interbank and reduct money to customer
	 * @param amount 		- amount to pay
	 * @return transaction	- 
	 * @throws NotEnoughtBalanceException - balance in interbank is not enough to payment 
	 */
	public Transaction reductMoney(int amount) {
		Transaction result = new Transaction(null, null, amount, amount, null, amount, amount, amount, null, amount);
		return result;
	}
	/**
	 * Customer return bike to system
	 * @param bikeId
	 * @return transaction
	 */
	public Transaction ReturnBike(int bikeId) {
		Transaction result = new Transaction(null, null, bikeId, bikeId, null, bikeId, bikeId, bikeId, null, bikeId);
		return result;
	}
	/**
	 * Get all bike that is rentaled by customer 
	 * @return bike[]
	 * @throws SQLException
	 */
	public Bike[] getRentalBike() throws SQLException{
		Bike[] bikeList = null;
		return bikeList;
	}
}
