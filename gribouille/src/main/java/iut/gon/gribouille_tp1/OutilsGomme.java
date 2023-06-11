package iut.gon.gribouille_tp1;

import iut.gon.gribouille_tp1.controllers.Controller;
import iut.gon.gribouille_tp1.modele.Trace;
import javafx.scene.input.MouseEvent;

public class OutilsGomme extends Outils{

	public OutilsGomme(Controller c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onMousePress(MouseEvent evt) {
		controlleur.prevX.set(evt.getX());
		controlleur.prevY.set(evt.getY());
	}

	@Override
	public void onMouseDrag(MouseEvent evt) {
		controlleur.dessinController.gomme(evt);
	}

}
