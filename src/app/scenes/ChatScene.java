package app.scenes;

import app.Main;
import app.SceneManager;
import app.components.TitleBar;
import client.ChatWindow;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ChatScene extends AnchorPane {

    // Scene nodes
    private TitleBar titleBar;
    private ChatWindow chatWindow;

    private final SceneManager sceneManager;
    private final Stage stage;

    public ChatScene(SceneManager sceneManager, Stage stage) {

        this.sceneManager = sceneManager;
        this.stage = stage;
        this.init();

    }

    private void init() {

        this.initContent();
        this.setProperties();
        this.setAnchors();

    }

    private void initContent() {

        this.titleBar = new TitleBar(this.stage);
        this.chatWindow = new ChatWindow();

    }

    private void setProperties() {

        this.getChildren().addAll(this.chatWindow, this.titleBar);

        this.setMinSize(Main.appWidth, Main.appHeight);
        this.setMaxSize(Main.appWidth, Main.appHeight);

    }

    private void setAnchors() {

        this.setMinSize(Main.appWidth, Main.appHeight);
        this.setMaxSize(Main.appWidth, Main.appHeight);

        AnchorPane.setTopAnchor(this.titleBar, (double) 0);
        AnchorPane.setRightAnchor(this.titleBar, (double) 0);
        AnchorPane.setLeftAnchor(this.titleBar, (double) 0);

        AnchorPane.setTopAnchor(this.chatWindow, (double) 40);
        AnchorPane.setRightAnchor(this.chatWindow, (double) 0);
        AnchorPane.setLeftAnchor(this.chatWindow, (double) 0);
        AnchorPane.setBottomAnchor(this.chatWindow, (double) 0);

    }

    public void setUsername(String username) {
        this.chatWindow.setUsername(username);
    }
}
