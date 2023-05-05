package iut.gon.gribouille_tp1;

import java.util.Optional;

import javafx.scene.control.*;

public class Dialogue {
	
	public static boolean confirmation() {
		Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Oui ou Non ? ", ButtonType.YES, ButtonType.NO);
		Optional<ButtonType> res = a.showAndWait();
		
		if(res.orElse(ButtonType.NO) == ButtonType.NO) {
			return false;
		}
		return true;
	}
}
