package controlleurs;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import modele.Dessin;

public class Controller implements Initializable {
	public final Dessin dessin;
	public final SimpleObjectProperty<Color> couleur = new SimpleObjectProperty<Color>(Color.BLACK);
	public final SimpleIntegerProperty epaisseur = new SimpleIntegerProperty(1);
	
	@FXML
	public CouleursController couleursController;
	
	@FXML
	public DessinController dessinController;

	@FXML
	public MenusController menusController;
	
	@FXML
	public StatusController statusController;
	
	public Controller(Dessin d) {
		dessin = d;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		couleursController = new CouleursController();
		dessinController = new DessinController();
		menusController = new MenusController();
		statusController = new StatusController();
		
		couleursController.initialize(location, resources);
		dessinController.initialize(location, resources);
		menusController.initialize(location, resources);
		statusController.initialize(location, resources);
	}

	public CouleursController getCouleursController() {
		return couleursController;
	}

	public void setCouleursController(CouleursController couleursController) {
		this.couleursController = couleursController;
	}

	public DessinController getDessinController() {
		return dessinController;
	}

	public void setDessinController(DessinController dessinController) {
		this.dessinController = dessinController;
	}

	public MenusController getMenusController() {
		return menusController;
	}

	public void setMenusController(MenusController menusController) {
		this.menusController = menusController;
	}

	public StatusController getStatusController() {
		return statusController;
	}

	public void setStatusController(StatusController statusController) {
		this.statusController = statusController;
	}
	
}
