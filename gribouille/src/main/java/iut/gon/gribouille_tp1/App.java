package iut.gon.gribouille_tp1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modele.*;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

	private double prevX;
	private double prevY;
	
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CadreGribouille.fxml"));
        Dessin d = new Dessin();
        
    	
    	scene = new Scene(loadFXML("CadreGribouille"), 960, 540);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
        	if(Dialogue.confirmation()) {
        		Platform.exit();
        	}
        	else{
        		event.consume();
        	}
        }
	    );
	    Canvas dessin = (Canvas) scene.lookup("Canvas");
	
	    
	    dessin.addEventHandler(MouseEvent.MOUSE_PRESSED, (evt) -> {prevX = evt.getX(); prevY = evt.getY();});
	    dessin.addEventHandler(MouseEvent.MOUSE_DRAGGED, (evt) -> {dessin.getGraphicsContext2D().strokeLine(prevX, prevY, evt.getX(), evt.getY());
	    this.prevX = evt.getX();
	    this.prevY = evt.getY();
	    });
	    
    }

    
    
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
//
////    private static Parent loadFXML(String fxml) throws IOException {
////        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
////        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}