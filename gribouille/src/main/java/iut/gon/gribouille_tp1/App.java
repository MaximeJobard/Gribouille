package iut.gon.gribouille_tp1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

import iut.gon.gribouille_tp1.controllers.*;
import iut.gon.gribouille_tp1.modele.*;

/**
 * JavaFX App
 */
public class App extends Application {

	private double prevX;
	private double prevY;
	
    private static Scene scene;
    
    @FXML
    private Label epaisseur;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CadreGribouille.fxml"));
        Dessin d = new Dessin();
        Controller controller = new Controller(d);
        stage.setTitle("Gribouille");
        
        fxmlLoader.setController(controller);
    	
        stage.addEventHandler(javafx.scene.input.KeyEvent.KEY_PRESSED, (evt) -> {
        	
        	controller.onKeyPressed(evt.getText());
        	System.out.println(evt.getText());
        	
        	switch (evt.getText()) {
			// Effacer
			case "a": 
				controller.dessinController.efface();
				break;
				
			// Changement Outil
			case "c": 
				controller.onCrayon(); 
				break;
			case "x":
				controller.onEtoile(); 
				break;
			case "g":
				controller.onGomme();
				break;
			// Changement Épaisseur
			case "&":
				controller.setEpaisseur(1);
				break;
			case "é": 
				controller.setEpaisseur(2); 
				break;
			case "\"":
				controller.setEpaisseur(3);
				break;
			case "'": 
				controller.setEpaisseur(4);
				break;
			case "(": 
				controller.setEpaisseur(5);  
				break;
			case "-": 
				controller.setEpaisseur(6);  
				break;
			case "è": 
				controller.setEpaisseur(7); 
				break;
			case "_": 
				controller.setEpaisseur(8);
				break;
			case "ç": 
				controller.setEpaisseur(9); 
				break;
				
			// Changement Couleur
			case "1":
				controller.dessinController.setCouleur("rouge"); 
				break;
			case "2":
				controller.dessinController.setCouleur("vert"); 
				break;     
			case "3": 
				controller.dessinController.setCouleur("bleu");  
				break;
			case "4":
				controller.dessinController.setCouleur("cyan");   
				break;
			case "5": 
				controller.dessinController.setCouleur("rose");  
				break;
			case "6":
				controller.dessinController.setCouleur("jaune"); 
				break;
			case "7": 
				controller.dessinController.setCouleur("noir"); 
				break;
			case "8": 
				controller.dessinController.setCouleur("blanc");  
				break;
		}
        	
        });
        
    	scene = new Scene(fxmlLoader.load(), 960, 540);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
        	if(controller.onQuitter()) {
        		Platform.exit();
        	}
        	else{
        		event.consume();
        	}
        }
	    );
        stage.setTitle(d.getNomDuFichier());
    }

    public static void main(String[] args) {
        launch();
    }

}