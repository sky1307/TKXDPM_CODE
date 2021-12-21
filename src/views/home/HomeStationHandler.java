package views.home;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import entity.Station;
import entity.Home;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import utils.Utils;
import views.base.FXMLScreenHandler;
import views.home.HomeScreenHandler;


class HomeStationHandler extends FXMLScreenHandler {
	private static Logger LOGGER = Utils.getLogger(HomeStationHandler.class.getName());
	
	@FXML
	private ImageView stationImage;
	
	@FXML
	private Label stationName;
	
	@FXML
	private Text location;
	
	@FXML 
	private Text availability;
	
	@FXML
	private Button viewButton;
	
	private Station station;
    private HomeScreenHandler home;
	
	public HomeStationHandler(String screenPath, Station station, HomeScreenHandler home) throws SQLException, IOException {
		super(screenPath);
		this.station = station;
		this.home = home;
		viewButton.setOnMouseClicked(event -> {
			
		});
	}
	
	public Station getStation() {
		return station;
	}
	
	private void setStationInfo() throws SQLException{
		File file = new File(station.getImageUrl());
		Image image = new Image(file.toURI().toString());
		stationImage.setFitHeight(212);
		stationImage.setFitWidth(322);
		stationImage.setImage(image);
		
		stationName.setText(station.getNameStation());
		location.setText(station.getAddress());
		availability.setText(String.valueOf(station.getAvailable()));
	}
}
