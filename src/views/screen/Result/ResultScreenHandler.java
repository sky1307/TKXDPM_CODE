package views.screen.Result;

import java.io.IOException;
import java.util.logging.Logger;

import entity.Bike;
import entity.Transaction;
import utils.Utils;
import views.screen.ReturnBike.FXML;
import views.screen.ReturnBike.ReturnBikeScreenHandler;

public class ResultScreenHandler {
	
	@FXML
	private Bike bike;
	@FXML
	private Transaction PaymentTransaction;
	
	private static Logger LOGGER = Utils.getLogger(ResultScreenHandler.class.getName());
	
	public ResultScreenHandler(String screenPath,Bike bike,Transaction paymentTransaction) throws IOException{
		super(screenPath);
		this.bike = bike;
		this.PaymentTransaction = paymentTransaction;
	}
	
}