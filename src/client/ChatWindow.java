package client;

import app.Main;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class ChatWindow extends AnchorPane {

    private ServerConnection serverConnection;
    private MessagesContainer messagesContainer;
    private OnlineList onlineList;
    private MessageControls messageControls;

    public ChatWindow() {

        this.init();

    }

    private void init() {

        this.messagesContainer = new MessagesContainer();
        this.onlineList = new OnlineList();
        this.serverConnection = new ServerConnection("localhost", 1111, this.onlineList, this.messagesContainer);
        this.messageControls = new MessageControls(this.serverConnection);

        this.setProperties();
        this.setAnchors();

    }

    private void setProperties() {

        this.getChildren().addAll(this.messagesContainer, this.onlineList, this.messageControls);

    }

    private void setAnchors() {

        this.setMinSize(Main.appWidth, Main.appHeight - 40);
        this.setMaxSize(Main.appWidth, Main.appHeight - 40);

        AnchorPane.setTopAnchor(this.messagesContainer, (double) 0);
        AnchorPane.setRightAnchor(this.messagesContainer, (double) 0);
        AnchorPane.setLeftAnchor(this.messagesContainer, (double) 200);
        AnchorPane.setBottomAnchor(this.messagesContainer, (double) 50);

        AnchorPane.setLeftAnchor(this.messageControls, (double) 200);
        AnchorPane.setRightAnchor(this.messageControls, (double) 0);
        AnchorPane.setBottomAnchor(this.messageControls, (double) 0);

        AnchorPane.setTopAnchor(this.onlineList, (double) 0);
        AnchorPane.setLeftAnchor(this.onlineList, (double) 0);
        AnchorPane.setRightAnchor(this.onlineList, (double) 900);
        AnchorPane.setBottomAnchor(this.onlineList, (double) 0);

    }

    public void setUsername(String username) {
        this.serverConnection.setUsername(username);
    }
}
