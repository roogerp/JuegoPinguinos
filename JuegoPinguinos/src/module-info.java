/**
 * 
 */
/**
 * 
 */
module JuegoPinguinos {
    requires javafx.controls;
    requires javafx.fxml;
	requires jdk.jdi;
	requires java.sql;

    exports CONTROLADOR;        // ← afegeix això
    opens CONTROLADOR to javafx.graphics;   // ← i això
    opens VISTA to javafx.fxml;

}