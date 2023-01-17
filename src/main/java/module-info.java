module com.francisco.ProyectoHilos {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;


    opens com.francisco.ProyectoHilos to javafx.fxml;
    exports com.francisco.ProyectoHilos;
}
