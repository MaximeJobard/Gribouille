package iut.gon.gribouille_tp1.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import iut.gon.gribouille_tp1.Dialogue;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class MenusController implements Initializable{
	
	@FXML
	public ToggleGroup outils;
	
	@FXML
	public RadioMenuItem crayon;
	
	@FXML
	public RadioMenuItem etoile;
	
	@FXML
	public RadioMenuItem gomme;
	
	public Controller controller;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ChangeListener mode = new ChangeListener() {

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				if(newValue == crayon) {
					controller.onCrayon();
					controller.statusController.typeOutil.setText("Crayon");
				}
				
				if(newValue == etoile) {
					controller.onEtoile();
					controller.statusController.typeOutil.setText("Etoile");
				}
				
				if(newValue == gomme) {
					controller.onGomme();
					controller.statusController.typeOutil.setText("Gomme");
				}
			}
		};
		
		outils.selectedToggleProperty().addListener(mode);
	}
	
	public void setController(Controller c) {
		controller = c;
		
	}
	
	public void onQuitte() {
		if(controller.OnQuitter()) {
    		Platform.exit();
    	}
	}
}
