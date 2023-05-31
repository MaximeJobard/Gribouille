package iut.gon.gribouille_tp1;

import iut.gon.gribouille_tp1.controllers.Controller;

public abstract class Outils {
	protected Controller controlleur;
	
	public Outils(Controller c) {
		controlleur = c;
	}
	
	public abstract void onMousePress();
	
	public abstract void onMouseDrag();
	
}
