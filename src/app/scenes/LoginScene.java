package app.scenes;

import app.Main;
import app.SceneManager;
import app.components.LoginPanel;
import app.components.TitleBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginScene extends AnchorPane {

    // SceneManger and stage object
    private SceneManager sceneManager;
    private final Stage stage;

    // Scene nodes
    private LoginPanel loginPanel;
    private TitleBar titleBar;

    public LoginScene(SceneManager sceneManager, Stage stage) {

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

        this.loginPanel = new LoginPanel(this.sceneManager);
        this.titleBar = new TitleBar(this.stage);

    }

    private void setProperties() {

        this.getChildren().addAll(this.loginPanel, this.titleBar);

        this.setMinSize(Main.appWidth, Main.appHeight);
        this.setMaxSize(Main.appWidth, Main.appHeight);

    }

    private void setAnchors() {

        AnchorPane.setTopAnchor(this.loginPanel, (double) 40);
        AnchorPane.setRightAnchor(this.loginPanel, (double) 0);
        AnchorPane.setLeftAnchor(this.loginPanel, (double) 0);

        AnchorPane.setTopAnchor(this.titleBar, (double) 0);
        AnchorPane.setRightAnchor(this.titleBar, (double) 0);
        AnchorPane.setLeftAnchor(this.titleBar, (double) 0);

    }
}
