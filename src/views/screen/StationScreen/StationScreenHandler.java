package views.screen.StationScreen;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import controller.ReturnBikeController;
import controller.ShowInfoController;
import entity.Bike;
import entity.Station;
import javafx.scene.input.MouseEvent;
import utils.Configs;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.Result.FXML;
import views.screen.ReturnBike.ReturnBikeScreenHandler;

public class StationScreenHandler extends BaseScreenHandler{
	private static Logger LOGGER = Utils.getLogger(StationScreenHandler.class.getName());
	@FXML	
	private ArrayList<Bike> bikeList;
	@FXML	
	private Station stationInfo;
	
	private static ShowInfoController showinfoController;
	
	/**
	 * Khời tạo các thành phân của screen
	 * @param screenPath
	 * @param stationInfo
	 * @throws IOException
	 * @throws SQLException
	 */
	public void SationScreenHandler(String screenPath,Station stationInfo) throws IOException, SQLException{
	
		this.stationInfo = stationInfo;
		bikeList = showinfoController.getBikeInStation(stationInfo.getId_station());
	}
	
	/**
	 * Chuyển sang màn hình return bike khi người dùng click vào nút trả xe
	 * @param event
	 * @throws IOException
	 */
	public void confirmInvoice(MouseEvent event) throws IOException{
		BaseScreenHandler ReturnScreenHandler = new ReturnBikeScreenHandler(this.stage, Configs.PAYMENT_SCREEN_PATH);
		ReturnScreenHandler.setBController(new ReturnBikeController());
		ReturnScreenHandler.setPreviousScreen(this);
		ReturnScreenHandler.setScreenTitle("Return Bike Screen");
		ReturnScreenHandler.show();
	}
}
