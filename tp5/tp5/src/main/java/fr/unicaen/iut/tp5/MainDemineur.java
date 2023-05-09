package fr.unicaen.iut.tp5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainDemineur extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainDemineur.class.getResource("Demineur.fxml"));
		ControllerDemineur cd = new ControllerDemineur();
		fxmlLoader.setController(cd);
		
		stage.setScene(new Scene(fxmlLoader.load()));
		stage.show();
	}
}
