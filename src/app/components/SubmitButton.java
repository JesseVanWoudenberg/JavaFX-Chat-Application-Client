package app.components;

import app.SceneManager;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class SubmitButton extends Label {

    private final SceneManager sceneManager;
    private final TextArea usernameTextArea;

    public SubmitButton(SceneManager sceneManager, TextArea usernameTextArea) {

        this.sceneManager = sceneManager;
        this.usernameTextArea = usernameTextArea;

        this.init();

    }

    private void init() {

        this.setText("Sign in");
        this.setProperties();
        this.functionality();

    }

    private void setProperties() {

        this.setMinHeight(40);
        // Applying JavaFX CSS
        this.setStyle
                (
                        "-fx-background-color: #3179d7;" +
                                "-fx-font-size: 15;" +
                                "-fx-text-fill: #d7d5d5;" +
                                "-fx-alignment: center;" +
                                "-fx-border-radius: 25;" +
                                "-fx-background-radius: 25;" +
                                "-fx-font-weight: bold;"
                );

    }

    private void functionality() {

        // Event handlers for color changes and action
        this.setOnMouseEntered(event -> {
            this.setStyle
                    (
                            "-fx-background-color: #225fac;" +
                                    "-fx-font-size: 15;" +
                                    "-fx-text-fill: #bdbbbb;" +
                                    "-fx-alignment: center;" +
                                    "-fx-border-radius: 25;" +
                                    "-fx-background-radius: 25;" +
                                    "-fx-font-weight: bold;"
                    );
        });

        this.setOnMouseExited(event -> {
            this.setStyle
                    (
                            "-fx-background-color: #3179d7;" +
                                    "-fx-font-size: 15;" +
                                    "-fx-text-fill: #d7d5d5;" +
                                    "-fx-alignment: center;" +
                                    "-fx-border-radius: 25;" +
                                    "-fx-background-radius: 25;" +
                                    "-fx-font-weight: bold;"
                    );
        });

        this.setOnMousePressed(event -> {
            this.setStyle
                    (
                            "-fx-background-color: #184884;" +
                                    "-fx-font-size: 15;" +
                                    "-fx-text-fill: #aaa8a8;" +
                                    "-fx-alignment: center;" +
                                    "-fx-border-radius: 25;" +
                                    "-fx-background-radius: 25;" +
                                    "-fx-font-weight: bold;"
                    );
        });

        this.setOnMouseReleased(event -> {
            this.setStyle
                    (
                            "-fx-background-color: #3179d7;" +
                                    "-fx-font-size: 15;" +
                                    "-fx-text-fill: #d7d5d5;" +
                                    "-fx-alignment: center;" +
                                    "-fx-border-radius: 25;" +
                                    "-fx-background-radius: 25;" +
                                    "-fx-font-weight: bold;"
                    );
        });

        this.setOnMouseClicked(event -> {

            if (this.usernameTextArea.getLength() > 0) {

                this.sceneManager.setUsername(this.usernameTextArea.getText());
                this.sceneManager.setChatScene();

            }
        });
    }
}
