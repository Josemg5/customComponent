package org.example.switchbuttonlib;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DemoApp extends Application {

    @Override
    public void start(Stage stage) {

        SwitchButton btnNormal = new SwitchButton();

        CheckBox chkRotate = new CheckBox("Rotar este botón");
        chkRotate.selectedProperty().addListener((o, oldVal, newVal) -> btnNormal.setVertical(newVal));

        VBox col1 = createColumn("Normal", btnNormal);
        col1.getChildren().add(chkRotate);

        SwitchButton btnVertical = new SwitchButton();
        btnVertical.setVertical(true);
        btnVertical.setColorOn(Color.web("#FF5722"));

        VBox col2 = createColumn("Vertical", btnVertical);
        col2.setMinWidth(120);

        SwitchButton btnPrueba = new SwitchButton();
        btnPrueba.setColorOff(Color.RED);
        btnPrueba.setColorOn(Color.GREEN);

        CheckBox chkDisable = new CheckBox("Bloquear (Disable)");
        btnPrueba.disableProperty().bind(chkDisable.selectedProperty());

        CheckBox chkForce = new CheckBox("Forzar Encendido");
        btnPrueba.switchedOnProperty().bindBidirectional(chkForce.selectedProperty());

        VBox controlsPrueba = new VBox(10, chkDisable, chkForce);
        controlsPrueba.setAlignment(Pos.CENTER_LEFT);

        VBox col3 = createColumn("Botón Pruebas", btnPrueba);
        col3.getChildren().add(controlsPrueba);

        HBox mainLayout = new HBox(80);
        mainLayout.setAlignment(Pos.TOP_CENTER);
        mainLayout.getChildren().addAll(col1, col2, col3);

        VBox root = new VBox(mainLayout);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(50));
        root.setStyle("-fx-background-color: white;");

        Scene scene = new Scene(root, 950, 500);
        stage.setTitle("SwitchButton Demo Final");
        stage.setScene(scene);
        stage.show();
    }

    private VBox createColumn(String title, SwitchButton btn) {
        Label lbl = new Label(title);
        lbl.setFont(new Font(16));
        VBox box = new VBox(25, lbl, btn);
        box.setAlignment(Pos.TOP_CENTER);
        return box;
    }

    public static void main(String[] args) {
        launch();
    }
}