package iut.gon.gribouille_tp1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import modele.Dessin;
import modele.Figure;
import modele.Trace;

public class Controller implements Initializable {

	private Dessin dessin;
	private Trace trace;


	@FXML
	private Label epaisseur;

	@FXML
	private ToggleGroup outils;

	@FXML
	private Label coX;

	@FXML
	private Label coY;

	@FXML
	private Pane pane;

	@FXML
	private Canvas canvas;

	@FXML
	private ColorPicker ColorPicker;

	@FXML
	private Rectangle rouge;

	@FXML
	private Rectangle vert;

	@FXML
	private Rectangle bleu;

	@FXML
	private Rectangle cyan;

	@FXML
	private Rectangle rose;

	@FXML
	private Rectangle jaune;

	@FXML
	private Rectangle noir;

	@FXML
	private Rectangle blanc;

	private SimpleDoubleProperty prevX = new SimpleDoubleProperty();
	private SimpleDoubleProperty prevY = new SimpleDoubleProperty();

	public void initialize(URL location, ResourceBundle resources) {
		canvas.widthProperty().bind(pane.widthProperty());
		canvas.heightProperty().bind(pane.heightProperty());
		ChangeListener gestionnaire = new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (trace != null) {
					dessin.addFigure(trace);
					for (Figure f : dessin.getFigures()) {
						for (int i = 1; i < f.getPoints().size() - 1; i++) {
							canvas.getGraphicsContext2D().strokeLine(f.getPoints().get(i - 1).getX(),
									f.getPoints().get(i - 1).getY(), f.getPoints().get(i).getX(),
									f.getPoints().get(i).getY());
						}
					}
				}

			}

		};
		canvas.widthProperty().addListener(gestionnaire);
		canvas.heightProperty().addListener(gestionnaire);
		
		coX.textProperty().bind(prevX.asString());
		coY.textProperty().bind(prevY.asString());
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

	public void setDessin(Dessin d) {
		dessin = d;
	}
}
