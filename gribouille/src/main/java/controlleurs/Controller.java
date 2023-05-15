package controlleurs;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;
import modele.Dessin;

public class Controller {
	public final Dessin dessin;
	public final SimpleObjectProperty couleur = new SimpleObjectProperty<Color>(Color.BLACK);
	public final SimpleIntegerProperty epaisseur = new SimpleIntegerProperty(1);
	
	public Controller(Dessin d) {
		dessin = d;
	}
	
}
