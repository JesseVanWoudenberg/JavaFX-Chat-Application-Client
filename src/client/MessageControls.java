package client;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class MessageControls extends AnchorPane {

    // ServerConnection object for access to the send message method
    private final ServerConnection serverConnection;

    private TextField messageTextField;
    private Button sendButton;

    public MessageControls(ServerConnection serverConnection) {

        this.serverConnection = serverConnection;
        this.init();

    }

    private void init() {

        this.messageTextField = new TextField();
        this.sendButton = new Button("Send");

        this.styleGUI();
        this.setProperties();
        this.functionality();
        this.setAnchors();

    }

    private void styleGUI() {

        this.messageTextField.setMinSize(830, 50);
        this.messageTextField.setMaxSize(830, 50);
        this.messageTextField.setPromptText("Enter a message");
        this.messageTextField.setFont(new Font("Verdana", 15));

        this.sendButton.setMinSize(70, 50);
        this.sendButton.setMaxSize(70, 50);
        this.sendButton.setStyle
                (
                        "-fx-border-radius: 25;"
                );

    }

    private void setProperties() {

        this.getChildren().addAll(this.messageTextField, this.sendButton);

        this.setMinSize(900, 50);
        this.setMaxSize(900, 50);

    }

    private void setAnchors() {

        AnchorPane.setLeftAnchor(this.messageTextField, (double) 0);
        AnchorPane.setBottomAnchor(this.messageTextField, (double) 0);
        AnchorPane.setRightAnchor(this.messageTextField, (double) 70);

        AnchorPane.setRightAnchor(this.sendButton, (double) 0);
        AnchorPane.setBottomAnchor(this.sendButton, (double) 0);

    }

    private void functionality() {

        this.sendButton.setOnAction(event -> this.sendMessage());
        this.messageTextField.setOnAction(event -> this.sendMessage());

    }

    private void sendMessage() {

        String textFieldMessage = this.messageTextField.getText();

        // Checking for strings that cannot be send to the server in order to avoid errors
        if (!textFieldMessage.equals("") &&
                !textFieldMessage.contains("//DISCONNECT/") &&
                    !textFieldMessage.contains("//JOINED/") &&
                        !textFieldMessage.contains("//UPDATE/")) {

            this.serverConnection.sendMessage(textFieldMessage);
            this.messageTextField.setText("");
        }
    }
}
