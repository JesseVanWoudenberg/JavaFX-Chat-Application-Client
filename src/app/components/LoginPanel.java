package app.components;

import app.Main;
import app.SceneManager;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.util.Objects;

public class LoginPanel extends AnchorPane {

    private final SceneManager sceneManager;

    // Scene nodes
    Label usernameLabel;
    TextArea usernameTextArea;
    Label submitButton;

    public LoginPanel(SceneManager sceneManager) {

        this.sceneManager = sceneManager;
        this.init();

    }

    private void init() {

        this.createGUI();
        this.styleGUI();
        this.setProperties();
        this.setAnchors();
        // Adding stylesheet for textarea centering
        this.getStylesheets().add(Objects.requireNonNull(getClass().getResource("../../css/style.css")).toExternalForm());

    }

    private void createGUI() {

        // Initializing scene nodes
        this.usernameLabel = new Label("Enter Displayname");
        this.usernameTextArea = new TextArea();
        this.submitButton = new SubmitButton(this.sceneManager, this.usernameTextArea);

    }

    private void styleGUI() {

        // Styling title label
        this.usernameLabel.setFont(new Font("Verdana", 25));
        this.usernameLabel.setTextAlignment(TextAlignment.CENTER);
        this.usernameLabel.setAlignment(Pos.CENTER);
        this.usernameLabel.setFocusTraversable(false);

        // Styling username input TextArea
        this.usernameTextArea.setFocusTraversable(true);
        this.usernameTextArea.setFont(new Font("Verdana", 15));
        // Restricting max username size to 25 Characters
        this.usernameTextArea.setTextFormatter(new TextFormatter<String>(change ->
                change.getControlNewText().length() <= 25 ? change : null));
        // Giving object a CSS ID-Identifier
        this.usernameTextArea.setId("text-area");

        // Styling submit button
        this.submitButton.setFocusTraversable(true);

    }

    private void setProperties() {

        this.getChildren().addAll(this.usernameLabel, this.usernameTextArea, this.submitButton);

        this.setMinSize(Main.appWidth, Main.appHeight - 40);
        this.setMaxSize(Main.appWidth, Main.appHeight - 40);

    }

    private void setAnchors() {

        // Setting anchors for the scene nodes
        AnchorPane.setTopAnchor(this.usernameLabel, (double) 100);
        AnchorPane.setRightAnchor(this.usernameLabel, (double) 400);
        AnchorPane.setLeftAnchor(this.usernameLabel, (double) 400);

        AnchorPane.setTopAnchor(this.usernameTextArea, (double) 160);
        AnchorPane.setRightAnchor(this.usernameTextArea, (double) 350);
        AnchorPane.setLeftAnchor(this.usernameTextArea, (double) 350);
        AnchorPane.setBottomAnchor(this.usernameTextArea, (double) 370);

        AnchorPane.setTopAnchor(this.submitButton, (double) 200);
        AnchorPane.setRightAnchor(this.submitButton, (double) 500);
        AnchorPane.setLeftAnchor(this.submitButton, (double) 500);

    }
}
