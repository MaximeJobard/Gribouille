package iut.gon.gribouille_tp1;

import iut.gon.gribouille_tp1.controllers.Controller;
import javafx.scene.input.MouseEvent;

public abstract class Outils {
	protected Controller controlleur;
	
	public Outils(Controller c) {
		controlleur = c;
	}
	
	public abstract void onMousePress(MouseEvent evt);
	
	public abstract void onMouseDrag(MouseEvent evt);
	
}
