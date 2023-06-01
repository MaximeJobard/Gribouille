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
		ChangeListener gestionnaire = new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (trace != null) {
					dessin.addFigure(trace);
					for (Figure f : dessin.getFigures()) {
						for (int i = 1; i < f.getPoints().size() - 1; i++) {
							canvas.getGraphicsContext2D().strokeLine(f.getPoints().get(i - 1).getX(),
									f.getPoints().get(i - 1).getY(), 
									f.getPoints().get(i).getX(),
									f.getPoints().get(i).getY());
						}
					}
				}
			}
		};
		canvas.widthProperty().bind(pane.widthProperty());
		canvas.heightProperty().bind(pane.heightProperty());
		canvas.widthProperty().addListener(gestionnaire);
		canvas.heightProperty().addListener(gestionnaire);
		
	}
	
	public void setController(Controller c) {
		this.controller = c;
	}
	
	public void efface() {
		canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
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
	
}
