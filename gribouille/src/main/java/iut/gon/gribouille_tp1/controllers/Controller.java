package iut.gon.gribouille_tp1.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import iut.gon.gribouille_tp1.Dialogue;
import iut.gon.gribouille_tp1.modele.Dessin;
import iut.gon.gribouille_tp1.modele.Trace;
import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller implements Initializable {
	public final SimpleObjectProperty<Color> couleur = new SimpleObjectProperty<Color>(Color.BLACK);
	public final SimpleIntegerProperty epaisseurs = new SimpleIntegerProperty(1);
	
	@FXML
	public DessinController dessinController;
	
	@FXML
	public CouleursController couleursController;

	@FXML
	public MenusController menusController;
	
	@FXML
	public StatusController statusController;
	

	
	@FXML
	public ToggleGroup ep;
	
	private Dessin dessin;
	private Trace trace;
	public SimpleDoubleProperty prevX = new SimpleDoubleProperty();
	public SimpleDoubleProperty prevY = new SimpleDoubleProperty();
	
	public Controller(Dessin d) {
		dessin = d;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		/*ep.selectedToggleProperty().addListener((obs, old, neww) -> {
			System.out.println(neww);
		});*/
		
		
		this.dessinController.setController(this);
		this.couleursController.setController(this);
		this.menusController.setController(this);
		this.statusController.setController(this);
		
		statusController.coX.textProperty().bind(prevX.asString());
		statusController.coY.textProperty().bind(prevY.asString());
		statusController.epaisseur.textProperty().bind(epaisseurs.asString());
		
	}


	public void onMousePressed(MouseEvent evt) {
		prevX.set(evt.getX());
		prevY.set(evt.getY());
		if (trace != null) {
			if(trace.getPoints().size()>1) {
				dessin.addFigure(trace);
			}
		}
		trace = new Trace(10, "noir", prevX.getValue(), prevY.getValue());
	}

	public void onMouseDragged(MouseEvent evt) {
		dessinController.canvas.getGraphicsContext2D().strokeLine(prevX.getValue(), prevY.getValue(), evt.getX(), evt.getY());
		trace.addPoint(prevX.getValue(), prevY.getValue());
		this.prevX.set(evt.getX());
		this.prevY.set(evt.getY());
	}
	
	public void onMouseMove(MouseEvent evt) {
		
	}
	
	public boolean OnQuitter() {
		return Dialogue.confirmation(); 
	}
	
}
