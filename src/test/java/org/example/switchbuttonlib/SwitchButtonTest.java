package org.example.switchbuttonlib;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;

public class SwitchButtonTest extends ApplicationTest {

    private SwitchButton boton;

    @Override
    public void start(Stage stage) {
        boton = new SwitchButton();
        stage.setScene(new Scene(new StackPane(boton), 100, 100));
        stage.show();
    }

    // Test de Lógica (JUnit puro)
    @Test
    public void testLogic() {
        assertFalse(boton.isSwitchedOn(), "El botón debería empezar apagado");
        boton.setSwitchedOn(true);
        assertTrue(boton.isSwitchedOn(), "El botón debería estar encendido");
    }

    // Test de Interacción (TestFX)
    @Test
    public void testClickInteraction() {
        // El robot hace clic en el botón
        clickOn(boton);
        assertTrue(boton.isSwitchedOn(), "El botón debería encenderse al hacer clic");

        // El robot hace clic otra vez
        clickOn(boton);
        assertFalse(boton.isSwitchedOn(), "El botón debería apagarse al hacer clic de nuevo");
    }
}