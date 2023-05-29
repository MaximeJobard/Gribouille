package fr.unicaen.iut.tp5;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.net.http.WebSocket.Listener;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;

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

	BackgroundFill aqua = new BackgroundFill(Color.AQUA, new CornerRadii(0.2), new Insets(0));
	BackgroundFill lightgray = new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(0), new Insets(0));
	BackgroundFill red = new BackgroundFill(Color.RED, new CornerRadii(0.2), new Insets(0));
	BackgroundFill lemonchiffon = new BackgroundFill(Color.LEMONCHIFFON, new CornerRadii(0.2), new Insets(0));

	Background inconnu = new Background(aqua);
	Background libre = new Background(lightgray);
	Background echec = new Background(red);
	Background marquee = new Background(lemonchiffon);

	int x;
	int y;
	
	public void initGrille(String s) {
		gridpane.getColumnConstraints().clear();
		gridpane.getRowConstraints().clear();
		int[] t = modele.parseUserData(s);
		modele.setTaille(t[0], t[1], t[2]);

		for (int i = 0; i < t[0]; i++) {
			gridpane.getColumnConstraints().add(new ColumnConstraints(32));
			gridpane.getRowConstraints().add(new RowConstraints(32));
		}
		
		for(int i = 0 ; i < t[0]; i++) {
			for(int j = 0 ; j < t[1]; j++) {
				Label l = new Label("?");
				l.setBackground(inconnu);
				l.setPrefSize(31, 31);
				l.setTextAlignment(TextAlignment.CENTER);
				
				x = i;
				y = j;
				l.textProperty().bind(modele.texteProperty(x, y));
				
				l.addEventHandler(MouseEvent.MOUSE_CLICKED, (evt) -> {
					if (evt.getButton() == MouseButton.PRIMARY && l.getBackground() == inconnu) {
						modele.revele(x, y);
						if (modele.estPerdu()) {
							l.setBackground(echec);
						}
						else{
							l.setBackground(libre);
						}
					}
					
					
					if (evt.getButton() == MouseButton.SECONDARY && l.getBackground() == inconnu) {
						l.setBackground(marquee);
						modele.marque(x, y);
					}
					
				});
				
				gridpane.add(l, i, j);
			}
		}
		
	}
}
