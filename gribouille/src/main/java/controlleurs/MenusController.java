package controlleurs;

import java.net.URL;
import java.util.ResourceBundle;

import iut.gon.gribouille_tp1.Dialogue;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class MenusController implements Initializable{
	
	@FXML
	public ToggleGroup outils;
	
	public Stage stage;
	public Controller controller = new Controller();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void setStage(Stage s) {
		stage = s;
	}
	
	public void onQuitte() {
		if(controller.OnQuitter()) {
    		Platform.exit();
    	}
	}
}
