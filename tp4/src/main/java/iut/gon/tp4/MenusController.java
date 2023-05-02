package iut.gon.tp4;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;

public class MenusController {
	
	private GrilleModel modele;
	private Scores table;
	@FXML private MenuBar menubar;
	
	public void setParams(GrilleModel modele, Scores scores) {
		this.modele = modele;
		this.table = scores;
	}  
	
	@FXML
	  public void onMenuNouvelle(ActionEvent evt) {
	    modele.nouvellePartie();
	  }
	  @FXML
	  public void onMenuTable(ActionEvent evt) throws IOException {
	    FXMLLoader fxmlLoader = new FXMLLoader(Morpion.class.getResource("table.fxml"));
	    Parent racine = fxmlLoader.load();
		TableController controller = fxmlLoader.getController();
	  	if(controller ==  null) throw new RuntimeException("Controlleur null!");
	  	controller.setScores(table);
	    menubar.getScene().setRoot(racine);
	  }

	  @FXML
	  public void onMenuQuitter(ActionEvent evt) {
	    Platform.exit();
	  }
}
