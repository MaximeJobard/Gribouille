package iut.gon.gribouille_tp1;

import iut.gon.gribouille_tp1.controllers.Controller;
import iut.gon.gribouille_tp1.modele.Trace;
import javafx.scene.input.MouseEvent;

public class OutilsCrayon extends Outils{

	public OutilsCrayon(Controller c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onMousePress(MouseEvent evt) {
		controlleur.prevX.set(evt.getX());
		controlleur.prevY.set(evt.getY());
		if (controlleur.getTrace() != null) {
			if(controlleur.getTrace().getPoints().size()>1) {
				controlleur.getDessin().addFigure(controlleur.getTrace());
			}
		}
		controlleur.setTrace(new Trace(10, controlleur.couleursController.rec.getId(), controlleur.prevX.getValue(), controlleur.prevY.getValue()));
	}

	@Override
	public void onMouseDrag(MouseEvent evt) {
		controlleur.dessinController.canvas.getGraphicsContext2D().strokeLine(controlleur.prevX.getValue(), controlleur.prevY.getValue(), evt.getX(), evt.getY());
		controlleur.getTrace().addPoint(controlleur.prevX.getValue(), controlleur.prevY.getValue());
		controlleur.prevX.set(evt.getX());
		controlleur.prevY.set(evt.getY());
		controlleur.getDessin().addFigure(controlleur.getTrace()); 
	}

}
