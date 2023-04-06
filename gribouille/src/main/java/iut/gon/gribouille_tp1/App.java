package iut.gon.gribouille_tp1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    double X;
    double Y;

    @Override
    public void start(Stage stage) throws IOException {
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
        
        Pane pane = (Pane) dessin.getParent();
        
        pane.addEventFilter(MouseEvent.MOUSE_PRESSED, (evt) -> {
                if(evt.getButton() == MouseButton.SECONDARY) {
                        Circle circle =new Circle();
                        circle.setRadius(5.0);
                X = evt.getX(); Y = evt.getY();
                circle.setCenterX(X);
                circle.setCenterY(Y);
                
                dessin.addEventHandler(MouseEvent.MOUSE_PRESSED, (event) -> {X = event.getX(); Y = event.getY(); event.consume();});
                pane.getChildren().add(circle);
                circle.setMouseTransparent(true);
                evt.consume();
                }
                
                if(evt.getButton() == MouseButton.PRIMARY) {
                	dessin.addEventHandler(MouseEvent.MOUSE_PRESSED, (event) -> {X = event.getX(); Y = event.getY();});
                    dessin.addEventHandler(MouseEvent.MOUSE_DRAGGED, (event2) -> {dessin.getGraphicsContext2D().strokeLine(X, Y, event2.getX(), event2.getY());
                    this.X = event2.getX();
                    this.Y = event2.getY();
                    });
                }
        
        });
        
        
        
        
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}