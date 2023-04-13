package iut.gon.tp3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    }

  

    public static void main(String[] args) {
        launch();
    }

}