package iut.gon.gribouille_tp1.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import iut.gon.gribouille_tp1.Dialogue;
import iut.gon.gribouille_tp1.Outils;
import iut.gon.gribouille_tp1.OutilsCrayon;
import iut.gon.gribouille_tp1.OutilsEtoile;
import iut.gon.gribouille_tp1.OutilsGomme;
import iut.gon.gribouille_tp1.modele.Dessin;
import iut.gon.gribouille_tp1.modele.Figure;
import iut.gon.gribouille_tp1.modele.Trace;
import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller implements Initializable {
	public final SimpleObjectProperty<Color> couleur = new SimpleObjectProperty<Color>(Color.BLACK);
	public final SimpleIntegerProperty epaisseurs = new SimpleIntegerProperty();
	
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
	public Outils outils = new OutilsCrayon(this);
	public int nTool = 1;
	
	public Controller(Dessin d) {
		dessin = d;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
//		dessinController.setCouleur("noir");

		/*ep.selectedToggleProperty().addListener((obs, old, neww) -> {
			System.out.println(neww);
		});*/
		
		
		this.dessinController.setController(this);
		this.couleursController.setController(this);
		this.menusController.setController(this);
		this.statusController.setController(this);
		
//		dessinController.canvas.getGraphicsContext2D().setStroke(Color.BLACK);
		
		statusController.coX.textProperty().bind(prevX.asString());
		statusController.coY.textProperty().bind(prevY.asString());
		statusController.epaisseur.textProperty().bind(epaisseurs.asString());
		
		ChangeListener gestionnaire = new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (trace != null) {
					dessin.addFigure(trace);
					for (Figure f : dessin.getFigures()) {
						for (int i = 1; i < f.getPoints().size() - 1; i++) {
							dessinController.setCouleur(f.getCouleur());
							dessinController.canvas.getGraphicsContext2D().strokeLine(f.getPoints().get(i - 1).getX(),
									f.getPoints().get(i - 1).getY(), 
									f.getPoints().get(i).getX(),
									f.getPoints().get(i).getY());
						}
					}
				}
			}
		};
		
		dessinController.canvas.widthProperty().addListener(gestionnaire);
		dessinController.canvas.heightProperty().addListener(gestionnaire);
		
		
//		ChangeListener<Toggle> epaisseurListener = new ChangeListener<Toggle>() {
//
//			@Override
//			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
////				epaisseurs.setValue(ep.getSelectedToggle().get);
//				
//			}
//			
//		};
//		
//		ep.selectedToggleProperty().addListener(epaisseurListener);
		
		dessinController.setCouleur("noir");
	}


	public Dessin getDessin() {
		return dessin;
	}


	public Trace getTrace() {
		return trace;
	}

	public void setTrace(Trace t) {
		trace = t;
	}

	public void onMousePressed(MouseEvent evt) {
		
		outils.onMousePress(evt);
	}

	public void onMouseDragged(MouseEvent evt) {
		outils.onMouseDrag(evt);
	}
	
	public void onMouseMove(MouseEvent evt) {
//		statusController.coX.textProperty().set(evt.getX()+"");
//		statusController.coY.textProperty().set(evt.getY()+"");
	}
	
	public void onCrayon() {
		outils = new OutilsCrayon(this);
		menusController.outils.selectToggle(menusController.crayon);
		nTool = 1;
	}
	
	public void onEtoile() {
		outils = new OutilsEtoile(this);
		menusController.outils.selectToggle(menusController.etoile);
		nTool = 2;
	}
	
	public void onGomme() {
		outils = new OutilsGomme(this);
		menusController.outils.selectToggle(menusController.gomme);
	}
	
	public boolean OnQuitter() {
		return Dialogue.confirmation(); 
	}
	
	public void onKeyPressed(String s) {
		switch(s) {
		case "e":
			if(!(outils.getClass() == new OutilsGomme(this).getClass())) {
				onGomme();
			}
			else {
				if(nTool == 1) {
					onCrayon();
				}
				else {
					onEtoile();
				}
			}
			break;
		case "s" :
			onEtoile();
			break;
		case "b" :
			onCrayon();
			break;
		}
	}
	
	public void setEpaisseur(int epais) {
		switch(epais) {
		case 1:
			this.epaisseurs.set(1);
			break; 
		case 2:
			this.epaisseurs.set(2);
			break; 
		case 3:
			this.epaisseurs.set(3);
			break; 
		case 4:
			this.epaisseurs.set(4);
			break; 
		case 5:
			this.epaisseurs.set(5);
			break; 
		case 6:
			this.epaisseurs.set(6);
			break; 
		case 7:
			this.epaisseurs.set(7);
			break; 
		case 8:
			this.epaisseurs.set(8);
			break; 
		case 9:
			this.epaisseurs.set(9);
			break; 
		}
	}
}
