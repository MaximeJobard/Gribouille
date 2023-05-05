package iut.gon.gribouille_tp1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Controller implements Initializable {

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
	}
	
	public void onMousePressed(MouseEvent evt) {
		
	}
	
	public void onMouseDragged(MouseEvent evt) {
		
	}

}
