package iut.gon.gribouille_tp1.controllers;

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
	
	public Controller controller;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
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
