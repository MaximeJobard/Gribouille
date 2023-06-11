package iut.gon.gribouille_tp1;

import java.io.File;
import java.util.Optional;

import javafx.scene.control.*;
import javafx.stage.FileChooser;

public class Dialogue {
	
	public static boolean confirmation() {
		Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Voulez vous sauvegarder ? ", ButtonType.YES, ButtonType.NO);
		Optional<ButtonType> res = a.showAndWait();
		
		if(res.orElse(ButtonType.NO) == ButtonType.NO) {
			return false;
		}
		return true;
	}
	
	public static File sauverFichier() {
		FileChooser fileChooser = new FileChooser();
		return fileChooser.showSaveDialog(null);
	}
	
	public static File chargerFichier() {
		FileChooser fileChooser = new FileChooser();
		return fileChooser.showOpenDialog(null);
	}
}
