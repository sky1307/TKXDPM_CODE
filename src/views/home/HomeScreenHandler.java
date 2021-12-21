package views.home;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Logger;


import controller.BaseController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import utils.Configs;
import utils.Utils;
import views.base.BaseScreenHandler;
import controller.ShowInfoController;


public class HomeScreenHandler extends BaseScreenHandler implements Initializable{

    public static Logger LOGGER = Utils.getLogger(HomeScreenHandler.class.getName());
    
    @FXML
    private TextField searchArea;
    
    @FXML
    private ImageView EcoImage;
    
    @FXML
    private SplitMenuButton splitMenuBtnSearch;
    
    

    public HomeScreenHandler(Stage stage, String screenPath) throws IOException{
        super(stage, screenPath);
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    }
    
    public void setImage() {
    	
    }
}

