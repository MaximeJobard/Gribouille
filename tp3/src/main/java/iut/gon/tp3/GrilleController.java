package iut.gon.tp3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

public class GrilleController implements Initializable {
	@FXML GridPane grille;
	Label[][] tab;
	GrilleModel gr;
	
	public GrilleController(GrilleModel g) {
		gr = new GrilleModel();
		gr = g;
	} 
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		grille.setStyle("-fx-background-color: seashell");	

		tab = new Label[3][3];
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				Label label = new Label(gr.tab[i][j]); 
				label.setMaxSize(1000, 1000);
				label.setAlignment(Pos.CENTER);

				tab[i][j] = label;
				// Un seul necessaire
				tab[i][j].addEventHandler(MouseEvent.MOUSE_CLICKED, (evt) -> {label.setText("Bonjour");});
				tab[i][j].setOnMouseClicked((evt)-> {label.setText("Bonjour");});
				
				grille.add(tab[i][j], i, j);

			}	
		}
	}
}
