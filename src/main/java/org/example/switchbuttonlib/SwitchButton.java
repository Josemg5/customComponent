package org.example.switchbuttonlib;

import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class SwitchButton extends StackPane {

    // 1. PROPIEDAD (Requisito: Property)
    private final BooleanProperty switchedOn = new SimpleBooleanProperty(false);

    // 2. EVENTO PROPIO (Requisito: Evento personalizado)
    public static final EventType<Event> TOGGLE_EVENT = new EventType<>("SWITCH_TOGGLED");

    private final Rectangle background;
    private final Circle trigger;

    public SwitchButton() {
        // Diseño visual
        background = new Rectangle(100, 50);
        background.setArcWidth(50);
        background.setArcHeight(50);
        background.setFill(Color.GREY);
        background.setStroke(Color.LIGHTGREY);

        trigger = new Circle(25);
        trigger.setFill(Color.WHITE);
        trigger.setStroke(Color.LIGHTGREY);
        trigger.setTranslateX(-25);

        getChildren().addAll(background, trigger);

        // Click para cambiar estado
        setOnMouseClicked(e -> {
            switchedOn.set(!switchedOn.get());
        });

        // Listener para animar y lanzar evento
        switchedOn.addListener((obs, oldState, newState) -> {
            animateSwitch(newState);
            fireEvent(new Event(TOGGLE_EVENT));
        });
    }

    // 3. ANIMACIÓN (Requisito: Animación sencilla)
    private void animateSwitch(boolean on) {
        TranslateTransition animation = new TranslateTransition(Duration.seconds(0.3), trigger);
        animation.setToX(on ? 25 : -25);
        animation.play();

        background.setFill(on ? Color.LIGHTGREEN : Color.GREY);
    }

    // Métodos obligatorios para las Properties de JavaFX
    public BooleanProperty switchedOnProperty() { return switchedOn; }
    public boolean isSwitchedOn() { return switchedOn.get(); }
    public void setSwitchedOn(boolean on) { this.switchedOn.set(on); }

    // Método para permitir que otros escuchen nuestro evento
    public void setOnAction(EventHandler<Event> handler) {
        addEventHandler(TOGGLE_EVENT, handler);
    }
}
