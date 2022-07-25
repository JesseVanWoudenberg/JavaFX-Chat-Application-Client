package app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class Main extends Application {

    private Stage stage;

    // ArrayList to store threads so that can be easily accessed and closed on app shutdown event
    private static ArrayList<Thread> threadsArrayList;

    // App dimensions
    public static final short appWidth = 1100;
    public static final short appHeight = 600;

    @Override
    public void start(Stage primaryStage) {

        Main.threadsArrayList = new ArrayList<>();

        this.stage = primaryStage;

        this.stage.initStyle(StageStyle.UNDECORATED);

        // Minimum app dimensions
        this.stage.setMinWidth(appWidth);
        this.stage.setMinHeight(appHeight);

        // Maximum app dimensions
        this.stage.setMaxWidth(appWidth);
        this.stage.setMaxHeight(appHeight);

        // creating scene manager object and setting the scene to login scene
        new SceneManager(this.stage).setLoginScene();

        // Displaying app
        this.stage.show();

        // Implementing an event handler for close requests so the app shuts down properly
        this.stage.setOnCloseRequest(event -> {

            Platform.exit();
            System.exit(0);

        });
    }

    // Public method to close stage
    public void closeStage() {

        this.stage.close();

    }

    // Public method to add thread to private arraylist
    public static void addThreadToList(Thread thread) {

        Main.threadsArrayList.add(thread);

    }

    // Getter for threads arraylist
    public static ArrayList<Thread> getThreadsArrayList() {

        return Main.threadsArrayList;

    }
}
