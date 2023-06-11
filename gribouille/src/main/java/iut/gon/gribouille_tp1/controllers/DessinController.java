package iut.gon.gribouille_tp1.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import iut.gon.gribouille_tp1.modele.Dessin;
import iut.gon.gribouille_tp1.modele.Figure;
import iut.gon.gribouille_tp1.modele.Trace;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class DessinController implements Initializable{
	
	@FXML
	public Pane pane;

	@FXML
	public Canvas canvas;

	@FXML
	public Label coX;

	@FXML
	public Label coY;
	
	@FXML
	public Label epaisseur;
	
	private Dessin dessin;
	private Trace trace;
	private SimpleDoubleProperty prevX = new SimpleDoubleProperty();
	private SimpleDoubleProperty prevY = new SimpleDoubleProperty();
	public Controller controller;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		canvas.widthProperty().bind(pane.widthProperty());
		canvas.heightProperty().bind(pane.heightProperty());
		
		canvas.addEventHandler(MouseEvent.MOUSE_MOVED, (evt)->{
			controller.onMouseMove(evt);
		});
	}
	
	public void setController(Controller c) {
		this.controller = c;
	}
	
	public void efface() {
		canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	
	public void gomme(MouseEvent e) {
		canvas.getGraphicsContext2D().clearRect((e.getX()-5), (e.getY()-5), 10, 10);
	}
	
	public void trace (double x1, double x2, double y1, double y2) {
		canvas.getGraphicsContext2D().strokeLine(x1, y1, x2, y2);
	}
	
	
	public void setDessin(Dessin d) {
		dessin = d;
	}
	
	public void onMousePressed(MouseEvent evt) {
		controller.onMousePressed(evt);
	}
	
	public void onMouseMove(MouseEvent evt) {
		controller.onMouseMove(evt);
	}
	
	public void onMouseDragged(MouseEvent evt) {
		controller.onMouseDragged(evt);
	}
	
	public void setEpaisseur(int epaisseur) {
		this.canvas.getGraphicsContext2D().setLineWidth(epaisseur);
	}
	
	public void setCouleur(String c) {
		switch(c) {
		case "blanc":
			canvas.getGraphicsContext2D().setStroke(Color.WHITE);
			controller.statusController.couleur.setText("Blanc");
			break;
		case "bleu":
			canvas.getGraphicsContext2D().setStroke(Color.BLUE);
			controller.statusController.couleur.setText("Bleu");
			break;
		case "cyan":
			canvas.getGraphicsContext2D().setStroke(Color.CYAN);
			controller.statusController.couleur.setText("Cyan");
			break;
		case "rouge":
			canvas.getGraphicsContext2D().setStroke(Color.RED);
			controller.statusController.couleur.setText("Rouge");
			break;
		case "noir":
			canvas.getGraphicsContext2D().setStroke(Color.BLACK);
			controller.statusController.couleur.setText("Noir");
			break;
		case "rose":
			canvas.getGraphicsContext2D().setStroke(Color.PINK);
			controller.statusController.couleur.setText("Rose");
			break;
		case "jaune":
			canvas.getGraphicsContext2D().setStroke(Color.YELLOW);
			controller.statusController.couleur.setText("Jaune");
			break;
		case "vert":
			canvas.getGraphicsContext2D().setStroke(Color.GREEN);
			controller.statusController.couleur.setText("Vert");
			break;
	}
	}
}
