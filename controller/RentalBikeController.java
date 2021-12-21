
package controller;

import java.sql.SQLException;

import controller.BaseController;
import entity.Bike;
import entity.Station;
import entity.Card;
import java.util.*;


/**
 * 
 * @author sky
 * 
 *
 */

public class RentalBikeController extends BaseController {
	private Card card;
	public RentalBikeController() {
		
	}
	/**
	 * Create Card
	 * @param cardNumber
	 * @param cardHoderName
	 * @param expirationDate
	 * @param securityCode
	 * @return one Card
	 * @throws SQLException
	 */
	public Card CreateCard(String cardNumber, String cardHoderName, String expirationDate, String securityCode) throws SQLException {
		this.card = new Card(cardNumber, cardHoderName, expirationDate, securityCode);
		return this.card;
	}
	
	/**
	 * Kiem tea bai xe con xe hay khong
	 * @param station_id
	 * @return boolean
	 */
	public boolean checkAviblityStation(String station_id) {

		return true;
	}
	
	/**
	 * Tra ve mot doi tuong bike tu barcode
	 * @param barcode
	 * @return
	 */
	public Bike checkBarCode(String barcode) {
		return new Bike(barcode);
	}
}