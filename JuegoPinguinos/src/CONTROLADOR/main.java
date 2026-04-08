package CONTROLADOR;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // ← AQUÍ la ruta del MenuPantalla.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/VISTA/MenuPantalla.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Juego Pingüinos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}