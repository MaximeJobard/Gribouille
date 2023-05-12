package iut.gon.gribouille_tp1;

import java.net.URL;
import java.util.ResourceBundle;

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

	private double prevX;
	private double prevY;

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
	}

	public void onMousePressed(MouseEvent evt) {
		prevX = evt.getX();
		prevY = evt.getY();
		if (trace != null) {
			if(trace.getPoints().size()>1) {
				dessin.addFigure(trace);
			}
		}
		trace = new Trace(10, "noir", prevX, prevY);
	}

	public void onMouseDragged(MouseEvent evt) {
		canvas.getGraphicsContext2D().strokeLine(prevX, prevY, evt.getX(), evt.getY());
		trace.addPoint(prevX, prevY);
		this.prevX = evt.getX();
		this.prevY = evt.getY();

	}

	public void setDessin(Dessin d) {
		dessin = d;
	}

}
