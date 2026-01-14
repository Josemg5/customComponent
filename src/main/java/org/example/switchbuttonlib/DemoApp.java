package org.example.switchbuttonlib;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoApp extends Application {

    @Override
    public void start(Stage stage) {
        SwitchButton miInterruptor = new SwitchButton();

        Label etiquetaEstado = new Label("Estado: APAGADO");
        etiquetaEstado.setStyle("-fx-font-size: 16px;");

        miInterruptor.setOnAction(event -> {
            if (miInterruptor.isSwitchedOn()) {
                etiquetaEstado.setText("Estado: ENCENDIDO");
                etiquetaEstado.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
            } else {
                etiquetaEstado.setText("Estado: APAGADO");
                etiquetaEstado.setStyle("-fx-text-fill: black; -fx-font-size: 16px;");
            }
        });

        VBox root = new VBox(20, miInterruptor, etiquetaEstado);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 30;");

        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("Prueba de SwitchButton");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}