package iut.gon.gribouille_tp1.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class StatusController implements Initializable{
	
	@FXML
	public Label coX;

	@FXML
	public Label coY;
	
	@FXML
	public Label epaisseur;

	public Controller controller;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public void setController(Controller controller2) {
		controller = controller2;
		
	}
}
