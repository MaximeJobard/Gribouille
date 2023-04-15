package iut.gon.tp3;

import javafx.beans.property.SimpleStringProperty;

public class GrilleModel {
//	String tab[][] = new String[3][3];
//	
//	public GrilleModel() {
//		for (int i = 0 ; i < 3 ; i++) {
//			for (int j = 0 ; j < 3 ; j++) {
//					tab[i][j] = "";
//			}
//		}
//	}
//	
//	public void setCase(int lg, int col, String texte) {
//		tab[lg][col] = texte;
//	}
//	
//	public String getCase(int lg, int col) {
//		return tab[lg][col];
//	}
//	

	SimpleStringProperty tab[][] = new SimpleStringProperty[3][3];

	public GrilleModel() {
	for (int i = 0 ; i < 3 ; i++) {
		for (int j = 0 ; j < 3 ; j++) {
				tab[i][j] = new SimpleStringProperty("Vide");
		}
	}
}

	
	public SimpleStringProperty getCase(int lg, int cl) {
		return tab[lg][cl];
	}

	public void setCase(int lg, int cl, String s) {
		tab[lg][cl].setValue(s);
	}
	
	


}
