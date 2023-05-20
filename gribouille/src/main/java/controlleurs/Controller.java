package controlleurs;

import java.net.URL;
import java.util.ResourceBundle;

import iut.gon.gribouille_tp1.Dialogue;
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
import modele.Dessin;
import modele.Trace;

public class Controller implements Initializable {
	public final SimpleObjectProperty<Color> couleur = new SimpleObjectProperty<Color>(Color.BLACK);
	public final SimpleIntegerProperty epaisseurs = new SimpleIntegerProperty(1);
	
	@FXML
	public CouleursController couleursController;
	
	@FXML
	public DessinController dessinController;

	@FXML
	public MenusController menusController;
	
	@FXML
	public StatusController statusController;
	
	@FXML
	public Canvas canvas;
	
	@FXML
	public Label coX;
	
	@FXML
	public Label coY;
	
	@FXML
	public Label epaisseur;
	
	@FXML
	public ToggleGroup ep;
	
	private Dessin dessin;
	private Trace trace;
	private SimpleDoubleProperty prevX = new SimpleDoubleProperty();
	private SimpleDoubleProperty prevY = new SimpleDoubleProperty();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		couleursController = new CouleursController();
		dessinController = new DessinController();
		menusController = new MenusController();
		statusController = new StatusController();
		
		couleursController.initialize(location, resources);
		dessinController.initialize(location, resources);
		menusController.initialize(location, resources);
		statusController.initialize(location, resources);
		
		coX.textProperty().bind(prevX.asString());
		coY.textProperty().bind(prevY.asString());
		epaisseur.textProperty().bind(ep.getSelectedToggle().getProperties());
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
		canvas.getGraphicsContext2D().strokeLine(prevX.getValue(), prevY.getValue(), evt.getX(), evt.getY());
		trace.addPoint(prevX.getValue(), prevY.getValue());
		this.prevX.set(evt.getX());
		this.prevY.set(evt.getY());
	}
	
	public boolean OnQuitter() {
		return Dialogue.confirmation();
	}
	
}
