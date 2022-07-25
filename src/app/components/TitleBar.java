package app.components;

import app.Main;
import javafx.application.Platform;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TitleBar extends AnchorPane {

    private final Stage stage;
    private StackPane exitBox;
    private StackPane minimizeBox;
    private Double x, y;

    public TitleBar(Stage stage) {

        this.stage = stage;
        this.init();

    }

    private void init() {

        this.createComponents();
        this.setProperties();
        this.functionality();
        this.setAnchors();

    }

    private void createComponents() {

        this.exitBox = new ExitBox();
        this.minimizeBox = new MinimizeBox();

    }

    private void setProperties() {

        this.getChildren().addAll(this.minimizeBox, this.exitBox);

        this.setStyle("-fx-background-color: #3179d7;");

        this.setMinSize(Main.appWidth, 40);
        this.setMaxSize(Main.appWidth, 40);

    }

    private void setAnchors() {

        AnchorPane.setTopAnchor(this.exitBox, (double) 0);
        AnchorPane.setRightAnchor(this.exitBox, (double) 0);

        AnchorPane.setTopAnchor(this.minimizeBox, (double) 0);
        AnchorPane.setRightAnchor(this.minimizeBox, (double) 40);

    }

    private void functionality() {

        //ExitBox Functionality (Hover and click on action)
        this.exitBox.setOnMouseEntered(event -> this.exitBox.setStyle
                (
                        "-fx-background-color: #e32c2c;"
                ));

        this.exitBox.setOnMouseExited(event -> this.exitBox.setStyle
                (
                        "-fx-background-color: #3179d7;"
                ));

        this.exitBox.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                this.stage.close();

                // Closing threads to close app
                Main.getThreadsArrayList().forEach(Thread::interrupt);

                Platform.exit();
                System.exit(0);
            }
        });

        //MinimizeBox Functionality (Hover and click on action)
        this.minimizeBox.setOnMouseEntered(event -> this.minimizeBox.setStyle
                (
                        "-fx-background-color: #1c58a8;"
                ));

        this.minimizeBox.setOnMouseExited(event -> this.minimizeBox.setStyle
                (
                        "-fx-background-color: #3179d7;"
                ));

        this.minimizeBox.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                this.stage.setIconified(true);
            }
        });

        // Drag functionality
        this.setOnMousePressed(event -> {

            this.x = event.getSceneX();
            this.y = event.getSceneY();

        });

        this.setOnMouseDragged(event -> {

            this.stage.setX(event.getScreenX() - this.x);
            this.stage.setY(event.getScreenY() - this.y);

        });
    }
}
