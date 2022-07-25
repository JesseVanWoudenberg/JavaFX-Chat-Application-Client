package client;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class OnlineList extends ScrollPane {

    private ArrayList<Label> onlineUsers;
    private VBox userList;

    public OnlineList() {

        this.init();

    }

    private void init() {

        this.onlineUsers = new ArrayList<>();
        this.userList = new VBox(5);
        this.setProperties();

    }

    public void addOnlineUser(String username) {

        Platform.runLater(()-> {
            // Creating new username label
            Label userLabel = new Label(username);
            // Styling label
            userLabel.setStyle("-fx-font-weight: BOLD; -fx-font-size: 14;");
            // Adding username label to the list
            this.onlineUsers.add(userLabel);
            this.getChildren().add(formatLabel(userLabel));
            // Reloading online users list
            this.reloadOnlineUsersList();
        });
    }

    public void removeOnlineUser(String username) {

        Platform.runLater(()-> {
            // Removing the name from the list
            this.onlineUsers.removeIf(label -> label.getText().equals(username));
            // Reloading online users list
            this.reloadOnlineUsersList();
        });
    }

    private void reloadOnlineUsersList() {
        // Clearing the online users list
        this.userList.getChildren().clear();
        // Filling the online users list with new names
        for (Label userLabel : this.onlineUsers) {
            this.userList.getChildren().add(userLabel);
        }
    }

    private Label formatLabel(Label label) {

        label.setStyle("-fx-text-fill: #2d2b2b; -fx-font-weight: BOLD; -fx-font-size: 16;");

        return label;
    }

    private void setProperties() {

        this.setContent(this.userList);

        // ScrollPane Style
        this.setMinSize(200, 560);
        this.setMaxSize(200, 560);

        this.userList.setAlignment(Pos.TOP_CENTER);

        // Preventing the horizontal scrollbar from showing ever
        this.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        // UserList VBox Style
        this.userList.setMinWidth(200);
        this.userList.setMaxWidth(200);

    }
}
