package iut.gon.gribouille_tp1.controllers;

import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
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
	
	@FXML
	public VBox vBox;

	public Controller controller;
	
	public Rectangle rec;
	
	public ArrayList<Rectangle> recTab = new ArrayList<Rectangle>();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		recTab.add(bleu);
		recTab.add(jaune);
		recTab.add(rose);
		recTab.add(rouge);
		recTab.add(vert);
		recTab.add(blanc);
		recTab.add(cyan);
		recTab.add(noir);
		
		rec = noir;
		
		vBox.addEventHandler(MouseEvent.MOUSE_CLICKED, (evt) -> {
			
			if(evt.getTarget().getClass() == blanc.getClass()) {
				for(Rectangle r : recTab) {
					r.setArcWidth(5);
					r.setArcHeight(5);
					r.setStrokeWidth(1);
				}
				for(Rectangle r : recTab) {
					if(evt.getTarget().equals(r)) {
						r.setArcWidth(10);
						r.setArcHeight(10);
						r.setStrokeWidth(5);
					}
				}
				
				rec = (Rectangle) evt.getTarget();
				controller.dessinController.setCouleur(rec.getId());
			}
		});	
	}

	public void setController(Controller controller2) {
		controller = controller2;
	}
	
}
