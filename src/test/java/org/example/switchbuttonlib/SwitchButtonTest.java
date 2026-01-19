package org.example.switchbuttonlib;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;

class SwitchButtonTest extends ApplicationTest {

    private SwitchButton button;

    @Override
    public void start(Stage stage) {
        button = new SwitchButton();
        stage.setScene(new Scene(new StackPane(button), 100, 100));
        stage.show();
    }

    @Test
    void testClickInteraction() {
        assertFalse(button.isSwitchedOn(), "Debería empezar apagado");

        clickOn(button);

        assertTrue(button.isSwitchedOn(), "Debería encenderse tras el clic");

        clickOn(button);

        assertFalse(button.isSwitchedOn(), "Debería apagarse tras el segundo clic");
    }


    @Test
    void testVerticalProperty() {
        SwitchButton btn = new SwitchButton();
        btn.setVertical(true);
        assertTrue(btn.isVertical());
    }

    @Test
    void testColorProperties() {
        SwitchButton btn = new SwitchButton();
        btn.setColorOn(Color.GOLD);
        assertEquals(Color.GOLD, btn.getColorOn());
    }

    @Test
    void testDisabledState() {
        SwitchButton btn = new SwitchButton();
        btn.setDisable(true);
        assertTrue(btn.isDisabled());
    }
}