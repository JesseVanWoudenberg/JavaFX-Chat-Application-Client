package client;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MessagesContainer extends ScrollPane {

    private VBox messages;

    public MessagesContainer() {

        this.init();

    }

    private void init() {

        this.initializeMessageBox();
        this.setProperties();

    }

    private void initializeMessageBox() {

        this.messages = new VBox(5);
        this.messages.setMinWidth(492);
        this.messages.setMaxWidth(492);

    }

    private void setProperties() {

        // Putting the message box inside the ScrollPane to make a scrollable chat box
        this.setContent(this.messages);
        // Disabling the Horizontal scrollbar
        this.setHbarPolicy(ScrollBarPolicy.NEVER);
        // Setting fixed size and making the background transparent to show the messages VBox
        this.setMinSize(900, 500);
        this.setMaxSize(900,500);

    }

    public void addMessage(String serverMessage) {

        // Separating username and message
        String[] seperatedStrings = serverMessage.split(":");

        // Creating username text
        Label username = new Label(seperatedStrings[0]);
        username.setMinSize(900, 20);
        username.setMaxSize(900, 20);
        username.setStyle("-fx-font-weight: BOLD; -fx-font-size: 14;");

        // Creating message text
        Text message = new Text(seperatedStrings[1]);
        message.setWrappingWidth(892);
        message.setStyle("-fx-font-size: 14");

        // Creating message container and adding both elements in a container
        VBox messageBox = new VBox(2);
        messageBox.setMinSize(892, 40);
        messageBox.setMaxWidth(892);
        messageBox.setTranslateX(5);
        messageBox.setLayoutX(5);
        messageBox.getChildren().addAll(username, message);

        Platform.runLater(() -> this.messages.getChildren().add(messageBox));

    }
}
