package iut.gon.tp3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        
        GrilleModel g = new GrilleModel();
        GrilleController grille = new GrilleController(g);
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primary.fxml"));

        fxmlLoader.setController(grille);
        scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setScene(scene);
        stage.show();
        
        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
        	switch (event.getText()) {
        	case "1" : g.setCase(2,0, "Touche"); break;
        	case "2" : g.setCase(2,1, "Touche"); break;
        	case "3" : g.setCase(2,2, "Touche"); break;
        	case "4" : g.setCase(1,0, "Touche"); break;
        	case "5" : g.setCase(1,1, "Touche"); break;
        	case "6" : g.setCase(1,2, "Touche"); break;
        	case "7" : g.setCase(0,0, "Touche"); break;
        	case "8" : g.setCase(0,1, "Touche"); break;
        	case "9" : g.setCase(0,2, "Touche"); break;
        	}
        	});
    }

  

    public static void main(String[] args) {
        launch();
    }

}