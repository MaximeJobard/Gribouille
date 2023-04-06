module iut.gon.gribouille_tp1 {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	requires java.xml;

    opens iut.gon.gribouille_tp1 to javafx.fxml;
    exports iut.gon.gribouille_tp1;
}
