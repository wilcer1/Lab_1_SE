package com.example.lab1task2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver extends Application {
    private StackPane root;
    private Button receivedButton;

    @Override
    public void start(Stage stage) throws IOException {
        root = new StackPane();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        stage.setTitle("Hello!");
        root.getChildren().add(fxmlLoader.load());
        Scene scene = new Scene(root, 320, 240);
        stage.setScene(scene);
        stage.show();

        new Thread(() -> startServer()).start();
    }

    private void startServer() {
        try {
            ServerSocket server = new ServerSocket(5555);
            while (true) {
                Socket client = server.accept();
                ObjectInputStream in = new ObjectInputStream(client.getInputStream());
                SerializableObject button = (SerializableObject) in.readObject();
                receivedButton = new Button(button.getText());
                // Add the received button to the scene on the JavaFX Application Thread
                Platform.runLater(() -> {
                    ListView<Button> listView = (ListView<Button>) root.lookup("#ListView");
                    listView.getItems().add(receivedButton);
                });
                in.close();
                client.close();
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}