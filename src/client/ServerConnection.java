package client;

import app.Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerConnection {

    // Messages and OnlineList objects
    private final OnlineList onlineList;
    private final MessagesContainer messagesContainer;

    // Username of chatter
    private String username = "Jesse";

    private final String hostname; // Server IP
    private final int port; // Server Port
    private boolean isConnected = true;
    private DataInputStream input;
    private DataOutputStream output;
    private Socket socket;

    public ServerConnection(String hostname, int port, OnlineList onlineList, MessagesContainer messagesContainer) {

        this.onlineList = onlineList;
        this.messagesContainer = messagesContainer;
        this.hostname = hostname;
        this.port = port;

        this.connect();
    }

    private void connect() {
        try {

            // Creating new socket connection to server
            this.socket = new Socket(this.hostname, this.port);

            // Creating input and output streams for sending and receiving messages
            this.output = new DataOutputStream(this.socket.getOutputStream());
            this.output.writeUTF(this.username);
            this.output.flush();

            this.input = new DataInputStream(this.socket.getInputStream());

            Thread dataReceiverThread = new Thread(this::receiveDataFromServer);
            dataReceiverThread.start();
            Main.addThreadToList(dataReceiverThread);

        } catch (IOException e) { e.printStackTrace(); }
    }

    public void receiveDataFromServer() {

        while (this.isConnected) {

            try {

                String message = this.input.readUTF();
                System.out.println(message); // TEMPORARILY

                // Checking what type of message was received from the server with the '// ... /' prefix
                if (message.contains("//JOINED/")) {

                    String username = message.replace("//JOINED/", "");
                    this.onlineList.addOnlineUser(username);

                } else if (message.contains("//DISCONNECT/")) {
    
                    String username = message.replace("//DISCONNECT/", "");
                    this.onlineList.addOnlineUser(username);

                } else if (message.contains("//UPDATE/")) {

                    // Removing the "//UPDATE/" prefix from the message
                    String usernames = message.replace("//UPDATE/", "");

                    // Separating the usernames and removing the ":" regex and putting the usernames into an array
                    String[] splitUsernames = usernames.split(":");

                    // Removing old username from the list
                    this.onlineList.removeOnlineUser(splitUsernames[0]);

                    // Adding new username to the list
                    this.onlineList.addOnlineUser(splitUsernames[1]);

                } else {

                    this.messagesContainer.addMessage(message);

                }
            } catch (IOException e) { e.printStackTrace(); }
        }
    }

    public void sendMessage(String message) {
        try {

            this.output.writeUTF(this.username + ":" + message);
            this.output.flush();

        } catch (IOException e) { e.printStackTrace(); }
    }

    public void updateName(String oldUsername, String newUsername) {
        try {

            this.output.writeUTF("//UPDATE/" + oldUsername + ":" + newUsername);

        } catch (IOException e) { e.printStackTrace(); }
    }

    public void sendDisconnectSignal() {
        try {

            this.output.writeUTF("//DISCONNECT");

        } catch (IOException e) { e.printStackTrace(); }
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

}
