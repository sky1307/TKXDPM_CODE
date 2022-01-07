package sample;

import java.awt.Button;
import java.io.IOException;
import java.sql.SQLException;

import controller.ReturnBikeController;
import entity.Bike;
import entity.PaymentTransaction;
import entity.Station;
import entity.Transaction;
import entity.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class ReturnBikeScreenHandler {

	@FXML
	private TextArea paymentInfo;
	@FXML
	private TextArea returnBike;
	
	@FXML
	private Button returnButton;
	
	private Transaction transaction;

	private Station station;
	private ReturnBikeController returnBikeController;
	private User user;
	
	public ReturnBikeScreenHandler(ReturnBikeController returnBikeController,User user, Station station) throws SQLException {
		this.returnBikeController= returnBikeController;
		this.user = user;
		this.station = station;
		this.transaction = this.returnBikeController.getTransaction(this.user.getId());
		this.paymentInfo.setText(this.transaction.toString());
		this.returnBike.setText(this.transaction.getBike().toString());
	}
	
	@FXML
	void returnButtonHandler(MouseEvent event) throws IOException{
		PaymentTransaction paymentTransaction = this.returnBikeController.refund(this.transaction, this.station);
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Results");
		alert.setContentText("Return bike successfully!");
		alert.showAndWait();

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/HomeScreen.fxml"));
		HomeScreenHandler homeScreenHandler = new HomeScreenHandler(HomeController);
		fxmlLoader.setController(homeScreenHandler);
		Parent root = fxmlLoader.load();
		Scene homeScreen = new Scene(root);
		Stage newStage = new Stage();
		newStage.setScene(homeScreen);
		newStage.show();
	}
}
