package org.example.switchbuttonlib;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class SwitchButton extends Parent {

    private final BooleanProperty switchedOn = new SimpleBooleanProperty(false);
    private final BooleanProperty vertical = new SimpleBooleanProperty(false);

    private final ObjectProperty<Color> colorOn = new SimpleObjectProperty<>(Color.web("#4CAF50"));
    private final ObjectProperty<Color> colorOff = new SimpleObjectProperty<>(Color.web("#B0BEC5"));

    private final Rectangle background;
    private final Circle trigger;

    private final TranslateTransition translateAnimation = new TranslateTransition(Duration.seconds(0.25));
    private final FillTransition fillAnimation = new FillTransition(Duration.seconds(0.25));
    private final ParallelTransition animation = new ParallelTransition(translateAnimation, fillAnimation);
    private final RotateTransition rotateAnimation = new RotateTransition(Duration.seconds(0.3), this);

    public SwitchButton() {
        background = new Rectangle(100, 50);
        background.setArcWidth(50);
        background.setArcHeight(50);
        background.setFill(colorOff.get());
        background.setStroke(null);

        trigger = new Circle(25);
        trigger.setCenterX(25);
        trigger.setCenterY(25);
        trigger.setFill(Color.WHITE);

        DropShadow shadow = new DropShadow();
        shadow.setRadius(5.0);
        shadow.setColor(Color.color(0, 0, 0, 0.2));
        trigger.setEffect(shadow);

        translateAnimation.setNode(trigger);
        fillAnimation.setShape(background);

        getChildren().addAll(background, trigger);

        setCursor(Cursor.HAND);

        setOnMouseClicked(event -> {
            if (!isDisabled()) {
                switchedOn.set(!switchedOn.get());
            }
        });

        switchedOn.addListener((obs, oldState, newState) -> {
            boolean isOn = newState;
            translateAnimation.setToX(isOn ? 50 : 0);
            fillAnimation.setFromValue((Color) background.getFill());
            fillAnimation.setToValue(isOn ? colorOn.get() : colorOff.get());
            animation.play();
        });

        vertical.addListener((obs, oldVal, newVal) -> {
            rotateAnimation.setToAngle(newVal ? -90 : 0);
            rotateAnimation.play();
        });

        disabledProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                setCursor(Cursor.DEFAULT);
            } else {
                setCursor(Cursor.HAND);
            }
        });
    }

    public boolean isSwitchedOn() { return switchedOn.get(); }
    public void setSwitchedOn(boolean on) { this.switchedOn.set(on); }
    public BooleanProperty switchedOnProperty() { return switchedOn; }

    public boolean isVertical() { return vertical.get(); }
    public void setVertical(boolean v) { this.vertical.set(v); }
    public BooleanProperty verticalProperty() { return vertical; }

    public Color getColorOn() { return colorOn.get(); }
    public void setColorOn(Color c) { this.colorOn.set(c); }
    public ObjectProperty<Color> colorOnProperty() { return colorOn; }

    public Color getColorOff() { return colorOff.get(); }
    public void setColorOff(Color c) { this.colorOff.set(c); }
    public ObjectProperty<Color> colorOffProperty() { return colorOff; }
}