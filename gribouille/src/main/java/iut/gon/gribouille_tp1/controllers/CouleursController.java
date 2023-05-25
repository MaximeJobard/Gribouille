package iut.gon.gribouille_tp1.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.shape.Rectangle;

public class CouleursController implements Initializable {

	@FXML
	public ColorPicker ColorPicker;

	@FXML
	public Rectangle rouge;

	@FXML
	public Rectangle vert;

	@FXML
	public Rectangle bleu;

	@FXML
	public Rectangle cyan;

	@FXML
	public Rectangle rose;

	@FXML
	public Rectangle jaune;

	@FXML
	public Rectangle noir;

	@FXML
	public Rectangle blanc;

	public Controller controller;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public void setController(Controller controller2) {
		controller = controller2;
	}
	
}
