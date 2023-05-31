package fr.iutgon.tp6;

import fr.iutgon.tp6.modele.FabriqueProduits;
import fr.iutgon.tp6.modele.Ligne;
import fr.iutgon.tp6.modele.Produit;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberExpression;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class FactureController implements Initializable {
  public TableView<Ligne> table;
  public TableColumn<Ligne, Integer> qte;
  public TableColumn<Ligne, Produit> produit;
  public TableColumn<Ligne, Number> prixUnitaire;
  public TableColumn<Ligne, Number> totalHT;
  public TableColumn<Ligne, Number> totalTTC;
  public TextField sommeFacture;
  public float somme;

  /**
   Called to initialize a controller after its root element has been completely processed.

   @param location  The location used to resolve relative paths for the root object, or
   {@code null} if the location is not known.
   @param resources The resources used to localize the root object, or {@code null} if
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
	  somme = 0;
	  
	  qte.setCellValueFactory(new PropertyValueFactory<>("qte"));
	  produit.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ligne,Produit>, ObservableValue<Produit>>() {
		  @Override
		public ObservableValue<Produit> call(CellDataFeatures<Ligne, Produit> param) {
			return param.getValue().produitProperty();
		}
	  });
	  
	  prixUnitaire.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ligne,Number>, ObservableValue<Number>>() {

			@Override
			public ObservableValue<Number> call(CellDataFeatures<Ligne, Number> param) {
				return param.getValue().getProduit().prixProperty();
			}
		});
	  
	  totalHT.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ligne,Number>, ObservableValue<Number>>() {

		@Override
		public ObservableValue<Number> call(CellDataFeatures<Ligne, Number> param) {
			return param.getValue().totalHTProperty();
		}
		});
	  
	  totalTTC.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ligne,Number>, ObservableValue<Number>>() {

			@Override
			public ObservableValue<Number> call(CellDataFeatures<Ligne, Number> param) {
				return param.getValue().totalTTCProperty();
			}
			});
	  
	  
	  qte.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
	  produit.setCellFactory(ChoiceBoxTableCell.forTableColumn(new StringConverter<Produit>() {

		@Override
		public String toString(Produit object) {
			return object.getNom();
		}

		@Override
		public Produit fromString(String string) {
			for (int i = 0; i < table.getItems().size() ; i ++) {
				if (table.getItems().get(i).getProduit().getNom() == string) {
					return table.getItems().get(i).getProduit();
				}
			}
			return null;
		}}
	  ,FXCollections.observableList(FabriqueProduits.getProduits())));
  }
  



  	public void onAjouter(ActionEvent actionEvent) {
	  Random r = new Random();
	  Ligne ligne = new Ligne(r.nextInt(15), FabriqueProduits.getProduits().get(2));
	  table.getItems().add(ligne);
	  
//	  somme += ligne.getTotalTTC().floatValue();
//	  sommeFacture = Bindings.add(sommeFacture, somme);
	}
}
