package CONTROLADOR;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/PantallaMenu.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Juego del Pingüino");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}