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
		
		vBox.addEventHandler(MouseEvent.MOUSE_CLICKED, (evt) -> {
			for(Rectangle r : recTab) {
				r.setArcWidth(5);
				r.setArcHeight(5);
				r.setStrokeWidth(1);
			}
			
			if(evt.getTarget().getClass() == blanc.getClass()) {
				
				for(Rectangle r : recTab) {
					if(evt.getTarget().equals(r)) {
						r.setArcWidth(10);
						r.setArcHeight(10);
						r.setStrokeWidth(5);
					}
				}
				
				Rectangle rec = (Rectangle) evt.getTarget();
				
				switch(rec.getId()) {
				case "blanc":
					controller.setCouleur(Color.WHITE);
					break;
				case "bleu":
					controller.setCouleur(Color.BLUE);
					break;
				case "cyan":
					controller.setCouleur(Color.CYAN);
					break;
				case "rouge":
					controller.setCouleur(Color.RED);
					break;
				case "noir":
					controller.setCouleur(Color.BLACK);
					break;
				case "rose":
					controller.setCouleur(Color.PINK);
					break;
				case "jaune":
					controller.setCouleur(Color.YELLOW);
					break;
				case "vert":
					controller.setCouleur(Color.GREEN);
					break;
				}
			}
		});	
	}

	public void setController(Controller controller2) {
		controller = controller2;
	}
	
}
