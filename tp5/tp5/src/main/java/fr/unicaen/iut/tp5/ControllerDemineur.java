package fr.unicaen.iut.tp5;

import java.net.URL;
import java.net.http.WebSocket.Listener;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class ControllerDemineur implements Initializable {

	@FXML
	private BorderPane borderPane;

	@FXML
	private VBox vbox;

	@FXML
	private MenuBar menuBar;

	@FXML
	private Menu jeu;

	@FXML
	private MenuItem quitter;

	@FXML
	private Menu difficulte;

	@FXML
	private RadioMenuItem facile;

	@FXML
	private ToggleGroup difficulteToggleGroupe;

	@FXML
	private RadioMenuItem moyen;

	@FXML
	private RadioMenuItem difficile;

	@FXML
	private HBox hBox;

	@FXML
	private Label nombreDInconnues;

	@FXML
	private TextField textInconues;

	@FXML
	private Label nombreDeMarques;

	@FXML
	private TextField textMarques;

	@FXML
	private GridPane gridpane;

	private ModeleDemineur modele;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		modele = new ModeleDemineur(0, 0, 0);

		textInconues.textProperty().bind(modele.nbInconnuesProperty().asString());
		textMarques.textProperty().bind(modele.nbMarquesProperty().asString());

		difficulteToggleGroupe.selectedToggleProperty().addListener((observable, old, newValue) -> {
			initGrille(newValue.getUserData().toString());
		});
	}

	public void initGrille(String s) {
		gridpane.getColumnConstraints().clear();
		gridpane.getRowConstraints().clear();
		int[] t = modele.parseUserData(s);
		modele.setTaille(t[0], t[1], t[2]);

		for(int i = 0; i < t[0]; i++){
			
				gridpane.getColumnConstraints().add(new ColumnConstraints(32));
				gridpane.getRowConstraints().add(new RowConstraints(32));
			
		}
	}
}
