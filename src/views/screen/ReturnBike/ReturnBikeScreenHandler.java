package views.screen.ReturnBike;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import controller.ReturnBikeController;
import entity.Bike;
import entity.Transaction;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import utils.Configs;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.payment.PaymentScreenHandler;

/**
 * 
 * @author Dan
 *
 */
public class ReturnBikeScreenHandler extends BaseScreenHandler{
	private static Logger LOGGER = Utils.getLogger(ReturnBikeScreenHandler.class.getName());
	@FXML
	private Bike[] bikeList;
	
	@FXML
	private Bike selectedBike;
	
	@FXML
	private Transaction PaymentTransaction;
	
	private static ReturnBikeController returnbikeController;
	
	/**
	 * add screen to screen path and show all renteled bike 
	 * @param screenPath
	 * @throws IOException
	 * @throws SQLException
	 */
	public ReturnBikeScreenHandler(String screenPath) throws IOException, SQLException{
		super(screenPath);
		bikeList = returnbikeController.getRentalBike();
	}
	/**
	 * Customer click to ConfirmReturnBike
	 * @param event
	 * @throws IOException
	 */
	public void ConfirmReturnBike(MouseEvent event) throws IOException{
		LOGGER.info("Confirmed Return bike");
		BaseScreenHandler resultScreen = new ResultScreenHandler(this.stage, Configs.PAYMENT_SCREEN_PATH, this.selectedBike,this.PaymentTransaction);
		resultScreen.setPreviousScreen(this);
//		resultScreen.setHomeScreenHandler(homeScreenHandler);
//		resultScreen.setScreenTitle("Payment Screen");
		resultScreen.show();
	}
	
	/**
	 * Update new payment info
	 * @throws IOException
	 */
	public void setPaymentInfo() throws IOException{
		
	}
	
	/**
	 * Customer selected bike to return and system change payment info 
	 * @param event
	 * @param bike
	 * @throws IOException
	 */
	public void SelectBike(MouseEvent event,Bike bike) throws IOException{
		if (this.selectedBike == bike){
			this.selectedBike = new Bike();
		}
		else {
			this.selectedBike = bike;
			this.setPaymentInfo();
		}
	}
}
