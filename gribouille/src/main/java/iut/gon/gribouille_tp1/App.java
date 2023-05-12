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
    
    @FXML
    private Label epaisseur;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CadreGribouille.fxml"));
        Dessin d = new Dessin();
        Controller controller = new Controller();
        
//        stage.setTitle();
        controller.setDessin(d);
        fxmlLoader.setController(controller);
    	
    	scene = new Scene(fxmlLoader.load(), 960, 540);
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
        stage.setTitle(d.getNomDuFichier());
//	    Canvas dessin = (Canvas) scene.lookup("Canvas");
	
	    
//	    dessin.addEventHandler(MouseEvent.MOUSE_PRESSED, (evt) -> {prevX = evt.getX(); prevY = evt.getY();
//		    Trace trace = new Trace(3, null, prevX, prevX);
//		    d.addFigure(trace);
//	    });
//	    dessin.addEventHandler(MouseEvent.MOUSE_DRAGGED, (evt) -> {dessin.getGraphicsContext2D().strokeLine(prevX, prevY, evt.getX(), evt.getY());
//		    this.prevX = evt.getX();
//		    this.prevY = evt.getY();
//	    });
	    
	    
	    
    }

    
    
    
//    static void setRoot(String fxml) throws IOException {
//        scene.setRoot(loadFXML(fxml));
//    }

//    private static Parent loadFXML(String fxml) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
//        return fxmlLoader.load();
//    }

    public static void main(String[] args) {
        launch();
    }

}