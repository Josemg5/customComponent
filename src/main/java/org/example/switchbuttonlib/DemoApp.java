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
        // 1. Creamos nuestro componente personalizado
        SwitchButton miInterruptor = new SwitchButton();

        // 2. Etiqueta para ver el estado en texto
        Label etiquetaEstado = new Label("Estado: APAGADO");
        etiquetaEstado.setStyle("-fx-font-size: 16px;");

        // 3. Usamos el evento personalizado para actualizar el texto
        miInterruptor.setOnAction(event -> {
            if (miInterruptor.isSwitchedOn()) {
                etiquetaEstado.setText("Estado: ENCENDIDO");
                etiquetaEstado.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
            } else {
                etiquetaEstado.setText("Estado: APAGADO");
                etiquetaEstado.setStyle("-fx-text-fill: black; -fx-font-size: 16px;");
            }
        });

        // 4. Organizamos todo en una caja vertical (VBox)
        VBox root = new VBox(20, miInterruptor, etiquetaEstado);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 30;");

        // 5. Configuramos la escena y la ventana
        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("Prueba de SwitchButton");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}