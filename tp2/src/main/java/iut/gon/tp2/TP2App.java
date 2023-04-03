package iut.gon.tp2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TP2App extends Application {

  private BorderPane contenu;
  private ListView<String> gauche;
  private ListView<String> droite;
  private Button versGauche;
  private Button versDroite;
  private Button retireTout;
  private Button ajouteTout;
  
  private Menu fichier;
  private Menu aide;
  private MenuItem quitter;
  private MenuItem a_propos;
  private Alert a;


  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(TP2App.class.getResource("Tp2.fxml"));
    contenu = fxmlLoader.load();
    Scene scene = new Scene(contenu);
    extraitIds(scene);
    
    fichier = new Menu("_Fichier");
    aide = new Menu("_Aide");
    quitter = new MenuItem("_Quitter");
    a_propos = new MenuItem("_A Propos");
    a = new Alert(Alert.AlertType.NONE, "Fait par Moi", ButtonType.CLOSE);
    
    ajouteTout.setDisable(false);

    prepareMenus((MenuBar) scene.lookup("#menus"));
    prepareListe();
    prepareBoutons();
    prepareFermeture(stage);

    stage.setTitle("Gestion de groupe");
    stage.setScene(scene);
    stage.show();
  }

  /** Prépare la fenêtre pour demander confirmation avant fermeture */
  private void prepareFermeture(Stage stage) {
    stage.setOnCloseRequest(event -> {
      //TODO confirmer ou consommer l'événement
    });
  }

  /** Prépare les actions des boutons */
  private void prepareBoutons() {
    ajouteTout.setOnAction(this::onAjouteTout);
    retireTout.setOnAction(this::onRetireTout);
  }

  /** Ajoute tous les éléments de gauche dans la liste de droite
   Active le bouton "Retirer tout" et désactive le bouton "Ajouter tout" */
  private void onAjouteTout(ActionEvent actionEvent) {
    droite.getItems().addAll(gauche.getItems());
    gauche.getItems().clear();
    ajouteTout.setDisable(true);
    retireTout.setDisable(false);

  }

  /** Ajoute tous les éléments de droite dans la liste de gauche
   Active le bouton "Ajouter tout" et désactive le bouton "Retirer tout" */
  private void onRetireTout(ActionEvent actionEvent) {
	  gauche.getItems().addAll(droite.getItems());
	  droite.getItems().clear();
	  ajouteTout.setDisable(false);
	  retireTout.setDisable(true);
  }

  /** Prépare les menus et leurs événements */
  private void prepareMenus(MenuBar menus) {
	  menus.getMenus().addAll(fichier, aide);
	  menus.getMenus().get(0).getItems().addAll(quitter);
	  menus.getMenus().get(1).getItems().addAll(a_propos);
	  
	  quitter.addEventHandler(ActionEvent.ACTION, (evt) -> Platform.exit());
	  a_propos.addEventHandler(ActionEvent.ACTION, (evt) -> a.show());
  }

  /**
   Remplit la liste de gauche avec des valeurs
   Active le bouton "Ajouter tout"
   */
  private void prepareListe() {
	    gauche.getItems().add("test");
	    gauche.getItems().add("truc");
	    gauche.getItems().add("machin");
	    gauche.getItems().add("encore test");
  }

  private void extraitIds(Scene scene) {
    gauche = (ListView<String>) scene.lookup("#gauche");
    droite = (ListView<String>) scene.lookup("#droite");
    versGauche = (Button) scene.lookup("#versGauche");
    versDroite = (Button) scene.lookup("#versDroite");
    retireTout = (Button) scene.lookup("#retireTout");
    ajouteTout = (Button) scene.lookup("#ajouteTout");
  }

  public static void main(String[] args) {
    launch();
  }
}
