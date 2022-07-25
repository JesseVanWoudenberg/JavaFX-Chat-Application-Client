package app;

import app.scenes.ChangeNameScene;
import app.scenes.ChatScene;
import app.scenes.LoginScene;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {

    private final Stage stage;

    // Object variables for methods access
    private final LoginScene loginSceneObject;
    private final ChatScene chatSceneObject;
    private final ChangeNameScene changeNameSceneObject;

    // Scene objects
    private final Scene loginScene;
    private final Scene chatScene;
    private final Scene changeNameScene;

    public SceneManager(Stage stage) {

        this.stage = stage;

        this.loginSceneObject = new LoginScene(this, this.stage);
        this.chatSceneObject = new ChatScene(this, this.stage);
        this.changeNameSceneObject = new ChangeNameScene();

        this.loginScene = new Scene(this.loginSceneObject);
        this.chatScene = new Scene(this.chatSceneObject);
        this.changeNameScene = new Scene(this.changeNameSceneObject);

    }

    // Public methods for changing scenes
    public void setLoginScene() { this.stage.setScene(this.loginScene); }

    public void setChatScene() { this.stage.setScene(this.chatScene); }

    public void setChangeNameScene() { this.stage.setScene(this.changeNameScene); }

    public void setUsername(String username) {
        this.chatSceneObject.setUsername(username);
    }
}
