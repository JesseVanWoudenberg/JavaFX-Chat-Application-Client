package app.components;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class MinimizeBox extends StackPane {

    private Rectangle minimizeIcon;

    public MinimizeBox() {

        this.createContent();
        this.setProperties();

    }

    private void createContent() {

        this.minimizeIcon = new Rectangle();
        this.minimizeIcon.setWidth(25);
        this.minimizeIcon.setHeight(5);
        this.minimizeIcon.setArcHeight(30);
        this.minimizeIcon.setArcWidth(10);
        this.minimizeIcon.setFill(Color.gray(1.0));

    }

    private void setProperties() {

        this.setMinSize(40,40);
        this.setMaxSize(40,40);
        this.getChildren().add(this.minimizeIcon);
        this.setStyle
                (
                        "-fx-background-color: #3179d7;"
                );
    }
}
